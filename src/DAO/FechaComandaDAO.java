/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.ItemFechamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Henrique
 */
public class FechaComandaDAO {
    
    Statement stmt;
    Connection conexao;
    String sql;

    public FechaComandaDAO() {
        this.conexao = AcessaDB.getConnection();
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<ItemFechamento> ListarComandasAbertas () throws SQLException{
        
        stmt = conexao.createStatement();
        sql =   "select cm.Id comandaId, cl.Nome, sum(ip.valor * ip.quantidade) ValorTotal, cl.ValorAcumulado \n" +
                "from comanda cm\n" +
                "left join itemPedido ip on cm.Id = ip.ComandaId\n" +
                "join cliente cl on cl.Id = cm.ClienteId\n" +
                "where cm.FechamentoComandaId is null\n" +
                "group by cl.ValorAcumulado, cl.ValorAcumulado, cl.Nome, cm.Id";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        ArrayList<ItemFechamento> lista = new ArrayList();
        
        while (rs.next()){
            ItemFechamento item = new ItemFechamento();
            item.nomeCliente = rs.getString("Nome");
            item.creditoDisponivel = rs.getFloat("ValorAcumulado");
            item.valorTotal = rs.getFloat("ValorTotal");
            item.comandaId = rs.getInt("comandaId");
            lista.add(item);
        }
            
        return lista;
    }
    
    /**
     *
     * @param comandasId
     * @param valorTotal
     * @throws SQLException
     */
    public void FecharComandas (String comandasId, float valorTotal) throws SQLException {
        
        stmt = conexao.createStatement();
        conexao.setAutoCommit(false);
        
        try{
            //insert na tabela de fechamentocomanda
            sql = "insert FechamentoComanda values (" + valorTotal + ") select @@identity FechamentoComandaId";
            int fechamentoComandaId = 0;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                fechamentoComandaId = rs.getInt("FechamentoComandaId");
            }

            //update na tabela de comanda colocando o fechamentoId
            sql = "update Comanda "
                + "set FechamentoComandaId = " + fechamentoComandaId
                + " where id in (" + comandasId + ")";

            stmt.executeUpdate(sql);

            //update nos clientes das comandas, subtraindo o credito disponivel do valor total, se necessario
            sql =   "with cte as (\n" +
                    "   select cl.Id, case when cl.ValorAcumulado > sum (ip.valor * ip.quantidade) then sum(ip.valor * ip.quantidade) else cl.ValorAcumulado end ValorADescontar\n" +
                    "   from ItemPedido ip\n" +
                    "   join comanda cm on cm.Id = ip.ComandaId\n" +
                    "   join cliente cl on cl.Id = cm.ClienteId\n" +
                    "   where comandaId in (" + comandasId + ")\n" +
                    "   group by cl.Id, cl.ValorAcumulado \n" +
                    ")\n" +
                    "update cliente \n" +
                    "set valorAcumulado = valorAcumulado - ValorADescontar\n" +
                    "from cliente c\n" +
                    "join cte on c.Id = cte.Id \n" +
                    "where ValorADescontar <> 0 ";

            stmt.executeUpdate(sql);
            
            conexao.commit();
        }
        catch (SQLException e){
            conexao.rollback();
        }
        finally{
            conexao.setAutoCommit(true);
        }
    }
    
    public String gerarRecibo (String comandasId, float ValorTotalAPagar) throws SQLException{
        String[] comandas;
        comandas = comandasId.split(",");
        stmt = conexao.createStatement();
        
        
        String retorno = "                       Recibo                       \n\n"
                       + "====================================================\n\n";
        float valorTotalGeral = 0;
        for (String comandaId : comandas) {
            retorno += "Comanda ID: #" + comandaId + "\n\n";
            retorno += "ID   Produto             Qtde            Valor\n";
            sql =   "select ip.Id, p.Nome, ip.Quantidade, p.Valor * ip.Quantidade ValorTotal\n" +
                "from ItemPedido ip\n" +
                "join produto p on ip.ProdutoId = p.Id\n" +
                "where comandaId = " + comandaId;
            
            ResultSet rs = stmt.executeQuery(sql);
            float valorTotalComanda = 0;
            while(rs.next()){
               retorno += AlinharCampo(String.valueOf(rs.getInt("id")), 5, "E") + 
                          AlinharCampo(rs.getString("nome"), 20, "E") + 
                          AlinharCampo(String.valueOf(rs.getInt("quantidade")), 4, "D") +
                          AlinharCampo(String.valueOf(rs.getFloat("ValorTotal")), 17, "D") + "\n";
                          valorTotalComanda += rs.getFloat("ValorTotal");
            }
            valorTotalGeral += valorTotalComanda;
            retorno += "\n\nTotal da Comanda: " + AlinharCampo(String.valueOf(valorTotalComanda), 28, "D");
            retorno += "\n----------------------------------------------------\n";
        }
        retorno += "\nValor Total Geral:   " + AlinharCampo("R$" + String.valueOf(valorTotalGeral), 25, "D");
        retorno += "\n\n\nValor Total A Pagar: " + AlinharCampo("R$" + String.valueOf(ValorTotalAPagar), 25, "D");
        
        return retorno;
    }
    
    private String AlinharCampo(String texto, int tamanho, String alinhamento){
        
        
        if(texto.length() > tamanho){
            texto = texto.substring(0, tamanho);
        }
        else{
            if("E".equals(alinhamento)){
                texto += String.join("", Collections.nCopies(tamanho - texto.length(), " "));
            }
            else{
                texto = String.join("", Collections.nCopies(tamanho - texto.length(), " ")) + texto;
            }
        }
        
        return texto;
    }
}

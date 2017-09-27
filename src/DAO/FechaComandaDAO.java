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
                "from itemPedido ip\n" +
                "join comanda cm on cm.Id = ip.ComandaId\n" +
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
            
            //retornar o valor total
            
            conexao.commit();
        }
        catch (SQLException e){
            conexao.rollback();
        }
        finally{
            conexao.setAutoCommit(true);
        }
    }
    
    public String gerarRecibo (String comandasId, float ValorTotalAPagar){
        String comandas[] = comandasId.split(",");

        String retorno = comandasId + " " + String.valueOf(ValorTotalAPagar);
        
        
        return retorno;
    }
}

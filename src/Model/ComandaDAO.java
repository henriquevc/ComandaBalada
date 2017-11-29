/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class ComandaDAO {
    static Statement stmt;
    static Connection conexao =  AcessaDB.getConnection();
    static String sql;

    public static void Incluir(Comanda cmd) throws SQLException {
        
        stmt = conexao.createStatement();
        int comandaId = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = dtf.format(LocalDate.now());
        
        sql = "INSERT INTO comanda values (" + cmd.getClienteId() + ", null, '" + data + "') select @@identity comandaId";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            comandaId = rs.getInt("comandaId");
        }
        if(comandaId > 0){
            JOptionPane.showMessageDialog(null, "Comanda gerada com o ID: " + comandaId);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar a comanda", "ERRO", 0);
        }
    }

    public void Alterar(Comanda cmd) throws SQLException {
        stmt = conexao.createStatement();
        
        sql = "update comanda set ClienteId = " + cmd.getClienteId() 
                             + ", FechamentoComandaId = " + cmd.getFechamentoComandaId()
                             + " where id = " + cmd.getId();
        
        if(stmt.executeUpdate(sql) > 0){
            JOptionPane.showMessageDialog(null, "Comanda atualizada com com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
    }
    
    public static Comanda Buscar (int id) throws SQLException {
        stmt = conexao.createStatement();
        
        sql = "select * from comanda where id = " + id;
        
        Comanda cmd = new Comanda();
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            cmd.setId(rs.getInt("Id"));
            cmd.setClienteId(rs.getInt("ClienteId"));
            cmd.setFechamentoComandaId(rs.getInt("FechamentoComandaId"));
            cmd.setData(rs.getString("Data"));
        }
        
        return cmd;
    }
    
    public void Excluir (int id) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "delete comanda where id = " + id;
        
        if(stmt.executeUpdate(sql) > 0){
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
    }
    
    public static ResultSet ListarPedidos (int comandaId) throws SQLException {
        stmt = conexao.createStatement();
        sql = "select * from ItemPedido where comandaId = " + comandaId;
        
        return stmt.executeQuery(sql);
    }
    
    public static ResultSet ListarComandasPorData (String data) throws SQLException {
        
        stmt = conexao.createStatement();
        if ("".equals(data)){
            sql = "select co.Id, cl.Nome, co.Data, sum(ip.Valor * ip.Quantidade) ValorTotal "
                + "from comanda co "
                + "join cliente cl on cl.Id = co.ClienteId "
                + "left join itemPedido ip on ip.ComandaId = co.Id "
                + "group by co.Id, cl.Nome, co.Data";
        }
        else {
            sql = "select co.Id, cl.Nome, sum(ip.Valor * ip.Quantidade) ValorTotal "
                + "from comanda co "
                + "join cliente cl on cl.Id = co.ClienteId "
                + "left join itemPedido ip on ip.ComandaId = co.Id "
                + "where co.Data = '" + data + "' "
                + "group by co.Id, cl.Nome";
        }
        
        return stmt.executeQuery(sql);   
        
    }
    
    public static boolean ComandaAbertaCliente (int clienteId) throws SQLException{
        stmt = conexao.createStatement();
        sql = "select 1 existe from comanda where fechamentoComandaId is null and clienteId = " + clienteId;
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs.next();
    }
    
    public static boolean ComandaAberta (int comandaId) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "select 1 existe from comanda where fechamentoComandaId is null and Id = " + comandaId;
        
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs.next();
    } 
}


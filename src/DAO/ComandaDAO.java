/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Cliente;
import Classes.Comanda;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class ComandaDAO {
    Statement stmt;
    Connection conexao;
    String sql;

    public ComandaDAO() {
        this.conexao = AcessaDB.getConnection();
    }
        
    public void Incluir(Comanda cmd) throws SQLException {
        
        stmt = conexao.createStatement();
        int comandaId = 0;
        sql = "INSERT INTO comanda values (" + cmd.getClienteId() + ", null) select @@identity comandaId";
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
    
    public Comanda Buscar (int id) throws SQLException {
        stmt = conexao.createStatement();
        
        sql = "select * from comanda where id = " + id;
        
        Comanda cmd = new Comanda();
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            cmd.setClienteId(rs.getInt("Id"));
            cmd.setClienteId(rs.getInt("ClienteId"));
            cmd.setFechamentoComandaId(rs.getInt("FechamentoComandaId"));
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandabalada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class AcessaDB {
    
    Connection conexao;
    Statement stmt;
    String sql;
    
    public AcessaDB() {
        
    }
    
    public Connection getConnection () throws SQLException {
        Connection con;
        String url, user, password;
        url = "jdbc:sqlserver://servagilus.dyndns.org:1433;databaseName=dbComandaBalada";
        user = "claudio";
        password = "op@58523";
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
    public void SalvarCliente (Cliente cli) throws SQLException{
        conexao = getConnection();
        stmt = conexao.createStatement();
        
        sql = "INSERT INTO cliente values ('" + cli.getNome() + "','"
                                              + cli.getCpf() + "','"
                                              + cli.getTelefone()+ "',"
                                              + cli.getValorAcumulado() + ")";
        
        if(stmt.executeUpdate(sql) > 0){
            JOptionPane.showMessageDialog(null, "Dados do cliente inseridos com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
    }
}

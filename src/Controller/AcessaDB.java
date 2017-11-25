/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static Connection getConnection () {
    
        Connection con = null;
        String url, user, password;
        url = "jdbc:sqlserver://servagilus.dyndns.org:11000;databaseName=dbComandaBalada";
        user = "claudio";
        password = "op@58523";
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(AcessaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
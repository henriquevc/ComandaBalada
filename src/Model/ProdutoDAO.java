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
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class ProdutoDAO {
    
    static Statement stmt;
    static Connection conexao = AcessaDB.getConnection();
    static String sql;

 
    public static void Incluir(Produto prod) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "INSERT INTO PRODUTO VALUES ('" + prod.getNome() + "', " + prod.getValor() + ") ";
        
        if (stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Dados do produto inseridos com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
            
    }
    
    public static void Alterar (Produto prod) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "update produto set nome = '" + prod.getNome() + "',"
                              + " Valor = " + prod.getValor()
           + " where id = " + prod.getId();
        
        if(stmt.executeUpdate(sql) > 0){
            JOptionPane.showMessageDialog(null, "Dados do produto alterado com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
    }
    
    public static void Excluir (int produtoId) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "delete produto where id = " + produtoId;
        
        if(stmt.executeUpdate(sql) > 0 ){
           JOptionPane.showMessageDialog(null, "produto excluido com sucesso!"); 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao excluir o produto, talvez possua dependecias", "ERRO", 0);
        }
    }
    
    public static ResultSet Buscar (String prodDescricao) throws SQLException{
        
        stmt = conexao.createStatement();
        sql = "select * from produto where nome like '%" + prodDescricao + "%'";
        return stmt.executeQuery(sql);

    }
    
    public static ResultSet BuscarNomeProduto (int produtoId) throws SQLException {
        stmt = conexao.createStatement();
        
        sql = "select nome from produto where id = " + produtoId;
        
        return stmt.executeQuery(sql);
    }
    
    public static ResultSet Buscar (int produtoId) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "select * from produto where id = " + produtoId;
        
        return stmt.executeQuery(sql);
        
    }
    
    public static ResultSet Listar () throws SQLException {
        
        stmt = conexao.createStatement();
        sql = "select * from produto";
        return stmt.executeQuery(sql);
        
    }
}

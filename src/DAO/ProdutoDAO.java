/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class ProdutoDAO {
    
    Statement stmt;
    Connection conexao;
    String sql;

    public ProdutoDAO() {
        this.conexao = AcessaDB.getConnection();
    }
    
    public void Incluir(Produto prod) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "INSERT INTO PRODUTO VALUES ('" + prod.getNome() + "', " + prod.getValor() + ") ";
        
        if (stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Dados do produto inseridos com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
            
    }
    
    public void Alterar (Produto prod) throws SQLException{
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
    
    public void Excluir (int produtoId) throws SQLException{
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
    
    public Produto Buscar (String prodDescricao) throws SQLException{
        
        stmt = conexao.createStatement();
        
        sql = "select * from produto where nome like '%" + prodDescricao + "%'";
        
        ResultSet rs = stmt.executeQuery(sql);
        Produto produto = new Produto();
        while (rs.next()){
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getFloat("valor"));
        }
        return produto;
    }
    
    public String BuscarNomeProduto (int produtoId) throws SQLException {
        stmt = conexao.createStatement();
        
        sql = "select nome from produto where id = " + produtoId;
        String nomeProduto = "";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            nomeProduto = rs.getString("nome");
        }
        
        return nomeProduto;
    }
    
    public Produto Buscar (int produtoId) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "select * from produto where id = " + produtoId;
        Produto prod = new Produto();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            prod.setId(rs.getInt("id"));
            prod.setNome(rs.getString("nome"));
            prod.setValor(rs.getFloat("valor"));
        }
        
        return prod;
    }
    
    public List<String> Listar () throws SQLException {
        ArrayList<String> listProdutos = new ArrayList<>();
        stmt = conexao.createStatement();
        sql = "select * from produto";
        String[] produtos;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            listProdutos.add(rs.getString("nome"));
        }
        return listProdutos;
    }
}

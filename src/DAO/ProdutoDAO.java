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
    
    public void Excluir (Produto prod){
        
    }
    
    public Produto Buscar (String prodDescricao){
        return new Produto();
    }
    
    public List<Produto> Listar () throws SQLException{
        ArrayList listProd = new ArrayList<>();
        stmt = conexao.createStatement();
        sql = "select * from produto";
        
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Produto p = new Produto();
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getFloat("valor"));
            p.setId(rs.getInt("id"));
            listProd.add(p);
        }
        
        return listProd;
    }
}

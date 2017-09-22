/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Produto;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    
    public void Incluir(Produto prod){
        
    }
    
    public void Alterar (Produto prod){
    
    }
    
    public void Excluir (Produto prod){
        
    }
    
    public Produto Buscar (String prodDescricao){
        return new Produto();
    }
    
    public List<Produto> Listar (Produto prod){
        ArrayList listProd = new ArrayList<>();
        
        return listProd;
    }
}

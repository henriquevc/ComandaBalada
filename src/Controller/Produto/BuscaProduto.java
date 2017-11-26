/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Produto;

import Model.Produto;
import Model.ProdutoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claud
 */
public class BuscaProduto {
    
    public static Produto Buscar(int produtoId) throws SQLException{
        
        ResultSet rs = ProdutoDAO.Buscar(produtoId);
        Produto prod = new Produto();
        while(rs.next()){
            prod.setId(rs.getInt("id"));
            prod.setNome(rs.getString("nome"));
            prod.setValor(rs.getFloat("valor"));
        }
        return prod;
    }
    
    public static Produto Buscar(String nomeProduto) throws SQLException{
        ResultSet rs = ProdutoDAO.Buscar(nomeProduto);
        Produto produto = new Produto();
        while (rs.next()){
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getFloat("valor"));
        }
        return produto;
    }
    
    public static String BuscarNomeProduto (int produtoId) throws SQLException{
        
        String nomeProduto = "";
        ResultSet rs = ProdutoDAO.BuscarNomeProduto(produtoId);
        while(rs.next()){
            nomeProduto = rs.getString("nome");
        }
        
        return nomeProduto;
    }
    
        public static List<Produto> Listar () throws SQLException {
        ArrayList<Produto> listProdutos = new ArrayList<>();
        ResultSet rs = ProdutoDAO.Listar();
        while(rs.next()){
            Produto p = new Produto();
            p.setId(rs.getInt("Id"));
            p.setNome(rs.getString("Nome"));
            p.setValor(rs.getFloat("Valor"));
            listProdutos.add(p);
        }
        return listProdutos;
    }
}

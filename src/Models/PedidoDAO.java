/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Produto;
import Controller.AcessaDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class PedidoDAO {
    Statement stmt;
    Connection conexao;
    String sql;

    public PedidoDAO() {
        this.conexao = AcessaDB.getConnection();
    }

    public void registraPedido(int comandaId, String produtoSelecionado, int quantidade) throws SQLException {
        Produto produto = new ProdutoDAO().Buscar(produtoSelecionado);
        
        stmt = conexao.createStatement();
        
        sql = "insert into ItemPedido values (" + produto.getId() + "," + comandaId + "," + produto.getValor() + ", " + quantidade + ")";
        
        if(stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "ERRO ao gravar o pedido, tente novamente", "ERRO", 0);
            
    }
    
    public boolean ComandaAberta (int comandaId) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "select 1 existe from comanda where fechamentoComandaId is null and Id = " + comandaId;
        
        ResultSet rs = stmt.executeQuery(sql);
        
        return rs.next();
    } 
    
    
}

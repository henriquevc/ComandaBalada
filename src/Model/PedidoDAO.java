/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Produto.BuscaProduto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class PedidoDAO {
    static Statement stmt;
    static Connection conexao = AcessaDB.getConnection();
    static String sql;



    public static void RegistraPedido(int comandaId, String produtoSelecionado, int quantidade) throws SQLException {
        Produto produto = BuscaProduto.Buscar(produtoSelecionado);
        
        stmt = conexao.createStatement();
        
        sql = "insert into ItemPedido values (" + produto.getId() + "," + comandaId + "," + produto.getValor() + ", " + quantidade + ")";
        
        if(stmt.executeUpdate(sql) > 0)
            JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "ERRO ao gravar o pedido, tente novamente", "ERRO", 0);
            
    }
    

    
    
}

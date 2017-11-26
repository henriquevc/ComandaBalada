/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Pedido;

import Model.PedidoDAO;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class IncluiPedido {
    
    public static void RegistraPedido(int comandaId, String produtoSelecionado, int quantidade) throws SQLException {
        PedidoDAO.RegistraPedido(comandaId, produtoSelecionado, quantidade);
    }
}

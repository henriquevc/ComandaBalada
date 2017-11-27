/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Comanda;

import Model.Comanda;
import Model.ComandaDAO;
import Model.ComandaRelatorio;
import Model.ItemPedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author claud
 */
public class BuscaComanda {
    
    public static Comanda Buscar (int comandaId) throws SQLException{
        return ComandaDAO.Buscar(comandaId);
    }
    
    public static ArrayList<ItemPedido> ListarPedidosComanda (int comandaId) throws SQLException{
        
        ResultSet rs = ComandaDAO.ListarPedidos(comandaId);
        ArrayList<ItemPedido> itensPedido = new ArrayList();
        while (rs.next()){
            ItemPedido item = new ItemPedido();
            item.setId(rs.getInt("Id"));
            item.setProdutoId(rs.getInt("ProdutoId"));
            item.setValor(rs.getDouble("Valor"));
            item.setQuantidade(rs.getInt("quantidade"));
            itensPedido.add(item);
        }
        
        return itensPedido;
    }
    
    public static boolean ComandaAbertaCliente (int clienteId) throws SQLException{
        return ComandaDAO.ComandaAbertaCliente(clienteId);
    }
    
    public static boolean ComandaAberta (int clienteId) throws SQLException{
        return ComandaDAO.ComandaAberta(clienteId);
    }
    
    /*
    public ArrayList<ComandaRelatorio> ListarComandasPorData (String data) throws SQLException {
        ArrayList<ComandaRelatorio> lista = new ArrayList();
        ResultSet rs = ComandaDAO.ListarComandasPorData(data);
        while (rs.next()){
            ComandaRelatorio cmdR = new ComandaRelatorio(rs.getInt("Id"), rs.getString("Nome"), rs.getFloat("ValorTotal"));
            lista.add(cmdR);
        }
        return lista;
    }
    */
    
    public static ResultSet ListarComandasPorData (String data) throws SQLException {
        return ComandaDAO.ListarComandasPorData(data);
    }
}
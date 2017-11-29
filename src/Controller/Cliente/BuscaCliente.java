/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cliente;

import Model.Cliente;
import Model.ClienteDAO;
import View.FrameCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claud
 */
public class BuscaCliente {
    
    public static Cliente Buscar(int clienteId) throws SQLException{
        return ClienteDAO.Buscar(clienteId);
    }
    
    public static Cliente BuscaClienteCPF (String cpf) throws SQLException{
        Cliente cliente = new Cliente();
        try{
            cliente = ClienteDAO.BuscaCPF(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }
    
    public static String BuscarNome(int clienteId) throws SQLException{
        return ClienteDAO.BuscarNomeCliente(clienteId);
    }
    
    public static ResultSet Listar () throws SQLException {
        return ClienteDAO.Listar();
    }
    
    
}

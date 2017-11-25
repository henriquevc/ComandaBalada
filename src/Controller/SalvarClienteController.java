/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Cliente;
import Models.ClienteDAO;
import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class SalvarClienteController {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public int SalvarCliente(Cliente cli) throws SQLException {
        return clienteDAO.Salvar(cli);
    }
}

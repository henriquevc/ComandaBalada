/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cliente;

import Model.Cliente;
import Model.ClienteDAO;
import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class SalvaCliente {
    
    public static int Salvar(Cliente cli) throws SQLException {
        return ClienteDAO.Salvar(cli);
    }
}

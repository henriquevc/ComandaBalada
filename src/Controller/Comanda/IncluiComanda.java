/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Comanda;

import Model.Comanda;
import Model.ComandaDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author claud
 */
public class IncluiComanda {
    
    public static void Incluir(Comanda comanda, int clienteId) throws SQLException{
        
        if (!BuscaComanda.ComandaAbertaCliente(clienteId)){
            comanda.setClienteId(clienteId);
            ComandaDAO.Incluir(comanda);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Já existe uma comanda aberta pra esse cliente", "ERRO", 0);
        }
    }
    

}

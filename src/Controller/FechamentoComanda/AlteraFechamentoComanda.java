/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.FechamentoComanda;

import Model.FechaComandaDAO;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class AlteraFechamentoComanda {
    
    public static void FecharComandas (String comandasId, float valorTotal) throws SQLException{
        FechaComandaDAO.FecharComandas(comandasId, valorTotal);
    }
    
    public static String GerarRecibo (String comandasId, float valorTotalAPagar) throws SQLException{
        return FechaComandaDAO.GerarRecibo(comandasId, valorTotalAPagar);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.FechamentoComanda;

import Model.FechaComandaDAO;
import Model.ItemFechamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author claud
 */
public class BuscaFechamentoComanda {
    
    public static ArrayList<ItemFechamento> ListarComandasAbertas () throws SQLException{
        
        ArrayList<ItemFechamento> lista = new ArrayList();
        ResultSet rs = FechaComandaDAO.ListarComandasAbertas();
        while (rs.next()){
            ItemFechamento item = new ItemFechamento();
            item.nomeCliente = rs.getString("Nome");
            item.creditoDisponivel = rs.getFloat("ValorAcumulado");
            item.valorTotal = rs.getFloat("ValorTotal");
            item.comandaId = rs.getInt("comandaId");
            lista.add(item);
        }
            
        return lista;
    }
    
    public static ResultSet GerarRecibo (String comandaId){
        return FechaComandaDAO.RelatorioGerarRecibo(comandaId);
    }
}

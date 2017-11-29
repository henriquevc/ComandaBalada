/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Cliente;

import Model.Cliente;
import Model.ClienteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class BuscaCliente {
    
    public static Cliente Buscar(int clienteId) throws SQLException{
        Cliente cliente = new Cliente();
        ResultSet rs = ClienteDAO.Buscar(clienteId);
        
        while (rs.next()){
            cliente.setId(rs.getInt("id"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setValorAcumulado(rs.getFloat("valoracumulado"));
        }
        
        return cliente;
    }
    
    public static Cliente BuscaClienteCPF (String cpf) throws SQLException{
        
        ResultSet rs = ClienteDAO.BuscarCPF(cpf);
        Cliente cliente = new Cliente();
        
        while(rs.next()){
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setValorAcumulado(rs.getFloat("valoracumulado"));
        }//fim do while

        return cliente;
    }
    
    public static String BuscarNome(int clienteId) throws SQLException{
        
        ResultSet rs = ClienteDAO.BuscarNomeCliente(clienteId);
        String nome = "";
        
        while (rs.next()){
            nome = rs.getString("nome");
        }
        
        return nome;
    }
    
    public static ResultSet Listar () throws SQLException {
        return ClienteDAO.Listar();
    }
    
    
}

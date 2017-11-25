/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Cliente;
import Controller.AcessaDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class ClienteDAO {
    
    Statement stmt;
    Connection conexao;
    String sql;

    public ClienteDAO() {
        this.conexao = AcessaDB.getConnection();
    }
    
    public int Salvar (Cliente cli) throws SQLException{
        int idCliente = 0;
        if (cli.getId() == 0)
            idCliente = Incluir(cli);
        else{
            Alterar(cli);
            idCliente = cli.getId();
        }
        return idCliente;
    }
    public int Incluir (Cliente cli) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "INSERT INTO cliente values ('" + cli.getNome() + "','"
                                              + cli.getCpf() + "','"
                                              + cli.getTelefone()+ "',"
                                              + cli.getValorAcumulado() + ") select @@identity idGerado";
        int idCliente = 0;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            idCliente = rs.getInt("idGerado");
        }
        
        if( idCliente > 0 ){
            JOptionPane.showMessageDialog(null, "Dados do cliente inseridos com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
        return idCliente;
    }
    
    public void Alterar (Cliente cliente) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = String.format("update cliente set nome = '%s', "
                                         + "cpf = '%s', "
                                         + "telefone = '%s', "
                                         + "valoracumulado = " + cliente.getValorAcumulado()
                          + " where id = %d", cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getId());
        //converter o float para double (, para .)

        
        if(stmt.executeUpdate(sql) > 0){
            JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERRO ao gravar no Banco", "ERRO", 0);
        }
    }
    
    public Cliente Buscar (int id) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "select * from cliente where id = " + id;
        
        Cliente cliente = new Cliente();
        
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            cliente.setId(rs.getInt("id"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setValorAcumulado(rs.getFloat("valoracumulado"));
        }
        
        return cliente;
    }
    
    public String BuscarNomeCliente (int id) throws SQLException {
        stmt = conexao.createStatement();
        sql = "select Nome from cliente where id = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        String nome = "";
        while (rs.next()){
            nome = rs.getString("nome");
        }
        return nome;
    }
    
    public void Excluir (int id) throws SQLException {
        stmt = conexao.createStatement();
        
        sql = "delete cliente where id = " + id;
        
        stmt.executeUpdate(sql);
    }
    
    public Cliente BuscaCPF (String cpf) throws SQLException{
        stmt = conexao.createStatement();
        
        sql = "select * from cliente where cpf = '" + cpf + "'";
        Cliente cliente = new Cliente();
        
        ResultSet rs = stmt.executeQuery(sql);
        try {
            while(rs.next()){
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setValorAcumulado(rs.getFloat("valoracumulado"));
            }//fim do while
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CPF não encontrado" + ex.getMessage(), "ERRO", 0);
        }
        
        return cliente;
    }
}

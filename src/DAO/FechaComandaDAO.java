/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.ItemFechamento;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class FechaComandaDAO {
    
    Statement stmt;
    Connection conexao;
    String sql;

    public FechaComandaDAO() {
        this.conexao = AcessaDB.getConnection();
    }
    
    public ArrayList<ItemFechamento> ListarComandasAbertas () throws SQLException{
        ItemFechamento item = new ItemFechamento();
        
        stmt = conexao.createStatement();
        sql = "select sum(valor * quantidade) from itemPedido join ";
        item.nomeCliente = "Henrique";
        item.creditoDisponivel = (float) 150.2;
        item.valorTotal = 200;
        item.comandaId = 9;
        
        
        
        return null;
        
    }
}

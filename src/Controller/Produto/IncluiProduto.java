/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Produto;

import Model.Produto;
import Model.ProdutoDAO;
import java.sql.SQLException;

/**
 *
 * @author claud
 */
public class IncluiProduto {

    public static void Incluir(Produto produto) throws SQLException {
        ProdutoDAO.Incluir(produto);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Henrique
 */
public class FechamentoComanda {
    private int id;
    private List<Comanda> comandas;

    public FechamentoComanda(int id, List<Comanda> comandas) {
        this.id = id;
        this.comandas = comandas;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
    
    
}

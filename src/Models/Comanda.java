/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author Henrique
 */
public class Comanda {
    
    private int id;
    private int clienteId;
    private int FechamentoComandaId;
    private List<ItemPedido> itensPedido;
    private String data;

    public Comanda() {
    }

    public Comanda(int id, int clienteId, int FechamentoComandaId, List<ItemPedido> itensPedido, String data) {
        this.id = id;
        this.clienteId = clienteId;
        this.FechamentoComandaId = FechamentoComandaId;
        this.itensPedido = itensPedido;
        this.data = data;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getFechamentoComandaId() {
        return FechamentoComandaId;
    }

    public void setFechamentoComandaId(int FechamentoComandaId) {
        this.FechamentoComandaId = FechamentoComandaId;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}

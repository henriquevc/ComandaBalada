/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandabalada;

/**
 *
 * @author Henrique
 */
public class ItemPedido {
    private int id;
    private int produtoId;
    private int comandaId;
    private double valor;

    public ItemPedido(int id, int produtoId, int comandaId, double valor) {
        this.id = id;
        this.produtoId = produtoId;
        this.comandaId = comandaId;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getComandaId() {
        return comandaId;
    }

    public void setComandaId(int comandaId) {
        this.comandaId = comandaId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}

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
public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private double valorAcumulado;

    //construtor vazio
    public Cliente()
    {
        
    }
    
    public Cliente(int id, String nome, String cpf, String telefone, float valorAcumulado) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.valorAcumulado = valorAcumulado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(float valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }
}

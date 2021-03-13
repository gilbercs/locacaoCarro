/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.model;

/**
 *
 * @author Gilber
 */
public class ModelCliente {
    private int cliCodigo;
    private String cliNome;
    private int idade;
    private String cliCnh;
    private String cliRua;
    private int cliNumero;
    private String cliCep;
    private String cliBairro;
    private String cliCidade;
    private String cliUf;

    public ModelCliente() {
    }

    public int getCliCodigo() {
        return this.cliCodigo;
    }

    public void setCliCodigo(int cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNome() {
        return this.cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCliCnh() {
        return cliCnh;
    }

    public void setCliCnh(String cliCnh) {
        this.cliCnh = cliCnh;
    }

    public String getCliRua() {
        return cliRua;
    }

    public void setCliRua(String cliRua) {
        this.cliRua = cliRua;
    }

    public int getCliNumero() {
        return cliNumero;
    }

    public void setCliNumero(int cliNumero) {
        this.cliNumero = cliNumero;
    }

    public String getCliCep() {
        return cliCep;
    }

    public void setCliCep(String cliCep) {
        this.cliCep = cliCep;
    }

    public String getCliBairro() {
        return cliBairro;
    }

    public void setCliBairro(String cliBairro) {
        this.cliBairro = cliBairro;
    }

    public String getCliCidade() {
        return cliCidade;
    }

    public void setCliCidade(String cliCidade) {
        this.cliCidade = cliCidade;
    }

    public String getCliUf() {
        return cliUf;
    }

    public void setCliUf(String cliUf) {
        this.cliUf = cliUf;
    }

    @Override
    public String toString() {
        return "ModelCliente{" + "cliCodigo=" + cliCodigo + ", cliNome=" + cliNome + ", idade=" + idade + ", cliCnh=" + cliCnh + ", cliRua=" + cliRua + ", cliNumero=" + cliNumero + ", cliCep=" + cliCep + ", cliBairro=" + cliBairro + ", cliCidade=" + cliCidade + ", cliUf=" + cliUf + '}';
    }
    
    
}

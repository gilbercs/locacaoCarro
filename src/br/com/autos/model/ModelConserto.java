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
public class ModelConserto {
    private int conCodigo;
    private String conDia;
    private double conValor;
    private String conDescricao;
    private int conOfiCodigo;
    private int conCarCodigo;
    private ModelOficina modelOficina;
    private ModelCarro modelCarro;

    public ModelConserto() {
    }

    public int getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(int conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConDia() {
        return conDia;
    }

    public void setConDia(String conDia) {
        this.conDia = conDia;
    }

    public double getConValor() {
        return conValor;
    }

    public void setConValor(double conValor) {
        this.conValor = conValor;
    }

    public String getConDescricao() {
        return conDescricao;
    }

    public void setConDescricao(String conDescricao) {
        this.conDescricao = conDescricao;
    }

    public int getConOfiCodigo() {
        return conOfiCodigo;
    }

    public void setConOfiCodigo(int conOfiCodigo) {
        this.conOfiCodigo = conOfiCodigo;
    }

    public int getConCarCodigo() {
        return conCarCodigo;
    }

    public void setConCarCodigo(int conCarCodigo) {
        this.conCarCodigo = conCarCodigo;
    }

    public ModelOficina getModelOficina() {
        return modelOficina;
    }

    public void setModelOficina(ModelOficina modelOficina) {
        this.modelOficina = modelOficina;
    }

    public ModelCarro getModelCarro() {
        return modelCarro;
    }

    public void setModelCarro(ModelCarro modelCarro) {
        this.modelCarro = modelCarro;
    }
    
}

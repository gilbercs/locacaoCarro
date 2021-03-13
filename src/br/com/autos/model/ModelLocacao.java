/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.model;

import java.util.*;



/**
 *
 * @author Gilber
 * @version 1.0
 */
public class ModelLocacao {
    private int locCodigo;
    private String locData;
    private String locHora;
    private String locDataDevolucao;
    private String locHoraDevolucao;
    private double locValorTotal;
    private int qtdDias;
    private String situacao;
    //foreign key
    private int locFunMatricula;
    private int locCarCodigo;
    private int locCliCodigo;
    private ModelFuncionario modelFuncionario;
    private ModelCarro modelCarro;
    private ModelCliente modelCliente;
    private ArrayList<ModelLocacao> listAlocacao;
    //construtor
    public ModelLocacao() {
    } 

    public int getLocCodigo() {
        return locCodigo;
    }

    public void setLocCodigo(int locCodigo) {
        this.locCodigo = locCodigo;
    }

    public String getLocData() {
        return locData;
    }

    public void setLocData(String locData) {
        this.locData = locData;
    }

    public String getLocHora() {
        return locHora;
    }

    public void setLocHora(String locHora) {
        this.locHora = locHora;
    }

    public String getLocDataDevolucao() {
        return locDataDevolucao;
    }

    public void setLocDataDevolucao(String locDataDevolucao) {
        this.locDataDevolucao = locDataDevolucao;
    }

    public String getLocHoraDevolucao() {
        return locHoraDevolucao;
    }

    public void setLocHoraDevolucao(String locHoraDevolucao) {
        this.locHoraDevolucao = locHoraDevolucao;
    }

    public double getLocValorTotal() {
        return locValorTotal;
    }

    public void setLocValorTotal(double locValorTotal) {
        this.locValorTotal = locValorTotal;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getLocFunMatricula() {
        return locFunMatricula;
    }

    public void setLocFunMatricula(int locFunMatricula) {
        this.locFunMatricula = locFunMatricula;
    }

    public int getLocCarCodigo() {
        return locCarCodigo;
    }

    public void setLocCarCodigo(int locCarCodigo) {
        this.locCarCodigo = locCarCodigo;
    }

    public int getLocCliCodigo() {
        return locCliCodigo;
    }

    public void setLocCliCodigo(int locCliCodigo) {
        this.locCliCodigo = locCliCodigo;
    }

    public ModelFuncionario getModelFuncionario() {
        return modelFuncionario;
    }

    public void setModelFuncionario(ModelFuncionario modelFuncionario) {
        this.modelFuncionario = modelFuncionario;
    }

    public ModelCarro getModelCarro() {
        return modelCarro;
    }

    public void setModelCarro(ModelCarro modelCarro) {
        this.modelCarro = modelCarro;
    }

    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }

    public ArrayList<ModelLocacao> getListAlocacao() {
        return listAlocacao;
    }

    public void setListAlocacao(ArrayList<ModelLocacao> listAlocacao) {
        this.listAlocacao = listAlocacao;
    }

    @Override
    public String toString() {
        return "ModelLocacao{" + "locCodigo=" + locCodigo + ", locData=" + locData + ", locHora=" + locHora + ", locDataDevolucao=" + locDataDevolucao + ", locHoraDevolucao=" + locHoraDevolucao + ", locValorTotal=" + locValorTotal + ", qtdDias=" + qtdDias + ", situacao=" + situacao + ", locFunMatricula=" + locFunMatricula + ", locCarCodigo=" + locCarCodigo + ", locCliCodigo=" + locCliCodigo + ", modelFuncionario=" + modelFuncionario + ", modelCarro=" + modelCarro + ", modelCliente=" + modelCliente + ", listAlocacao=" + listAlocacao + '}';
    }
   
}

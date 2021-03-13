/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.model;

import java.util.ArrayList;

/**
 *
 * @author Gilber
 * @version 1.0
 */
public class ModelCarro {
    private int carCodigo;
    private String carChassi;
    private String carPlaca;
    private String carMarca;
    private String carModelo;
    private String carAno;
    private String carCor;
    private String carStatus;
    private int categoriasCodigo;
    private ModelCategoria modelCategoria;
    private ArrayList<ModelCarro> listaCategoria;

    public ModelCarro() {
    }

    public int getCarCodigo() {
        return carCodigo;
    }

    public void setCarCodigo(int carCodigo) {
        this.carCodigo = carCodigo;
    }

    public String getCarChassi() {
        return carChassi;
    }

    public void setCarChassi(String carChassi) {
        this.carChassi = carChassi;
    }

    public String getCarPlaca() {
        return carPlaca;
    }

    public void setCarPlaca(String carPlaca) {
        this.carPlaca = carPlaca;
    }

    public String getCarMarca() {
        return carMarca;
    }

    public void setCarMarca(String carMarca) {
        this.carMarca = carMarca;
    }

    public String getCarModelo() {
        return carModelo;
    }

    public void setCarModelo(String carModelo) {
        this.carModelo = carModelo;
    }

    public String getCarAno() {
        return carAno;
    }

    public void setCarAno(String carAno) {
        this.carAno = carAno;
    }

    public String getCarCor() {
        return carCor;
    }

    public void setCarCor(String carCor) {
        this.carCor = carCor;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public int getCategoriasCodigo() {
        return categoriasCodigo;
    }

    public void setCategoriasCodigo(int categoriasCodigo) {
        this.categoriasCodigo = categoriasCodigo;
    }

    public ModelCategoria getModelCategoria() {
        return modelCategoria;
    }

    public void setModelCategoria(ModelCategoria modelCategoria) {
        this.modelCategoria = modelCategoria;
    }

    public ArrayList<ModelCarro> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<ModelCarro> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    @Override
    public String toString() {
        return "ModelCarro{" + "carCodigo=" + carCodigo + ", carChassi=" + carChassi + ", carPlaca=" + carPlaca + ", carMarca=" + carMarca + ", carModelo=" + carModelo + ", carAno=" + carAno + ", carCor=" + carCor + ", carStatus=" + carStatus + ", categoriasCodigo=" + categoriasCodigo + ", modelCategoria=" + modelCategoria + ", listaCategoria=" + listaCategoria + '}';
    }
  
}

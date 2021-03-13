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
public class ModelCategoria {
    private int catCodigo;
    private String catClasse;
    private double catPreco;
    private String catDescricao;
    private ModelCategoria modelCategoria;

    public ModelCategoria() {
    }
public int getCatCodigo() {
        return this.catCodigo;
    }
    public void setCatCodigo(int pCatCodigo) {
        this.catCodigo = pCatCodigo;
    }
    public void setCatClasse(String pCatClasse) {
        this.catClasse = pCatClasse;
    }

    public String getCatClasse() {
        return this.catClasse;
    }
    public void setCatPreco(double pCatPreco) {
        this.catPreco = pCatPreco;
    }

    public double getCatPreco() {
        return this.catPreco;
    }
    public void setCatDescricao(String pCatDescricao) {
        this.catDescricao = pCatDescricao;
    }

    public String getCatDescricao() {
        return this.catDescricao;
    }

    public ModelCategoria getModelCategoria() {
        return this.modelCategoria;
    }

    public void setModelCategoria(ModelCategoria modelCategoria) {
        this.modelCategoria = modelCategoria;
    }

    @Override
    public String toString() {
        return "ModelCategoria{" + "catCodigo=" + catCodigo + ", catClasse=" + catClasse + ", catPreco=" + catPreco + ", catDescricao=" + catDescricao + ", modelCategoria=" + modelCategoria + '}';
    }

    
    
    
}

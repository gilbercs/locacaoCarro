/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.model;

/**
 *
 * @author Gilber
 * @version 1.0
 * 
 */
public class ModelOficina {
    private int ofiCodigo;
    private String ofiNome;
    private String ofiDescricao;

    public ModelOficina() {
    }
    
    public int getOfiCodigo() {
        return ofiCodigo;
    }

    public void setOfiCodigo(int ofiCodigo) {
        this.ofiCodigo = ofiCodigo;
    }

    public String getOfiNome() {
        return ofiNome;
    }

    public void setOfiNome(String ofiNome) {
        this.ofiNome = ofiNome;
    }

    public String getOfiDescricao() {
        return ofiDescricao;
    }

    public void setOfiDescricao(String ofiDescricao) {
        this.ofiDescricao = ofiDescricao;
    }

    @Override
    public String toString() {
        return "ModelOficina{" + "ofiCodigo=" + ofiCodigo + ", ofiNome=" + ofiNome + ", ofiDescricao=" + ofiDescricao + '}';
    }
    
}

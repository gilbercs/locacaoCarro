/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.control;

import br.com.autos.dao.DaoCarro;
import br.com.autos.model.ModelCarro;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 * @version 1.0
 */
public class ControlCarro {
    DaoCarro daoCarro = new DaoCarro();
    /**
     * Metodo insert carro
     * @param modelCarro
     * @return 
     */
    public boolean controlInsertCarro(ModelCarro modelCarro){
        return this.daoCarro.daoInsertCarro(modelCarro);
    }
    /**
     * Metodo update carro
     * @param modelCarro
     * @return 
     */
    public boolean controlUpdateCarro(ModelCarro modelCarro){
        return this.daoCarro.daoAlterarCarro(modelCarro);
    }
    /**
     * Metodo Delete carro
     * @param carCodigo
     * @return 
     */
    public boolean controlDeleteCarro(int carCodigo){
        return this.daoCarro.daoExcluirCarro(carCodigo);
    }
    /**
     * Metodo lista carro
     * @return 
     */
    public ArrayList<ModelCarro> controlListarCarro(){
        return this.daoCarro.daoGetListaCarro();
    }
    /**
     * Metodo Recuperar carro pelo codigo
     * @param carCodigo
     * @return 
     */
    public ModelCarro controlRecuperarCarro(int carCodigo){
        return this.daoCarro.daoRecuperarCarroCodigo(carCodigo);
    }
    /**
     * Metodo Recuperar carro pelo codigo
     * @param pChassi
     * @return 
     */
    public ModelCarro controlRecuperarCarro(String pChassi){
        return this.daoCarro.daoRecuperarCarroCodigo(pChassi);
    }
}

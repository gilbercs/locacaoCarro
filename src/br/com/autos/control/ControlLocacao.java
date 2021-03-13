/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.control;

import br.com.autos.dao.DaoLocacao;
import br.com.autos.model.ModelLocacao;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 */
public class ControlLocacao {
    DaoLocacao doaLocacao = new DaoLocacao();
   /**
    * metodo controle salvar
    */
    public boolean controlSalvarLocacao(ModelLocacao modelLocacao){
        return this.doaLocacao.daoSalvarLocacao(modelLocacao);
    }
     /**
    * metodo controle alterar
    */
    /**
    * metodo controle excluir
    */
    /**
    * metodo controle listar
     * @return 
    */
    public ArrayList<ModelLocacao> controlListaLocacao(){
        return this.doaLocacao.daoGetListLocacao();
    }
    /**
    * metodo controle recuperar
    */
}

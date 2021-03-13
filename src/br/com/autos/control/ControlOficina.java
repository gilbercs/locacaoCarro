/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.control;

import br.com.autos.dao.DaoOficina;
import br.com.autos.model.ModelOficina;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 * @version 1.0
 */
public class ControlOficina{
    DaoOficina daoOficina = new DaoOficina();
    //metodo de controle cadastro oficina
    public boolean controlCadastroOficina(ModelOficina modelOficina){
        return this.daoOficina.daoInsertOficina(modelOficina);
    }
    //metodo controle alterar oficina
    public boolean controlAlterarOficina(ModelOficina modelOficina){
        return this.daoOficina.daoAlterarOficina(modelOficina);
    }
    //metodo control excluir
    public boolean controlExcluirOficina(int ofiCodigo){
        return this.daoOficina.daoExcluirOficina(ofiCodigo);
    }
    //metodo control lista oficina
    public ArrayList<ModelOficina> controlListarOficina(){
        return this.daoOficina.getListarOficina();
    }
    //metodo control recuperar oficina pelo codigo id
    public ModelOficina controlRecuperarOficinaCodigo(int ofiCodigo){
        return this.daoOficina.daoRecuperarOficinaCodigo(ofiCodigo);
    }
}

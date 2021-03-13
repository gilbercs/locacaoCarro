/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.control;

import br.com.autos.dao.DaoFuncionario;
import br.com.autos.model.ModelFuncionario;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 */
public class ControlFuncionario {
    DaoFuncionario daoFuncionario = new DaoFuncionario();
    /**
     * metodo control cadastro funcionario
     * @param modelFuncionario
     * @return boolean
     */
    public boolean controlCadastroFuncionario(ModelFuncionario modelFuncionario){
        return this.daoFuncionario.daoCadastroFuncionario(modelFuncionario);
    }
    /**
     * metodo para recuper funcionario para login
     * @param modelFuncionario
     * @return boolean
     */
    public boolean controlGetFuncionario(ModelFuncionario modelFuncionario){
        return this.daoFuncionario.daoFuncionarioRecuperar(modelFuncionario);
    }
    /**
     * control listar funcionario
     * @return 
     */
    public ArrayList<ModelFuncionario> controlGetListaFuncionario(){
        return this.daoFuncionario.getListarFuncionario();
    }
    //TRABALHANDO PROCEDURE
    /**
     * inserir com procedure
     * @param modelFuncionario
     * @return 
    */
    public boolean controlGetProcFuncionario(ModelFuncionario modelFuncionario){
        return this.daoFuncionario.daoProcInsertFun(modelFuncionario);
        }
    /**
     * metodo upDate funcionario
     * @param modelFuncionario
     * @return 
     */
    public boolean controlGetUpdateFuncionario(ModelFuncionario modelFuncionario){
        return this.daoFuncionario.daoProcAlterarFun(modelFuncionario);
    }
    /**
     * metodo recuperar funcionario
     * @param funMatricula
     * @return 
     */
    public ModelFuncionario controlGetRecuperarFunId(int funMatricula){
        return this.daoFuncionario.daoGetProcRecuperarFun(funMatricula);
    }
    /**
     * metodo excluir funcionario com procedure
     * @param codigo
     * @return 
     */
    public boolean controlGetDeleteFuncionario(int codigo){
        
            return this.daoFuncionario.daoProcDeleteFun(codigo);
    }
    /**
     * metodo recuperar pelo nome
     * @param funNome
     * @return 
     */
    public ModelFuncionario controlGetRecuperarFunId(String funNome){
        return this.daoFuncionario.daoGetProcRecuperarFun(funNome);
    }
}

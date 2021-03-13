/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.control;

import br.com.autos.dao.DaoCategoria;
import br.com.autos.model.ModelCategoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gilber
 * 25/06/2019
 * version 1.0
 */
public class ControlCategoria {
    //Instancia da classe DaoCategoria
    DaoCategoria daoCategoria = new DaoCategoria();
    public boolean controlSalvarCategoria(ModelCategoria modelCategoria){
        return this.daoCategoria.daoSalvarFuncionarioProcedure(modelCategoria);
    }
    //alterar
    public boolean controlAlterarCategoria(ModelCategoria modelCategoria){
        return this.daoCategoria.daoAlterFuncionarioProcedure(modelCategoria);
    }
    //excluir
    public boolean controlExcluirCategoria(int codigo){
        return this.daoCategoria.daoExcluirCategoriaProcedure(codigo);
    }
    //listar
    public ArrayList<ModelCategoria> controlGetListaCategoria(){
        return this.daoCategoria.getListarCategoria();
    }
    //recuperar pelo codigo da categoria
    public ModelCategoria controlGetRecuperarCodigoCat(int catCodigo){
        return this.daoCategoria.daoGetRecuperarCategoriaCodigo(catCodigo);
    }
    //recuperar pelo classe da categoria
    public ModelCategoria controlGetRecuperarCodigoCat(String catClasse){
        return this.daoCategoria.daoGetRecuperarCategoriaCodigo(catClasse);
    }
}

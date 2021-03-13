/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.control;

import br.com.autos.dao.DaoCliente;
import br.com.autos.model.ModelCliente;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 * version 1.0
 * 28/06/2019
 */
public class ControlCliente {
    DaoCliente daoCliente = new DaoCliente();
    //metod control salvar cliente
    public boolean controlSalvarCliente(ModelCliente modelCliente){
        return this.daoCliente.daoSalvarCliente(modelCliente);
    }
    //update cliente
    public boolean controlUpdateCliente(ModelCliente modelCliente){
        return this.daoCliente.daoAlterarCliente(modelCliente);
    }
    //delete cliente
    public boolean controlDeleteCliente(int codigo){
        return this.daoCliente.daoDeleteCliente(codigo);
    }
    //selecionar cliente
    public ModelCliente controlRecuperarCliente(int cliCodigo){
        return this.daoCliente.daoGetRecuperarCliente(cliCodigo);
    }
    //lista cliente
    public ArrayList<ModelCliente> controlGetListarClientes(){
        return this.daoCliente.daoGetListarClientes();
    }
    //selecionar cliente
    public ModelCliente controlRecuperarCliente(String cliente){
        return this.daoCliente.daoGetRecuperarCliente(cliente);
    }
}

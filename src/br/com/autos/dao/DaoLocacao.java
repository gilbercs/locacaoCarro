/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.dao;

import br.com.autos.banco.ConexaoMysql;
import br.com.autos.model.ModelCarro;
import br.com.autos.model.ModelCliente;
import br.com.autos.model.ModelFuncionario;
import br.com.autos.model.ModelLocacao;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 */
public class DaoLocacao extends ConexaoMysql{
    /**
     * metodo cadastrar locação
     * 
     * @param modelLocacao
     * @return 
     */
    public boolean daoSalvarLocacao(ModelLocacao modelLocacao){
        String comandoSalvar = "call salvarLocacaoProcedure("
                +"'"+modelLocacao.getLocData()+"',"
                +"'"+modelLocacao.getLocHora()+"',"
                +"'"+modelLocacao.getLocDataDevolucao()+"',"
                +"'"+modelLocacao.getLocHoraDevolucao()+"',"
                +"'"+modelLocacao.getLocValorTotal()+"',"
                +"'"+modelLocacao.getQtdDias()+"',"
                +"'"+modelLocacao.getSituacao()+"',"
                +"'"+modelLocacao.getLocFunMatricula()+"',"
                +"'"+modelLocacao.getLocCarCodigo()+"',"
                +"'"+modelLocacao.getLocCliCodigo()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(comandoSalvar);
            return true;
        }catch(Exception erro){
            erro.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo alterar locação
     */
    /**
     * metodo excluir locação
     */
    /**
     * metodo listar locação
     * @return 
     */
    public ArrayList<ModelLocacao> daoGetListLocacao(){
        ArrayList<ModelLocacao> listarLocacao = new ArrayList();
        String comandoSql = "call sl_locacao()";
        try{
            this.getConectar();
            this.executarSql(comandoSql);
            while(this.getResultSet().next()){
                ModelLocacao setLocacao = new ModelLocacao();
                setLocacao.setLocCodigo(this.getResultSet().getInt(1));
                setLocacao.setLocData(this.getResultSet().getString(2));
                setLocacao.setLocHora(this.getResultSet().getString(3));
                setLocacao.setLocDataDevolucao(this.getResultSet().getString(4));
                setLocacao.setLocHoraDevolucao(this.getResultSet().getString(5));
                setLocacao.setLocValorTotal(this.getResultSet().getDouble(6));
                setLocacao.setQtdDias(this.getResultSet().getInt(7));
                setLocacao.setSituacao(this.getResultSet().getString(8));
                //setLocacao.setLocFunMatricula(this.getResultSet().getInt(9));
                //setLocacao.setLocCarCodigo(this.getResultSet().getInt(10));
               // setLocacao.setLocCliCodigo(this.getResultSet().getInt(11));
                ModelFuncionario funcionario = new ModelFuncionario();
                funcionario.setFunNome(this.getResultSet().getString(13));
                setLocacao.setModelFuncionario(funcionario);
                //set carro
                ModelCarro carro = new ModelCarro();
                carro.setCarChassi(this.getResultSet().getString(17));
                setLocacao.setModelCarro(carro);
                //set cliente
                ModelCliente cliente = new ModelCliente();
                cliente.setCliNome(this.getResultSet().getString(26));
                setLocacao.setModelCliente(cliente);
                listarLocacao.add(setLocacao);
            }
        }catch(Exception erro){
            System.out.println("erro: "+erro);
        }finally{
            this.fecharConexao();
        }
        return listarLocacao;
    }
    /**
     * metodo recuperar locação
     */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.dao;

import br.com.autos.banco.ConexaoMysql;
import br.com.autos.model.ModelOficina;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 * @version 1.0
 */
public class DaoOficina extends ConexaoMysql{
    //metodo inserir oficina
    public boolean daoInsertOficina(ModelOficina modelOficina){
        //commando sql insert
        String comandoSql = "CALL salvarOficinaProcedure("
                +"'"+modelOficina.getOfiNome()+"',"
                +"'"+modelOficina.getOfiDescricao()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(comandoSql);
            return true;
    }catch(Exception erro){
            System.out.println("Erro"+erro.getMessage());
            return false;
    }
        
    }
    //metodo alterar oficina
    public boolean daoAlterarOficina(ModelOficina modelOficina){
        String comandoSqlUpdate = "call updateOficinaProcedure("
                +"'"+modelOficina.getOfiCodigo()+"',"
                +"'"+modelOficina.getOfiNome()+"',"
                +"'"+modelOficina.getOfiDescricao()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(comandoSqlUpdate);
            return true;
        }catch(Exception erro){
            System.out.println("Erro"+erro.getMessage());
        return false;
    }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo excluir
     * @param ofiCodigo
     * @return 
     */
    public boolean daoExcluirOficina(int ofiCodigo){
        String comandoExcluir = "call deleteOficinaProcedure("+ofiCodigo+")";
        try{
            this.getConectar();
            this.executarSql(comandoExcluir);
            return true;
        }catch(Exception erro){
            System.out.println("Erro: "+erro.getMessage());
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    //Lista de Oficina
    public ArrayList<ModelOficina> getListarOficina(){
        ArrayList<ModelOficina> listOficina = new ArrayList();
        String comandoSql = "call sl_oficina()";
        try{
            this.getConectar();
            this.executarSql(comandoSql);
            while(this.getResultSet().next()){
                ModelOficina modelOficina = new ModelOficina();
                modelOficina.setOfiCodigo(this.getResultSet().getInt(1));
                modelOficina.setOfiNome(this.getResultSet().getString(2));
                modelOficina.setOfiDescricao(this.getResultSet().getString(3));
                listOficina.add(modelOficina);
                
            }
        }catch(SQLException erro){
            System.out.println("erro: "+erro);
        }finally{
            this.fecharConexao();
        }
        return listOficina;
    }
    //recuperar oficina pelo codigo
    public ModelOficina daoRecuperarOficinaCodigo(int ofiCodigo){
        String recuperarCodigo = "call pRecuperarOficinaCodigo("+ofiCodigo+");";
        ModelOficina modelOficina = new ModelOficina();
        try{
            this.getConectar();
            this.executarSql(recuperarCodigo);
            while(this.getResultSet().next()){
                modelOficina.setOfiCodigo(this.getResultSet().getInt(1));
                modelOficina.setOfiNome(this.getResultSet().getString(2));
                modelOficina.setOfiDescricao(this.getResultSet().getString(3));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelOficina;
    }
    
    
}

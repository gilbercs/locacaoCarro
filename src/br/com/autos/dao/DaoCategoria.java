/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.dao;

import br.com.autos.banco.ConexaoMysql;
import br.com.autos.model.ModelCategoria;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 * version 1.0
 * 25/06/2019
 */
public class DaoCategoria extends ConexaoMysql{
    /**
     * salvar categoria no banco de dados
     * @param modelCategoria
     * @return verdadeiro ou falso apos executar sql
     */
    public boolean daoSalvarFuncionarioProcedure(ModelCategoria modelCategoria){
        //chamada da procedure para salvar categoria
        String comandoSql = "CALL salvarCategoriaProcedure("
                +"'"+modelCategoria.getCatClasse()+"',"
                +"'"+modelCategoria.getCatPreco()+"',"
                +"'"+modelCategoria.getCatDescricao()+"'"
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
    /**
     * update com procedure
     */
    public boolean daoAlterFuncionarioProcedure(ModelCategoria modelCategoria){
        String procedureUpdateCat = "call updateCategoriaProcedure("
                +"'"+modelCategoria.getCatCodigo()+"',"
                +"'"+modelCategoria.getCatClasse()+"',"
                +"'"+modelCategoria.getCatPreco()+"',"
                +"'"+modelCategoria.getCatDescricao()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(procedureUpdateCat);
            return true;
        }catch(Exception erro){
            System.out.println("Erro"+erro.getMessage());
        return false;
    }finally{
            this.fecharConexao();
        }
    }
    /**
     * excluir com procedure
     */
    public boolean daoExcluirCategoriaProcedure(int codigo){
        String procedureDeleteCat = "call deleteCategoriaProcedure("+codigo+")";
        try{
            this.getConectar();
            this.executarSql(procedureDeleteCat);
            return true;
        }catch(Exception erro){
            System.out.println("Erro: "+erro.getMessage());
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * LISTA
     * @return 
     */
    public ArrayList<ModelCategoria> getListarCategoria(){
        ArrayList<ModelCategoria> listarCategoria = new ArrayList();
        String comandoSql = "call sl_categoria()";
        try{
            this.getConectar();
            this.executarSql(comandoSql);
            while(this.getResultSet().next()){
                ModelCategoria modelCategoria = new ModelCategoria();
                modelCategoria.setCatCodigo(this.getResultSet().getInt(1));
                modelCategoria.setCatClasse(this.getResultSet().getString(2));
                modelCategoria.setCatPreco(this.getResultSet().getDouble(3));
                modelCategoria.setCatDescricao(this.getResultSet().getString(4));
                listarCategoria.add(modelCategoria);
                
            }
        }catch(SQLException erro){
            System.out.println("erro: "+erro);
        }finally{
            this.fecharConexao();
        }
        return listarCategoria;
    }
    /**
     * metodo recuperar categoria pelo codigo
     * @param catCodigo
     * @return 
     */
    public ModelCategoria daoGetRecuperarCategoriaCodigo(int catCodigo){
        ModelCategoria modelCategoria = new ModelCategoria();
        String procedureRecuperarMatricula = "call pRecuperarCategoriaCodigo("+catCodigo+");";
        try{
            this.getConectar();
            this.executarSql(procedureRecuperarMatricula);
            while(this.getResultSet().next()){
                modelCategoria.setCatCodigo(this.getResultSet().getInt(1));
                modelCategoria.setCatClasse(this.getResultSet().getString(2));
                modelCategoria.setCatPreco(this.getResultSet().getDouble(3));
                modelCategoria.setCatDescricao(this.getResultSet().getString(4));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelCategoria;
    }
    
    public ModelCategoria daoGetRecuperarCategoriaCodigo(String catClasse){
        ModelCategoria modelCategoria = new ModelCategoria();
        String procedureRecuperarMatricula = "call pRecuperarCategoria("+catClasse+");";
        try{
            this.getConectar();
            this.executarSql(procedureRecuperarMatricula);
            while(this.getResultSet().next()){
                modelCategoria.setCatCodigo(this.getResultSet().getInt(1));
                modelCategoria.setCatClasse(this.getResultSet().getString(2));
                modelCategoria.setCatPreco(this.getResultSet().getDouble(3));
                modelCategoria.setCatDescricao(this.getResultSet().getString(4));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelCategoria;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.dao;

import br.com.autos.banco.ConexaoMysql;
import br.com.autos.model.ModelFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 */
public class DaoFuncionario extends ConexaoMysql{
    /**
     * metodo cadastrar funcionario no banco
     * paramento  Model Funcionario
     * Return um booleno
     * @param modelFuncionario
     * @return 
    */
    public boolean daoCadastroFuncionario(ModelFuncionario modelFuncionario){
        try{
            this.getConectar();
            this.executarSql(
            "insert into funcionario (funNome, funLogin, funSenha) values("
            +"'"+modelFuncionario.getFunNome()+"',"
            +"'"+modelFuncionario.getFunLogin()+"',"
            +"'"+modelFuncionario.getSenha()+"'"
                    + ");"
            );
            return true;
    
        }catch(Exception erro){
            return false;
        }
        }
   
    /**
     * metodo recuparar funcionario
     * @param modelFuncionario
     * @return boolean
     */
    public boolean daoFuncionarioRecuperar(ModelFuncionario modelFuncionario){
        try{
        this.getConectar();
        this.executarSql(
        "SELECT funMatricula, funNome, funLogin, funSenha FROM funcionario WHERE funLogin = '"+modelFuncionario.getFunLogin()+"' AND funSenha = '"+modelFuncionario.getSenha()+"'"
                +";"
        );
        
        if(getResultSet().next()){
            System.out.println("comando sql ok!");
            return true;
        }else{
            System.out.println("conexao erro!");
            return false;
        }
        }catch(Exception erro){
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo listar
     * @return 
     */
    public ArrayList<ModelFuncionario> getListarFuncionario(){
        ArrayList<ModelFuncionario> listarFuncionario = new ArrayList();
        String comandoSql = "select funMatricula, funNome, funLogin, funSenha from funcionario;";
        try{
            this.getConectar();
            this.executarSql(comandoSql);
            while(this.getResultSet().next()){
                ModelFuncionario modelFuncionario = new ModelFuncionario();
                
                modelFuncionario.setFunMatricula(this.getResultSet().getInt(1));
                modelFuncionario.setFunNome(this.getResultSet().getString(2));
                modelFuncionario.setFunLogin(this.getResultSet().getString(3));
                modelFuncionario.setSenha(this.getResultSet().getString(4));
                
                listarFuncionario.add(modelFuncionario);
            }
        }catch(Exception erro){
            System.out.println("erro: "+erro);
        }finally{
            this.fecharConexao();
        }
        return listarFuncionario;
    }
    //TRABALHANDO C/ PROCEDURE
    /**
     * metodo INSERT PROCEDURE
     * @param modelFuncionario
     * @return 
    */
    public boolean daoProcInsertFun(ModelFuncionario modelFuncionario){
        String SqlProcedure ="CALL salvarFuncionarioProcedure("
                + "'"+modelFuncionario.getFunNome()+"',"
                +"'"+modelFuncionario.getFunLogin()+"',"
                +"'"+modelFuncionario.getSenha()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(SqlProcedure);
            return true;
        }catch(Exception erro){
            return  false;
        }
    }
    /**
     * metodo Update funcionario com procedure
     * @param modelFuncionario
     * @return 
     */
    public boolean daoProcAlterarFun(ModelFuncionario modelFuncionario){
        String procedureUpdate = "call updateFuncionarioProcedure("
                +"'"+modelFuncionario.getFunMatricula()+"',"
                +"'"+modelFuncionario.getFunNome()+"',"
                +"'"+modelFuncionario.getFunLogin()+"',"
                +"'"+modelFuncionario.getSenha()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(procedureUpdate);
            return true;
        }catch(Exception erro){
            System.out.println("Erro"+erro.getMessage());
        return false;
    }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo delete funcionario com procedure
     * @param codigo
     * @return 
     */
    public boolean daoProcDeleteFun(int codigo){
        String procedureDelete = "call deleteFuncionarioProcedure("+codigo+");";
        try{
            this.getConectar();
            this.executarSql(procedureDelete);
            return true;
        }catch(Exception erro){
            System.out.println("Erro: "+erro.getMessage());
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo recuperar funcionario pela matricula
     * @param funMatricula
     * @return 
     */
    public ModelFuncionario daoGetProcRecuperarFun(int funMatricula){
        String procedureRecuperarMatricula = "call pRecuperarFuncionarioInt("+funMatricula+")";
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try{
            this.getConectar();
            this.executarSql(procedureRecuperarMatricula);
            while(this.getResultSet().next()){
                modelFuncionario.setFunMatricula(this.getResultSet().getInt(1));
                modelFuncionario.setFunNome(this.getResultSet().getString(2));
                modelFuncionario.setFunLogin(this.getResultSet().getString(3));
                modelFuncionario.setSenha(this.getResultSet().getString(4));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelFuncionario;
    }
    /**
     * metodo recuperar funcionario pelo nome
     * @param funNome
     * @return 
     */
    public ModelFuncionario daoGetProcRecuperarFun(String funNome){
        String procedureRecuperarMatricula = "call pRecuperarFuncionarioStr("+funNome+")";
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try{
            this.getConectar();
            this.executarSql(procedureRecuperarMatricula);
            while(this.getResultSet().next()){
                modelFuncionario.setFunMatricula(this.getResultSet().getInt(1));
                modelFuncionario.setFunNome(this.getResultSet().getString(2));
                modelFuncionario.setFunLogin(this.getResultSet().getString(3));
                modelFuncionario.setSenha(this.getResultSet().getString(4));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelFuncionario;
    }
}

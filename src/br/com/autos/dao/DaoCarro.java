/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.dao;

import br.com.autos.banco.ConexaoMysql;
import br.com.autos.model.ModelCarro;
import br.com.autos.model.ModelCategoria;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *@author Gilber
 * @version 1.0
 */
public class DaoCarro extends ConexaoMysql{
    //metodo salvar carro
    public boolean daoInsertCarro(ModelCarro modelCarro){
        
        String comandoInsert = "CALL salvarCarroProcedure("
                +"'"+modelCarro.getCarChassi()+"',"
                +"'"+modelCarro.getCarPlaca()+"',"
                +"'"+modelCarro.getCarMarca()+"',"
                +"'"+modelCarro.getCarModelo()+"',"
                +"'"+modelCarro.getCarAno()+"',"
                +"'"+modelCarro.getCarCor()+"',"
                +"'"+modelCarro.getCarStatus()+"',"
                +"'"+modelCarro.getCategoriasCodigo()+"'"
                +")";
        try{
        this.getConectar();
       this.executarSql(comandoInsert);
        return true;
        }catch(Exception erro){
            System.out.println("Erro:"+erro.getMessage());
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * Metodo Alterar
     * @param modelCarro
     * @return 
     */
    public boolean daoAlterarCarro(ModelCarro modelCarro){
        String comandoUpdate = "CALL upDateCarroProcedure("
                +"'"+modelCarro.getCarCodigo()+"',"
                +"'"+modelCarro.getCarChassi()+"',"
                +"'"+modelCarro.getCarPlaca()+"',"
                +"'"+modelCarro.getCarMarca()+"',"
                +"'"+modelCarro.getCarModelo()+"',"
                +"'"+modelCarro.getCarAno()+"',"
                +"'"+modelCarro.getCarCor()+"',"
                +"'"+modelCarro.getCarStatus()+"',"
                +"'"+modelCarro.getCategoriasCodigo()+"'"
                +")";
        try {
            this.getConectar();
           this.executarSql(comandoUpdate);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * Metodo Excluir
     * @param pCodigo
     * @return 
     */
    public boolean daoExcluirCarro(int pCodigo){
        String comando = "DELETE FROM carro WHERE carCodigo = "+pCodigo+";";
        try {
            this.getConectar();
            this.executarUpdateDeleteSQL(comando);
            return true;
        }catch(Exception e){
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo listar carro
     * @return 
     */
    public ArrayList<ModelCarro> daoGetListaCarro(){
        ArrayList<ModelCarro> listaCarro = new ArrayList<>();
        //String comando="SELECT carCodigo, carChassi, carPlaca, carMarca, carModelo, carAno, carCor, carCatCodigo FROM carro;";
        //String comandoP = "CALL getListaCarroProcedure";
        String comandoSl = "call sl_carro_categoria()";
        try {
            this.getConectar();
            this.executarSql(comandoSl);
            while(this.getResultSet().next()){
                ModelCarro modelCarro = new ModelCarro();
                modelCarro.setCarCodigo(this.getResultSet().getInt(1));
                modelCarro.setCarChassi(this.getResultSet().getString(2));
                modelCarro.setCarPlaca(this.getResultSet().getString(3));
                modelCarro.setCarMarca(this.getResultSet().getString(4));
                modelCarro.setCarModelo(this.getResultSet().getString(5));
                modelCarro.setCarAno(this.getResultSet().getString(6));
                modelCarro.setCarCor(this.getResultSet().getString(7));
                modelCarro.setCarStatus(this.getResultSet().getString(8));
                modelCarro.setCategoriasCodigo(this.getResultSet().getInt(9));
                //categoria
                ModelCategoria modelCategoria = new ModelCategoria();
                modelCategoria.setCatClasse(this.getResultSet().getString(11));
                modelCarro.setModelCategoria(modelCategoria);
                listaCarro.add(modelCarro);
            }
        }catch(SQLException e){
            System.out.println("Erro: "+e.getMessage());
        }finally{
            this.fecharConexao();
        }
        return listaCarro;
    }
    /**
     * metodo recuperar carro pelo cadigo
     * @param carCodigo
     * @return 
     */
    public ModelCarro daoRecuperarCarroCodigo(int carCodigo){
        ModelCarro modelCarro = new ModelCarro();
        String comando = "SELECT carCodigo, carChassi, carPlaca, carMarca, carModelo, carAno, carCor, carCatCodigo FROM carro WHERE carCodigo="+carCodigo+";";
        try {
            this.getConectar();
            this.executarSql(comando);
            while(this.getResultSet().next()){
                modelCarro.setCarCodigo(this.getResultSet().getInt(1));
                modelCarro.setCarChassi(this.getResultSet().getString(2));
                modelCarro.setCarPlaca(this.getResultSet().getString(3));
                modelCarro.setCarMarca(this.getResultSet().getString(4));
                modelCarro.setCarModelo(this.getResultSet().getString(5));
                modelCarro.setCarAno(this.getResultSet().getString(6));
                modelCarro.setCarCor(this.getResultSet().getString(7));
                modelCarro.setCategoriasCodigo(this.getResultSet().getInt(8));
            }
        }catch(SQLException e){
            System.out.println("Erro: "+e.getSQLState());
        }finally{
            this.fecharConexao();
        }
        return modelCarro;
    }
    /**
     * metodo recuperar carro pelo cadigo
     * @param carroChassi
     * @return 
     */
    public ModelCarro daoRecuperarCarroCodigo(String carroChassi){
        ModelCarro modelCarro = new ModelCarro();
        String comando = "SELECT carCodigo, carChassi, carPlaca, carMarca, carModelo, carAno, carCor, carCatCodigo FROM carro WHERE carChassi="+carroChassi+";";
        try {
            this.getConectar();
            this.executarSql(comando);
            while(this.getResultSet().next()){
                modelCarro.setCarCodigo(this.getResultSet().getInt(1));
                modelCarro.setCarChassi(this.getResultSet().getString(2));
                modelCarro.setCarPlaca(this.getResultSet().getString(3));
                modelCarro.setCarMarca(this.getResultSet().getString(4));
                modelCarro.setCarModelo(this.getResultSet().getString(5));
                modelCarro.setCarAno(this.getResultSet().getString(6));
                modelCarro.setCarCor(this.getResultSet().getString(7));
                modelCarro.setCategoriasCodigo(this.getResultSet().getInt(8));
            }
        }catch(SQLException e){
            System.out.println("Erro: "+e.getSQLState());
        }finally{
            this.fecharConexao();
        }
        return modelCarro;
    }
    
    
}

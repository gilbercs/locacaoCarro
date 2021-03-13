package br.com.autos.dao;

import br.com.autos.banco.ConexaoMysql;
import br.com.autos.model.ModelCliente;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gilber
 * version 1.0
 * 25/06/2019
 */
public class DaoCliente extends ConexaoMysql{
    /**
     * salvar cliente no BD
     * @param modelCliente
     * @return 
     */
    public boolean daoSalvarCliente(ModelCliente modelCliente){
        String comando = "CALL salvarClienteProcedure("
                + "'"+modelCliente.getCliNome()+"',"
                +"'"+modelCliente.getIdade()+"',"
                +"'"+modelCliente.getCliCnh()+"',"
                +"'"+modelCliente.getCliRua()+"',"
                +"'"+modelCliente.getCliNumero()+"',"
                +"'"+modelCliente.getCliCep()+"',"
                +"'"+modelCliente.getCliBairro()+"',"
                +"'"+modelCliente.getCliCidade()+"',"
                +"'"+modelCliente.getCliUf()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(comando);
            return true;
    
        }catch(Exception erro){
            return false;
        }
        }
    /**
     * metodo Update Cliente com procedure
     * @param modelCliente   
     * @return 
     */
    public boolean daoAlterarCliente(ModelCliente modelCliente){
       String comandoUpdate = "call updateClienteProcedure("
               +"'"+modelCliente.getCliCodigo()+"',"
                + "'"+modelCliente.getCliNome()+"',"
                +"'"+modelCliente.getIdade()+"',"
                +"'"+modelCliente.getCliCnh()+"',"
                +"'"+modelCliente.getCliRua()+"',"
                +"'"+modelCliente.getCliNumero()+"',"
                +"'"+modelCliente.getCliCep()+"',"
                +"'"+modelCliente.getCliBairro()+"',"
                +"'"+modelCliente.getCliCidade()+"',"
                +"'"+modelCliente.getCliUf()+"'"
                +")";
        try{
            this.getConectar();
            this.executarSql(comandoUpdate);
            return true;
        }catch(Exception erro){
            System.out.println("Erro"+erro.getMessage());
        return false;
    }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo delete
     * @param codigo
     * @return 
     */
    public boolean daoDeleteCliente(int codigo){
        String comandoDelete = "call deleteClienteProcedure("+codigo+");";
        try{
            this.getConectar();
            this.executarSql(comandoDelete);
            return true;
        }catch(Exception erro){
            System.out.println("Erro: "+erro.getMessage());
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    /**
     * metodo recuperar cliente pelo codigo
     * @param codigo
     * @return 
     */
    public ModelCliente daoGetRecuperarCliente(int codigo){
        String comandoRecuperar = "call pRecuperarClienteCodigo("+codigo+");";
        ModelCliente modelCliente = new ModelCliente();
        try{
            this.getConectar();
            this.executarSql(comandoRecuperar);
            while(this.getResultSet().next()){
                modelCliente.setCliCodigo(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                    modelCliente.setIdade(this.getResultSet().getInt(3));
                    modelCliente.setCliCnh(this.getResultSet().getString(4));
                    modelCliente.setCliRua(this.getResultSet().getString(5));
                    modelCliente.setCliNumero(this.getResultSet().getInt(6));
                    modelCliente.setCliCep(this.getResultSet().getString(7));
                    modelCliente.setCliBairro(this.getResultSet().getString(8));
                    modelCliente.setCliCidade(this.getResultSet().getString(9));
                    modelCliente.setCliUf(this.getResultSet().getString(10));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }
    /**
     * metodo listar clientes
     * @return 
     */
        public ArrayList<ModelCliente> daoGetListarClientes(){
            ArrayList<ModelCliente> listarClientes = new ArrayList<>();
            String comandoSql = "select cliCodigo, cliNome, cliIdade, cliCnh, cliRua, cliNumero, cliCep, cliBairro, cliCidade, cliUf from cliente";
            try{
                this.getConectar();
                this.executarSql(comandoSql);
                while(this.getResultSet().next()){
                    ModelCliente modelCliente = new ModelCliente();
                    modelCliente.setCliCodigo(this.getResultSet().getInt(1));
                    modelCliente.setCliNome(this.getResultSet().getString(2));
                    modelCliente.setIdade(this.getResultSet().getInt(3));
                    modelCliente.setCliCnh(this.getResultSet().getString(4));
                    modelCliente.setCliRua(this.getResultSet().getString(5));
                    modelCliente.setCliNumero(this.getResultSet().getInt(6));
                    modelCliente.setCliCep(this.getResultSet().getString(7));
                    modelCliente.setCliBairro(this.getResultSet().getString(8));
                    modelCliente.setCliCidade(this.getResultSet().getString(9));
                    modelCliente.setCliUf(this.getResultSet().getString(10));
                    listarClientes.add(modelCliente);
                }
            }catch(SQLDataException erro){
                System.out.println("Erro"+erro.getMessage());
                System.out.println("Erro"+erro.getSQLState());
                System.out.println("erro"+erro.getLocalizedMessage());
            } catch (SQLException ex) {
             System.out.println("Erro"+ex.getMessage());
                System.out.println("Erro"+ex.getSQLState());
                System.out.println("erro"+ex.getLocalizedMessage());
        }finally{
                this.fecharConexao();
            }
            return listarClientes;
        }
/**
     * metodo recuperar cliente pelo codigo
     * @param cliente
     * @return 
     */
    public ModelCliente daoGetRecuperarCliente(String cliente){
        String comandoRecuperar = "call pRecuperarClienteString("+cliente+")";
        ModelCliente modelCliente = new ModelCliente();
        try{
            this.getConectar();
            this.executarSql(comandoRecuperar);
            while(this.getResultSet().next()){
                modelCliente.setCliCodigo(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                    modelCliente.setIdade(this.getResultSet().getInt(3));
                    modelCliente.setCliCnh(this.getResultSet().getString(4));
                    modelCliente.setCliRua(this.getResultSet().getString(5));
                    modelCliente.setCliNumero(this.getResultSet().getInt(6));
                    modelCliente.setCliCep(this.getResultSet().getString(7));
                    modelCliente.setCliBairro(this.getResultSet().getString(8));
                    modelCliente.setCliCidade(this.getResultSet().getString(9));
                    modelCliente.setCliUf(this.getResultSet().getString(10));
            }
        }catch(SQLException erro){
            System.out.println("Erro: "+erro.getMessage());
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }
    
}

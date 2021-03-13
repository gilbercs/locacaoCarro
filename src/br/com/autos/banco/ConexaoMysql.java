/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.banco;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilber
 * @version 1.0
 */
public class ConexaoMysql {
    /**
     * Variveis para conexão com o banco de dados
    */
    private Connection con= null;
    private Statement statement;
    private ResultSet resultSet;
    /**
     * Variavel para login com banco
     */
    private String url ="jdbc:mysql://localhost/locacao";
    private String user="root";
    private String pass="";
    private String driver = "com.mysql.jdbc.Driver";
    /**
     * metodo para conectar com o banco de dados
     */
    public boolean getConectar(){
        try {
            //passando por paramentro o Driver JDBC
            Class.forName(driver).newInstance();
            //caminho para o banco de dados com: local, usuario, senha
            this.con = DriverManager.getConnection(url, user, pass);
            //mensagens para confirma conexão
            System.out.println("Conexão realizada com sucesso!!");
            return true;
        } catch (SQLException erro) {
            System.err.println("Erro: "+erro.getMessage());
            System.out.println("Erro: "+erro.getSQLState());
            System.err.println("Erro: "+erro.getErrorCode());
            return false;
        }catch(Exception e){
            System.err.println("Erro ao conectar com o banco de dados! :)");
            return false;
        }  
    }
    /**
     * metodo executa um comando SQL
     * pasado por @parametro um String Sql
     */
            public boolean executarSql(String sql){
        try {
            //createStatement de con para criar o Statement
            this.statement = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Definido o Statement, executamos a query no banco de dados
            //comando sql das classe DAO
            this.resultSet = this.statement.executeQuery(sql);
            //caso não ocorra nenhum erro retorne a verdadeiro
            return true;
        } catch (SQLException erroSql) {
            //emitir o erro para ser visualizado p/ correação
            System.out.println("Erro: "+erroSql.getMessage());
            System.out.println("Erro: "+erroSql.getErrorCode());
            return false;
        }
            }
            //
            public boolean executarUpdateDeleteSQL(String pSQL){
        try {
            
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            getStatement().executeUpdate(pSQL);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
            //
            public boolean executarUpdateSQL(String sql) {
        try {
            this.statement = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.statement.executeUpdate(sql);
            return true;

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
            return false;
        }
    }
            public int insertSQL(String pSQL){
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(pSQL);
            
            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));
            
            //recupera o ultimo id inserido
            while(this.resultSet.next()){
                status = this.resultSet.getInt(1);
            }
            
            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }
            /**
             * Metodo para encerrar conexão com o banco de dados
             */
            public boolean fecharConexao(){
                try{
                if((this.getResultSet()!=null) && (this.statement != null)){
                        this.getResultSet().close();
                        this.statement.close(); 
                }
                this.getCon().close();
                return true;
                }catch(Exception erro){
                    JOptionPane.showMessageDialog(null, "erro: "+erro.getMessage());
                }
                return false;
            }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    
}

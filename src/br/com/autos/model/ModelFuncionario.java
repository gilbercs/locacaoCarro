/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.model;

/**
 *
 * @author Gilber
 */
public class ModelFuncionario {
    private int funMatricula;
    private String funNome;
    private String funLogin;
    private String Senha;

    public ModelFuncionario() {
    }

    public int getFunMatricula() {
        return this.funMatricula;
    }

    public void setFunMatricula(int funMatricula) {
        this.funMatricula = funMatricula;
    }

    public String getFunNome() {
        return this.funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public String getFunLogin() {
        return funLogin;
    }

    public void setFunLogin(String funLogin) {
        this.funLogin = funLogin;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public String toString() {
        return "ModelFuncionario{" + "funMatricula=" + funMatricula + ", funNome=" + funNome + ", funLogin=" + funLogin + ", Senha=" + Senha + '}';
    }

   

    
}

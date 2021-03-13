/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gilber
 */
public class DataHora {
    /**
     * Recebe qualquer data em tipo date e retorna a data
     * @param pData
     * @return 
     */
    public String formatarData(Date pData){
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");    
        return formatarDate.format(pData);
    }
    /**
     * Recebe qualquer hora em tipo Date e retorn a hora
     * @param hora
     * @return 
     */
    public String formatarHora(Date hora){
    SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm:ss");
    return horaFormatada.format(hora);
    }
    
      public String MostraData(){
       //pega data do computador
       Date data = new Date();
       //cria o formatador
       SimpleDateFormat dformatador = new SimpleDateFormat("dd/MM/yyyy");
       // cria a string para armazenar data
       String sData = dformatador.format(data);

       //retorna o pedido
        return sData;
    }
    public String MostraHora(){
       //pega data para converter em horas
       Date data = new Date();
       //cria o formatador
       SimpleDateFormat hformatador = new SimpleDateFormat("hh:mm:ss");
       // cria a string
       String sHora = hformatador.format(data);
       return sHora;
    }
}

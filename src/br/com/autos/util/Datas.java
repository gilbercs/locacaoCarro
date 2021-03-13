/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.autos.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Gilber
 */
public class Datas {
/**
     * retorna uma String quando o parametro recebido é uma
     * string no formato yyyy-MM-dd
     * @param pString
     * @return String
     */
    public String addBarras(String pString){
        String dataRetorno = new String();
        //substitui o '-' por '\'
        if(pString != null){
            dataRetorno += pString.charAt(8);
            dataRetorno += pString.charAt(9);
            dataRetorno += '/';
            dataRetorno += pString.charAt(5);
            dataRetorno += pString.charAt(6);
            dataRetorno += '/';
            dataRetorno += pString.charAt(0);
            dataRetorno += pString.charAt(1);
            dataRetorno += pString.charAt(2);
            dataRetorno += pString.charAt(3);
        }
        return dataRetorno;
    }

    public String trocarTracos(String pString){
        String retorno = new String();
        if(pString != null){
            for(int i = 0; i < pString.length(); i++){
                if(pString.charAt(i) == '-'){
                    retorno += '/';
                } else {
                    retorno += pString.charAt(i);
                }
            }
        }
        return retorno;
    }
    
        /**
     * adiciona uma quantidade de dias a data
     * @param pQteDias
     * @return Date
     */
    public Date addDias(int pQteDias, Date pDate){
        Calendar c = Calendar.getInstance();

        c.setTime(pDate);
        c.add(Calendar.DATE, pQteDias);

        return c.getTime();
    }
    
   /**
    * adicionar mês a data
    * @param totalParcelas
    * @return 
    */
   public Date adddMes(Date dataAtual, int quantidadeMes){
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        c.add(Calendar.MONTH, quantidadeMes);
        return c.getTime();
   }
    
    public int diasEntreDatas(Date pDataInicio, Date pDataFim){
        GregorianCalendar ini = new GregorianCalendar();  
        GregorianCalendar fim = new GregorianCalendar();  
        ini.setTime(pDataInicio);  
        fim.setTime(pDataFim);  
        long dt1 = ini.getTimeInMillis();  
        long dt2 = fim.getTimeInMillis();  
        return (int) (((dt2 - dt1) / 86400000)+1); 
    }    
    /**
     *retornar data e hora tempo real
     * @return 
     */
    public String retornarDataHora(){
        Date date = new Date(); 
        SimpleDateFormat teste = new SimpleDateFormat("dd/MM/yyyy hh:mm");	
        return teste.format(date);
    }	
    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou nula,  
     * retorna null - para facilitar em casos onde formulários podem ter campos 
     * de datas vazios. 
     * @param data
     */
    public java.sql.Date converterDataStringParaDate(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }
    /**
     * Recebe qualquer data em tipo date e retorna a data
     */
    public String formatarData(Date pData){
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");    
        return formatarDate.format(pData);
    }
    /**
     * Recebe date
     */
    public String formatarHora(Date hora){
    SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm:ss");
    return horaFormatada.format(hora);
    }
}

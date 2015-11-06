/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.error;

/**
 *
 * @author Celson Rodrigues
 */
public class DadoInvalidoException extends Exception{

     public DadoInvalidoException(){
        super();
    }
    
    public DadoInvalidoException(Exception e){
        super(e);
    }
    
    public DadoInvalidoException(String e){
        super(e);
    }
    
}

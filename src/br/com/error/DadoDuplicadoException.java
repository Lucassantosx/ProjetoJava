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
public class DadoDuplicadoException extends Exception{
    
     public DadoDuplicadoException(){
        super();
    }
    
    public DadoDuplicadoException(Exception e){
        super(e);
    }
    
    public DadoDuplicadoException(String e){
        super(e);
    }
    
}

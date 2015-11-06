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
public class CampoVazioException extends Exception{
    public CampoVazioException(){
        super();
    }
    
    public CampoVazioException(Exception e){
        super(e);
    }
    
    public CampoVazioException(String e){
        super(e);
    }
    
}

package br.com.negocio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Charles Demetrius
 */
public class Genero {
    
    private int idGenero;
    private String Descricao;
    
    public int getIdGenero(){
        return this.idGenero;
    }
    public void setIdGenero(int idGenero){
        this.idGenero = idGenero;
    }
  
    public String getDescricao(){
        return this.Descricao;
    }
    public void setDescricao(String Descricao){
        this.Descricao = Descricao;
    }

    public void getIdGenero(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getDescricao(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

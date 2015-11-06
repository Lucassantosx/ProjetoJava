/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio;

/**
 *
 * @author Celson Rodrigues
 */
public class Editora {
    
    private int id_editora;
    private String nome;
    private String endereco;
    private String telefone;

    
    public Editora(String nome, String endereco, String telefone){
        
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
        
    }
    
    public Editora(){
        
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the id_editora
     */
    public int getId_editora() {
        return id_editora;
    }

    /**
     * @param id_editora the id_editora to set
     */
    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
    }
    
    
    
}

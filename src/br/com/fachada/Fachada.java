/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fachada;

import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.DadoDuplicadoException;
import br.com.error.GeralException;
import br.com.negocio.Editora;
import br.com.dado.DAOClienteReal;
import br.com.negocio.Cliente;
import br.com.negocio.regras.RNCliente;
import br.com.negocio.regras.RNEditora;

import java.util.ArrayList;

/**
 *
 * @author Lucas Xavier
 * @Date 07/11/2015 09:27H
 */
public class Fachada {

    private static Fachada instancia;
    private static RNCliente rnCliente;
    private static RNEditora rnEditora;
    
    private Fachada(){
        
        rnCliente = new RNCliente();
        rnEditora = new RNEditora();
        
    }
    
    public static Fachada getInstancia(){
        if (instancia==null)
            instancia = new Fachada();
        return instancia;
    }
    
    
/*###########################################################
########################## EDITORA ##########################
###########################################################*/

    public void salvarEditora(Editora edit) throws CampoVazioException, ConexaoException, DAOException, DadoDuplicadoException, GeralException{
        
        rnEditora.verificaPreenchimento(edit);
        rnEditora.verificaDuplicacao(edit);
        rnEditora.grava(edit);
    }
    
    public void alterarEditora(Editora edit){
        
    }

    public void excluirEditora(Integer idEditora) throws GeralException, ConexaoException, DAOException{
        rnEditora.excluir(idEditora);
    }
    
    public Editora retrieveEditora(Integer idEditra){
        return null;
    }
    
    public ArrayList<Editora> listarEditora(){
        
    return null;
    }
    
    /*###########################################################
########################## CLIENTE ##########################
###########################################################*/

    public void salvarCliente(Cliente c) throws CampoVazioException, ConexaoException, DAOException, DadoDuplicadoException, GeralException{
        
        rnCliente.verificaPreenchimento(c);
        rnCliente.verificaDuplicacao(c);
        rnCliente.grava(c);
    }
    
    public void alterarCliente(Cliente c){
        
    }

    public void excluirCliente(Integer idCliente) throws GeralException, ConexaoException, DAOException{
        rnCliente.excluir(idCliente);
    }
    
    public Cliente retrieveCliente(Integer IdCliente){
        return null;
    }
    
    public ArrayList<Cliente> listarCliente(){
        
    return null;
    }
    
}
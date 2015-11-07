/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio.regras;

import br.com.dado.DAOCliente;
import br.com.dado.DAOClienteReal;
import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.DadoDuplicadoException;
import br.com.error.GeralException;
import br.com.negocio.Cliente;

/**
 *
 * @author Celson Rodrigues
 */
public class RNCliente {
     
    private final DAOCliente dao;
    
    public RNCliente(){
        
        dao = (DAOCliente) new DAOClienteReal();
        
    }
    
    /**
     * Verifica se os campo de preenchimento para criação de novo cliete está vazio
     * @param c
     * @throws CampoVazioException 
     */
    public void verificaPreenchimento(Cliente c)throws CampoVazioException{
        //verifica preenchimento
        if(c.getNome()==null || c.getNome().trim().isEmpty()){
            throw new CampoVazioException("Nome vazio");
        }
        if(c.getCPF()==null || c.getCPF().trim().isEmpty()){
            throw new CampoVazioException("CPF vazio");
        }
        if(c.getEndereço()==null || c.getEndereço().trim().isEmpty()){
            throw new CampoVazioException("Endereço vazio");
        }
        if(c.getTelefone()==null || c.getTelefone().trim().isEmpty()){
            throw new CampoVazioException("Telefone vazio");
        }
        if(c.getEmail()==null || c.getEmail().trim().isEmpty()){
            throw new CampoVazioException("Email vazio");
        }
        if(c.getSexo()==null || c.getSexo().trim().isEmpty()){
            throw new CampoVazioException("Sexo vazio");
        }
        
    }
    
    public void verificaDuplicacao(Cliente c) throws ConexaoException, DAOException, DadoDuplicadoException, GeralException{
        
        try {
            
            Cliente novoCliente = dao.retrieve(c.getIdCliente());
            if(novoCliente!=null){
                throw new DadoDuplicadoException("Cliente Já Cadastrado");
            }
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
    }
        
        
    public void grava(Cliente c) throws GeralException{
        
        try {
            dao.incluir(c);
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
        
    }
    
    /**
     *
     * @param idCliente
     * @throws GeralException
     * @Author Lucas Xavier
     * @Date 07/11/15 10:06H
     */
    public void excluir(Integer idCliente) throws GeralException, ConexaoException, DAOException {
       DAOCliente DCL = new DAOClienteReal();
        DCL.excluir(idCliente);
    
    }
    
    public void alterar (Cliente c) throws ConexaoException, DAOException{
    DAOCliente DCL = new DAOClienteReal();
    DCL.alterar(c);
        
        
    }
    
}

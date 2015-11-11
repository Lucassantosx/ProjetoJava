/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio.regras;

import br.com.dado.DAOEscritor;
import br.com.dado.DAOEscritorReal;
import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.DadoDuplicadoException;
import br.com.error.GeralException;
import br.com.negocio.Escritor;
/**
 *
 * @author Paulo
 */
public class RNEscritor{
    
    private final DAOEscritor dao;
    
    public RNEscritor(){
        
        dao = new DAOEscritorReal();
    }

    public void verificaPreenchimento(Escritor esc)throws CampoVazioException{
        if(esc.getNome()==null || esc.getNome().trim().isEmpty()){
            throw new CampoVazioException(" Nome vazio");
        }
    }
    
    
   public void verificaDuplicacao(Escritor esc) throws ConexaoException, DAOException, DadoDuplicadoException, GeralException{
        
        try {
            
            Escritor novoEscritor = dao.retrieve(esc.getId());
            
            if(novoEscritor!=null){
                throw new DadoDuplicadoException("Escritor Já Cadastrado");
            }
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
    }
        
        
    public void grava(Escritor esc) throws GeralException{
        
        try {
            dao.incluir(esc);
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
        
    }
    /**
     *
     * @param idEscritor
     * @Author Lucas Xavier
     * @Date 07/11/15 11:22H
     */
     public void excluir(Integer idEscritor) throws GeralException, ConexaoException, DAOException {
       DAOEscritor DE = new DAOEscritorReal();
        DE.excluir(idEscritor);
    
    }
     /**
     *
     * @param esc
     * @throws br.com.error.ConexaoException
     * @Author Lucas Xavier
     * @Date 07/11/15 11:24H
     */
     public void alterar (Escritor esc) throws ConexaoException, DAOException{
    DAOEscritor DE = new DAOEscritorReal();
    DE.alterar(esc);
        
        
    }
}

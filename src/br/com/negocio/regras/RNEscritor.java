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
            throw new CampoVazioException("Nome vazio");
        }
    }
    
    
   public void verificaDuplicacao(Escritor esc) throws br.com.error.ConexaoException, br.com.error.DAOException, br.com.error.DadoDuplicadoException, GeralException{
        
        try {
            
            Escritor novoEscritor = dao.retrieve(esc.getId());
            if(novoEscritor!=null){
                throw new br.com.error.DadoDuplicadoException("Escritor Já Cadastrado");
            }
        }catch(br.com.error.DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(br.com.error.ConexaoException e){
            throw new GeralException("Erro de BD");
        }
    }
        
        
    public void grava(Escritor esc) throws GeralException{
        
        try {
            dao.incluir(esc);
        }catch(br.com.error.DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(br.com.error.ConexaoException e){
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
       DAOEscritor DCL = new DAOEscritorReal();
        DCL.excluir(idEscritor);
    
    }
     /**
     *
     * @param esc
     * @throws br.com.error.ConexaoException
     * @Author Lucas Xavier
     * @Date 07/11/15 11:24H
     */
     public void alterar (Escritor esc) throws ConexaoException, DAOException{
    DAOEscritor DET = new DAOEscritorReal();
    DET.alterar(esc);
        
        
    }
}

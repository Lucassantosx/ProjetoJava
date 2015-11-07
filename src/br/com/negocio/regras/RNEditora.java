/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio.regras;


import br.com.dado.DAOEditora;
import br.com.dado.DAOEditoraReal;
import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.DadoDuplicadoException;
import br.com.error.GeralException;
import br.com.negocio.Editora;
import br.com.negocio.Escritor;

/**
 *
 * @author Celson Rodrigues
 */
public class RNEditora {
    
    private final DAOEditora dao;
    
    public RNEditora(){
        
        dao = new DAOEditoraReal();
    }
    
    public void verificaPreenchimento(Editora edit)throws CampoVazioException{
        if(edit.getNome()==null || edit.getNome().trim().isEmpty()){
            throw new CampoVazioException("Nome vazio");
        }
        if(edit.getEndereco()==null || edit.getEndereco().trim().isEmpty()){
            throw new CampoVazioException("Endereco vazio");
        }
        if(edit.getTelefone()==null || edit.getTelefone().trim().isEmpty()){
            throw new CampoVazioException("Endereço vazio");
        }
       
    }
    
    
    public void verificaDuplicacao(Editora edit) throws ConexaoException, DAOException, DadoDuplicadoException, GeralException{
        
        try {
            Editora novaEditora = dao.retrieve(edit.getId_editora());
            if(novaEditora!=null){
                throw new DadoDuplicadoException("Cliente Já Cadastrado");
            }
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
    }
    
    public void grava(Editora edit) throws GeralException{
        
        try {
            dao.incluir(edit);
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
        
    }
    
     /**
     *
     * @param idEditora
     * @throws GeralException
     * @Author Lucas Xavier
     * @Date 07/11/15 10:11H
     */
    public void excluir(Integer idEditora) throws GeralException, ConexaoException, DAOException {
       DAOEditora DCL = new DAOEditoraReal();
        DCL.excluir(idEditora);
    
    }
     /**
     *
     * @Author Lucas Xavier
     * @Date 07/11/15 11:20H
     */
     public void alterar (Editora edit) throws ConexaoException, DAOException{
    DAOEditora DET = new DAOEditoraReal();
    DET.alterar(edit);
        
        
    }

    
}

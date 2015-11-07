package br.com.negocio.regras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.dado.DAOGenero;
import br.com.dado.DAOGeneroReal;
import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.DadoDuplicadoException;
import br.com.error.GeralException;
import br.com.negocio.Genero;

/**
 *
 * @author Charles Demetrius
 */
public class RNGenero {

    private final DAOGenero dao;

    public RNGenero() {

        dao = (DAOGenero) new DAOGeneroReal();

    }

    
    /**
     * Verifica se os campo de preenchimento para criação de novo cliete está
     * vazio
     *
     * @param g
     * @throws CampoVazioException
     */
    public void verificaPreenchimento(Genero g) throws CampoVazioException {
        //verifica preenchimento
        if (g.getDescricao() == null || g.getDescricao().trim().isEmpty()) {
            throw new CampoVazioException("Descricao vazio");
        }
    }

   public void verificaDuplicacao(Genero g) throws ConexaoException, DAOException, DadoDuplicadoException, GeralException{
              
        try {
            
            Genero novoGenero = dao.retrieve( g.getIdGenero() );
            if(novoGenero!=null){
                throw new DadoDuplicadoException("Genero Já Cadastrado");
            }
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
    }
        
        
    public void grava(Genero g) throws GeralException{
        
        try {
            dao.incluir(g);
        }catch(DAOException e){
            throw new GeralException("Erro de SQL");
        }catch(ConexaoException e){
            throw new GeralException("Erro de BD");
        }
       
    }
    
    public void excluir(Integer idGenero) throws ConexaoException, DAOException{
        
        DAOGenero dg = new DAOGeneroReal();
        dg.excluir(idGenero);
        
               
    }
        
      
        
    }
    
    
    
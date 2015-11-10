/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio.regras;

import br.com.dado.DAOLivro;
import br.com.dado.DAOLivroReal;
import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.DadoDuplicadoException;
import br.com.error.GeralException;
import br.com.negocio.Livro;

/**
 *
 * @author Celson Rodrigues
 */
public class RNLivro {

    private final DAOLivro dao;

    public RNLivro() {

        dao = new DAOLivroReal();

    }

    /**
     * Verifica se os campo de preenchimento para criação de novo cliete está
     * vazio
     *
     * @param livro
     * @throws CampoVazioException
     */
    public void verificaPreenchimento(Livro livro) throws CampoVazioException {
        //verifica preenchimento
        if (livro.getTitulo()== null || livro.getTitulo().trim().isEmpty()) {
            throw new CampoVazioException("Nome vazio");
        }
        
    }

    public void verificaDuplicacao(Livro livro) throws ConexaoException, DAOException, DadoDuplicadoException, GeralException {

        try {

            Livro novoLivro = dao.retrieve(livro.getIdLivro());
            if (novoLivro != null) {
                throw new DadoDuplicadoException("Cliente Já Cadastrado");
            }
        } catch (DAOException e) {
            throw new GeralException("Erro de SQL");
        } catch (ConexaoException e) {
            throw new GeralException("Erro de BD");
        }
    }

    public void grava(Livro livro) throws GeralException {

        try {
            dao.incluir(livro);
        } catch (DAOException e) {
            throw new GeralException("Erro de SQL");
        } catch (ConexaoException e) {
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
    public void excluir(Integer idLivro) throws GeralException, ConexaoException, DAOException {
        DAOLivro DL = new DAOLivroReal();
        DL.excluir(idLivro);

    }

    public void alterar(Livro livro) throws ConexaoException, DAOException {
        DAOLivro DL = new DAOLivroReal();
        DL.alterar(livro);

    }

}

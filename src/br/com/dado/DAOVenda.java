/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.negocio.Venda;

/**
 *
 * @author aluno
 */
public interface DAOVenda {
    

    public void incluirVenda(Venda v) throws ConexaoException,DAOException;
    
    public void excluirVenda(Integer idVenda) throws ConexaoException,DAOException;
    

  

}

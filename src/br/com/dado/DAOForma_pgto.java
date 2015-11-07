/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import java.util.ArrayList;
import br.com.negocio.Forma_pgto;

/**
 *
 * @author Paulo
 */
public interface DAOForma_pgto {
    
    public void incluir(Forma_pgto f) throws ConexaoException,DAOException;
    
    public void excluir(Integer idForma_pgto) throws ConexaoException,DAOException;
    
    public void alterar(Forma_pgto f) throws ConexaoException,DAOException;
    
    public Forma_pgto retrieve(int idForma_pgto) throws ConexaoException,DAOException;
            
    public ArrayList<Forma_pgto> ListarTodos() throws ConexaoException,DAOException;
    
    
}

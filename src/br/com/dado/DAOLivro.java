/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import java.util.ArrayList;
import br.com.negocio.Livro;

/**
 *
 * @author Lucas Xavier
 */
public interface DAOLivro {
    
    public void incluir(Livro lv) throws ConexaoException,DAOException;
    
    public void excluir(Integer id) throws ConexaoException,DAOException;
    
    public void alterar(Livro lv) throws ConexaoException,DAOException;
    
    public Livro retrieve(int id) throws ConexaoException,DAOException;
            
    public ArrayList<Livro> ListarTodos() throws ConexaoException,DAOException;
    
}

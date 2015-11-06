/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import java.util.ArrayList;
import br.com.negocio.Cliente;

/**
 *
 * @author Celson Rodrigues
 */
public interface DAOCliente {
    
    public void incluir(Cliente c) throws ConexaoException,DAOException;
    
    public void excluir(Integer idCliente) throws ConexaoException,DAOException;
    
    public void alterar(Cliente c) throws ConexaoException,DAOException;
    
    public Cliente retrieve(int idCliente) throws ConexaoException,DAOException;
            
    public ArrayList<Cliente> ListarTodos() throws ConexaoException,DAOException;
    
    
}

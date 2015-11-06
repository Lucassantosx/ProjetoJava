/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import java.util.ArrayList;
import br.com.negocio.Vendedor;

/**
 *
 * @author Lucas Xavier
 */
public interface DAOVendedor {
    
     public void incluir(Vendedor v) throws ConexaoException,DAOException;
    
    public void excluir(Integer matricula) throws ConexaoException,DAOException;
    
    public void alterar(Vendedor v) throws ConexaoException,DAOException;
    
    public Vendedor retrieve(int matricula) throws ConexaoException,DAOException;
            
    public ArrayList<Vendedor> ListarTodos() throws ConexaoException,DAOException;
    
}

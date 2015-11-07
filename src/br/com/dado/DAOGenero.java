package br.com.dado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.negocio.Cliente;
import java.util.ArrayList;
import br.com.negocio.Genero;

/**
 *
 * @author Charles Demetrius
 */
public interface DAOGenero {
    
        public void incluir(Genero g) throws ConexaoException, DAOException;
        
        public void excluir(Integer idGenero) throws ConexaoException, DAOException;
        
        public void alterar(Genero g) throws ConexaoException, DAOException;
        
        public Genero retrieve(int idGenero) throws ConexaoException,DAOException;
            
        public ArrayList<Genero> ListarTodos() throws ConexaoException,DAOException;
            
}
 


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import java.util.ArrayList;
import negocio.Editora;
import negocio.Escritor;

/**
 *
 * @author Celson Rodrigues
 */
public interface DAOEditora {
    
    public void incluir(Editora edit) throws ConexaoException,DAOException;
    
    public void excluir(Integer id_editora) throws ConexaoException,DAOException;
    
    public void alterar(Editora edit) throws ConexaoException,DAOException;
    
    public Editora retrieve(int id_editora) throws ConexaoException,DAOException;
            
    public ArrayList<Editora> ListarTodos() throws ConexaoException,DAOException;
    
}

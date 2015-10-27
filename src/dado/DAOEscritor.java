/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import java.util.ArrayList;
import negocio.Escritor;

/**
 *
 * @author Celson Rodrigues
 */
public interface DAOEscritor {
    
    public void incluir(Escritor e) throws ConexaoException,DAOException;
    
    public void excluir(Integer id_escritor) throws ConexaoException,DAOException;
    
    public void alterar(Escritor esc) throws ConexaoException,DAOException;
    
    public Escritor retrieve(int id_escritor) throws ConexaoException,DAOException;
            
    public ArrayList<Escritor> ListarTodos() throws ConexaoException,DAOException;
    
       
    
}

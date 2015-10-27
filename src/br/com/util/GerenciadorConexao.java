package br.com.util;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.error.ConexaoException;

/**
 *
 * @author Tito
 */
public interface GerenciadorConexao {
    
    /**
     * Estabelece uma conexao com o BD
     * @return A conexao ativa
     * @throws ConexaoException
     */
    public Connection conectar()throws ConexaoException ;
    
    /**
     * Desconecta do BD
     * @param c Um objeto de conexao ativo
     * @throws ConexaoException
     */
    public void desconectar(Connection c)throws ConexaoException ;
}

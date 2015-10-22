package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import porojeto.erro.ConexaoException;

public class GerenciadorConexaoImpl implements GerenciadorConexao{
    private static GerenciadorConexaoImpl instancia;
    private final String driver;
    private final String url;
    private final String usu;
    private final String sen;
        
    private GerenciadorConexaoImpl(){
        ResourceBundle rb = ResourceBundle.getBundle("br.com.util.banco");
        driver = rb.getString("driver");
        url = rb.getString("url");
        usu = rb.getString("usuario");
        sen = rb.getString("senha");
    }
    
    public static GerenciadorConexaoImpl getInstancia(){
        if(instancia==null) {
            instancia = new GerenciadorConexaoImpl();
        }
        return instancia;
    }
    
    @Override
    public Connection conectar()throws ConexaoException {
        try{
            Connection c = DriverManager.getConnection(url, usu, sen);
            return c;
        }catch(SQLException e){
            throw new ConexaoException(e);
        }
    }

    @Override
    public void desconectar(Connection c)throws ConexaoException  {
        try {
            c.close();
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }
    
}

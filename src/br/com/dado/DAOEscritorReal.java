/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.util.GerenciadorConexao;
import br.com.util.GerenciadorConexaoImpl;
import java.sql.Connection;
import br.com.negocio.Escritor;
import br.com.error.*;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Celson Rodrigues
 */

public class DAOEscritorReal implements DAOEscritor{
    
    private GerenciadorConexao gerenciador;
    
    public DAOEscritorReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    @Override
    public void incluir(Escritor esc) throws ConexaoException, DAOException{
        
        Connection c = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO escritor (nome) VALUES (?)";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlInsert);
            pstm.setString(1, esc.getNome());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(c);
            } 
    }
    
    @Override
    public void excluir(Integer id_escritor) throws ConexaoException, DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM escritor WHERE id_escritor =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, id_escritor);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
    }
    
    /**
     * alterar um escritor, envia um esc como parametros
     * @param esc
     * @throws ConexaoException
     * @throws DAOException
     */
    @Override
    public void alterar(Escritor esc) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        String sqlAlterar = "UPDATE escritor SET nome WHERE id=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlAlterar);
            pstm.setString(1, esc.getNome());
            pstm.executeUpdate();
        } catch (Exception e) {
        }finally{
            gerenciador.desconectar(conn);
        }
    }
            
    
    
    @Override
    public Escritor retrieve(int id_escritor) throws ConexaoException, DAOException{
        
        Connection conn = gerenciador.conectar();
        Escritor esc = null;
        
        String sqlRetrieve = "SELECT id_escritor, nome FROM escritor WHERE id=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, id_escritor);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                esc = new Escritor();
                esc.setId(rs.getInt("id_escritor"));
                esc.setNome(rs.getString("nome"));
            }
            return esc;
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
            
        
        
    }
    
    @Override
    public ArrayList<Escritor> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Escritor> todosEscritores = new ArrayList();
        
        String sqlListarTodos = "SELECT id, nome FROM escritor";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {
                Escritor esc = new Escritor();
                esc.setId(rs.getInt("id"));
                esc.setNome(rs.getString("nome"));
                todosEscritores.add(esc);
            }
            return todosEscritores;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
        
    }
        
}

package br.com.dado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.util.GerenciadorConexao;
import br.com.util.GerenciadorConexaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.negocio.Genero;

/**
 *
 * @author Charles Demetrius
 */
public class DAOGeneroReal implements DAOGenero {
    
   final private GerenciadorConexao gerenciador;
    
    public DAOGeneroReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    public void incluir(Genero g)throws ConexaoException,DAOException{
        
        Connection cc = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO genero (descricao) VALUES (?)";
        
        try {
            PreparedStatement pstm = cc.prepareStatement(sqlInsert);
            pstm.setString(1, g.getDescricao());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(cc);
        }        
    }
    
    public void excluir(Integer idGenero) throws ConexaoException, DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM Genero WHERE idGenero =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, idGenero);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
    }
    
    public void alterar(Genero g) throws ConexaoException,DAOException{
        
          Connection con = gerenciador.conectar();
          
        String sql = "UPDATE Genero SET descricao =? WHERE idGenero=?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, g.getDescricao() );
            
            pstm.setInt(2, g.getIdGenero() );
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(con);
        }
        
        
    }
    
    
    public Genero retrieve(int idGenero) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        Genero g = null;
        
        String sqlRetrieve = "SELECT id_genero, descricao FROM genero WHERE id_genero=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, idGenero);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                g = new Genero();
                g.getIdGenero(rs.getInt("id_genero"));
                g.setDescricao(rs.getString("descricao"));
            }
            return g;
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
    
    public ArrayList<Genero> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Genero> listar = new ArrayList();
        
        String sqlListarTodos = "SELECT idGenero, Descricao FROM Genero";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {                
                Genero g = new Genero();
                g.getIdGenero(rs.getInt("idGenero"));
                g.getDescricao(rs.getString("Descricao"));
                listar.add(g);
            }
            return listar;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

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
import br.com.negocio.Livro;

/**
 *
 * @author Lucas Xavier
 */
public class DAOLivroReal implements DAOLivro{
    
    final private GerenciadorConexao gerenciador;
    
    public DAOLivroReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    public void incluir(Livro lv)throws ConexaoException,DAOException{
        
        Connection cc = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO Livro (idLivro, titulo, preco) VALUES (?,?,?)";
        
        try {
            PreparedStatement pstm = cc.prepareStatement(sqlInsert);
            pstm.setInt(1, lv.getIdLivro());
            pstm.setString(3, lv.getTitulo() );
            pstm.setFloat(2, lv.getPreco());
         
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(cc);
        }        
    }
    
    public void excluir(Integer idLivro) throws ConexaoException,DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM Livro WHERE Id_Livro =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, idLivro);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
    }
    
    public void alterar(Livro lv) throws ConexaoException,DAOException{
        
          Connection con = gerenciador.conectar();
          
        String sql = "UPDATE Livro SET titulo=?, preco=? WHERE Id_Livro=?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, lv.getTitulo() );
            pstm.setFloat(2, lv.getPreco());
        
            pstm.setInt(3, lv.getIdLivro());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(con);
        }
        
        
    }
    
    public Livro retrieve(int idLivro) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        Livro lv = null;
        
        String sqlRetrieve = "SELECT Id_Livro, titulo, preco FROM Livro WHERE Id_Livro=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, idLivro);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                
                lv = new Livro();
                
                lv.setIdLivro(rs.getInt("Id_Livro"));
                lv.setTitulo(rs.getString("titulo"));
                lv.setPreco(rs.getFloat("preco"));
               
            }
            return lv;
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
    
    public ArrayList<Livro> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Livro> listar = new ArrayList();
        
        String sqlListarTodos =  "SELECT Id_Livro, titulo, preco FROM Livro WHERE Id_Livro=?";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {     
                
                Livro lv = new Livro();
                
                lv.setIdLivro(rs.getInt("Id_Livro"));
                lv.setTitulo(rs.getString("titulo"));
                lv.setPreco(rs.getFloat("preco"));
              
                
                listar.add(lv);
            }
            return listar;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
}

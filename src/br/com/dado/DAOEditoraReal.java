/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.negocio.Editora;
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

/**
 *
 * @author Celson Rodrigues
 */
public class DAOEditoraReal implements DAOEditora{
    
    final private GerenciadorConexao gerenciador;
    
    public DAOEditoraReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    @Override
    public void incluir(Editora edit)throws ConexaoException,DAOException{
        
        Connection c = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO editora (nome, endereco, telefone) VALUES (?,?,?)";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlInsert);
            pstm.setString(1, edit.getNome());
            pstm.setString(2, edit.getEndereco());
            pstm.setString(3, edit.getTelefone());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(c);
        }        
    }
    
    @Override
    public void excluir(Integer id_escritor) throws ConexaoException,DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM editora WHERE id_escritor =?";
        
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
    
    @Override
    public void alterar(Editora edit) throws ConexaoException,DAOException{
        
        
    }
    
    @Override
    public Editora retrieve(int id_editora) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        Editora edit = null;
        
        String sqlRetrieve = "SELECT id_editora, nome, endereco FROM editora WHERE id=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, id_editora);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                edit = new Editora();
                edit.setId_editora(rs.getInt("id_editora"));
                edit.setNome(rs.getString("nome"));
                edit.setTelefone(rs.getString("telefone"));
                edit.setEndereco(rs.getString("endereco"));
            }
            return edit;
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
    
    @Override
    public ArrayList<Editora> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Editora> listar = new ArrayList();
        
        String sqlListarTodos = "SELECT id, nome, endereco, telefone FROM editora";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {                
                Editora edit = new Editora();
                edit.setId_editora(rs.getInt("id_editora"));
                edit.setNome(rs.getString("nome"));
                edit.setEndereco(rs.getString("endereco"));
                edit.setTelefone(rs.getString("telefone"));
                listar.add(edit);
            }
            return listar;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
        
    
    
}

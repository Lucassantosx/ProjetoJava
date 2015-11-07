/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.util.GerenciadorConexao;
import br.com.util.GerenciadorConexaoImpl;
import java.sql.Connection;
import br.com.error.*;
import br.com.negocio.Forma_pgto;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Celson Rodrigues
 */

public class DAOForma_pgtoReal implements DAOForma_pgto{
    
    private GerenciadorConexao gerenciador;
    
    public DAOForma_pgtoReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    @Override
    public void incluir(Forma_pgto f) throws ConexaoException, DAOException{
        
        Connection c = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO forma_pgto (descricao) VALUES (?)";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlInsert);
            pstm.setString(1, f.getDescricao());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(c);
            } 
    }
    
    @Override
    public void excluir(Integer id_forma_pgto) throws ConexaoException, DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM escritor WHERE id_escritor =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, id_forma_pgto);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
    }
    
    /**
     * alterar um escritor, envia um esc como parametros
     * @param f
     * @throws ConexaoException
     * @throws DAOException
     */
    
    public void alterar(Forma_pgto f) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        String sqlAlterar = "UPDATE forma_pgto SET descricao WHERE id=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlAlterar);
            pstm.setString(1, f.getDescricao());
            pstm.executeUpdate();
        } catch (Exception e) {
        }finally{
            gerenciador.desconectar(conn);
        }
    }
            
    
    
    @Override
    public Forma_pgto retrieve(int id_forma_pgto) throws ConexaoException, DAOException{
        
        Connection conn = gerenciador.conectar();
        Forma_pgto f = null;
        
        String sqlRetrieve = "SELECT id_escritor, nome FROM escritor WHERE id=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, id_forma_pgto);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                f = new Forma_pgto();
                f.setId(rs.getInt("id_forma_pgto"));
                f.setDescricao(rs.getString("Descrição"));
            }
            
            return f ;
            
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
            
        
        
    }
    
    
    public ArrayList<Forma_pgto> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Forma_pgto> FormaPgto = new ArrayList();
        
        String sqlListarTodos = "SELECT id, nome FROM forma_pgto";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {
                Forma_pgto fmp = new Forma_pgto();
                fmp.setId(rs.getInt("id"));
                fmp.setDescricao(rs.getString("Descrição"));
                FormaPgto.add(fmp);
            }
            return FormaPgto;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
        
    }
        
}
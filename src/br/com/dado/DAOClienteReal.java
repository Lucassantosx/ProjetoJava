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
import br.com.negocio.Cliente;

/**
 *
 * @author Celson Rodrigues
 */
public class DAOClienteReal implements DAOCliente {
        
    final private GerenciadorConexao gerenciador;
    
    public DAOClienteReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    @Override
    public void incluir(Cliente c)throws ConexaoException,DAOException{
        
        Connection cc = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO cliente (nome, identidade, cpf, endereco, telefone, email, sexo) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pstm = cc.prepareStatement(sqlInsert);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getIdentidade());
            pstm.setString(3, c.getCPF());
            pstm.setString(4, c.getEndereco());
            pstm.setString(5, c.getTelefone());
            pstm.setString(6, c.getEmail());
            pstm.setString(7, c.getSexo());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(cc);
        }        
    }
    
    
    @Override
    public void excluir(Integer idCliente) throws ConexaoException, DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM Cliente WHERE id_Cliente =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, idCliente);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
    }
    
    public void alterar(Cliente c) throws ConexaoException,DAOException{
        
          Connection con = gerenciador.conectar();
          
        String sql = "UPDATE Cliente SET cpf=? nome=?, endereco=?, telefone=?, email=?, sexo=? WHERE idCliente=?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, c.getCPF() );
            pstm.setString(2, c.getNome() );
            pstm.setString(3, c.getEndereco());
            pstm.setString(4, c.getTelefone());
            pstm.setString(5, c.getEmail());
            pstm.setString(6, c.getSexo());
            
            pstm.setInt(7, c.getIdCliente());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(con);
        }
        
        
    }
    
    public Cliente retrieve(int idCliente) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        Cliente c = null;
        
        String sqlRetrieve = "SELECT Id_Cliente, cpf, nome, telefone, endereco, email, sexo FROM Cliente WHERE idCliente=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, idCliente);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setIdCliente(rs.getInt("Id_Cliente"));
                c.setCPF(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereço(rs.getString("endereco"));
                c.setEmail(rs.getString("email"));
                c.setSexo(rs.getString("sexo"));
            }
            return c;
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
    
    public ArrayList<Cliente> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Cliente> listar = new ArrayList();
        
        String sqlListarTodos = "SELECT idCliente, Cpf,  nome, endereco, telefone, email, sexo FROM Cliente";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {                
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_editora"));
                c.setCPF(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setEndereço(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("Email"));
                c.setSexo(rs.getString("Sexo"));
                listar.add(c);
            }
            return listar;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
    }
}
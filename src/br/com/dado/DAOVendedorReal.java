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
import br.com.negocio.Vendedor;

/**
 *
 * @author Lucas Xavier
 */
public class DAOVendedorReal implements DAOVendedor{
    
     final private GerenciadorConexao gerenciador;
    
    public DAOVendedorReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    public void incluir(Vendedor v)throws ConexaoException,DAOException{
        
        Connection cc = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO Vendedor (matricula, salario, nome, endereco, telefone, email, sexo) VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pstm = cc.prepareStatement(sqlInsert);
            pstm.setInt(1, v.getMatricula() );
            pstm.setDouble(2, v.getSalario());
            pstm.setString(3, v.getNome() );
            pstm.setString(4, v.getEndereço());
            pstm.setString(5, v.getTelefone());
            pstm.setString(6, v.getEmail());
            pstm.setString(7, v.getSexo());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(cc);
        }        
    }
    
    public void excluir(Integer matricula) throws ConexaoException,DAOException{
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM Vendedor WHERE matricula =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, matricula);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
    }
    
    public void alterar(Vendedor v) throws ConexaoException,DAOException{
        
          Connection con = gerenciador.conectar();
          
        String sql = "UPDATE Vendedor SET salario=?, nome=?, endereco=?, telefone=?, email=?, sexo=? WHERE matricula=?";
        try{
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDouble(1, v.getSalario() );
            pstm.setString(2, v.getNome() );
            pstm.setString(3, v.getEndereço());
            pstm.setString(4, v.getTelefone());
            pstm.setString(5, v.getEmail());
            pstm.setString(6, v.getSexo());
            
            pstm.setInt(7, v.getMatricula());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(con);
        }
        
        
    }
    
    public Vendedor retrieve(int idCliente) throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        Vendedor v = null;
        
        String sqlRetrieve = "SELECT matricula, salario, nome, telefone, endereco, email, sexo FROM Vendedor WHERE matricula=?";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sqlRetrieve);
            pstm.setInt(1, idCliente);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                
                v = new Vendedor();
                
                v.setMatricula(rs.getInt("matricula"));
                v.setSalario(rs.getDouble("Salario"));
                v.setNome(rs.getString("nome"));
                v.setTelefone(rs.getString("telefone"));
                v.setEndereço(rs.getString("endereco"));
                v.setEmail(rs.getString("email"));
                v.setSexo(rs.getString("sexo"));
            }
            return v;
        } catch (Exception e) {
            throw new DAOException();
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
    
    public ArrayList<Vendedor> ListarTodos() throws ConexaoException,DAOException{
        
        Connection conn = gerenciador.conectar();
        
        ArrayList<Vendedor> listar = new ArrayList();
        
        String sqlListarTodos = "SELECT Matricula, salario,  nome, endereco, telefone, email, sexo FROM editora";
        
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlListarTodos);
            while (rs.next()) {     
                
                Vendedor v = new Vendedor();
                
                v.setMatricula(rs.getInt("Matricula"));
                v.setSalario(rs.getDouble("salario"));
                v.setNome(rs.getString("nome"));
                v.setEndereço(rs.getString("endereco"));
                v.setTelefone(rs.getString("telefone"));
                v.setEmail(rs.getString("Email"));
                v.setSexo(rs.getString("Sexo"));
                
                listar.add(v);
            }
            return listar;
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(conn);
        }
    }
    
}

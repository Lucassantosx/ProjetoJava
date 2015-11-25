/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dado;

import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.negocio.Venda;
import br.com.util.GerenciadorConexao;
import br.com.util.GerenciadorConexaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class DAOVendaReal implements DAOVenda{

    final private GerenciadorConexao gerenciador;
    
    public DAOVendaReal(){
        
        gerenciador = GerenciadorConexaoImpl.getInstancia();
        
    }
    
    @Override
    public void incluirVenda(Venda v) throws ConexaoException, DAOException {
        
        Connection cc = gerenciador.conectar();
        
        String sqlInsert = "INSERT INTO venda (Data, cliente, livro, vendedor) VALUES (?,?,?,?)";
        
        
        try {
            PreparedStatement pstm = cc.prepareStatement(sqlInsert);
            pstm.setString(1, v.getData());
            pstm.setObject(2, v.getCliente() );
            pstm.setObject(3, v.getLivro() );
            pstm.setObject(4, v.getVendedor() );
            
            pstm.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e);
        }finally{
            gerenciador.desconectar(cc);
        }   
        
    }

    @Override
    public void excluirVenda(Integer idVenda) throws ConexaoException, DAOException {
        
        
        Connection con = gerenciador.conectar();
        
        String sqlExcluir = "DELETE FROM Venda WHERE id_Venda =?";
        
        try {
            PreparedStatement pstm = con.prepareStatement(sqlExcluir);
            pstm.setInt(1, idVenda);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }finally{
            gerenciador.desconectar(con);
        }
        
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JOptionPane;
import br.com.error.ConexaoException;
import br.com.util.GerenciadorConexao;
import br.com.util.GerenciadorConexaoImpl;

/**
 *
 * @author aluno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testarConexao();
        
       
    }
    
     private static void testarConexao(){
            GerenciadorConexao g;
            g = GerenciadorConexaoImpl.getInstancia();
            try {
             g.conectar();
                JOptionPane.showMessageDialog(null, "Conexão Estabelicida");               
         } catch (ConexaoException e) {
             JOptionPane.showMessageDialog(null, "Erro ao conectar com DB" + e.getMessage());
         }
        }
    
}

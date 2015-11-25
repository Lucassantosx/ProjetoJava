/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio.regras;

import br.com.error.CampoVazioException;
import br.com.error.ConexaoException;
import br.com.error.DAOException;
import br.com.error.GeralException;
import br.com.dado.DAOVenda;
import br.com.dado.DAOVendaReal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class RNVendas {
    
     private final DAOVenda dao;
    
    public RNVendas(){
        
        dao = new DAOVendaReal();
        
    }

    // Celson É basicamente assim, não conseguir concluir. Da uma olhadinha por favor
    // Author: Lucas Xavier
    
   public void cadastrarVenda() throws ConexaoException, DAOException{
   
    if (.size() == 0){  
           JOptionPane.showMessageDialog(null, "Inclua pelo menos um produto!");  
       }
    
    else {  
           try {  
               VendasControl vc = new VendasControl();  
               SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
               java.util.Date d = new java.util.Date();  
               Date data = Date.valueOf(formato.format(d));  
               int codigo = vc.buscarCodigoUltimaVenda() + 1;  
               for (int i = 0; i < venda.size(); i++){  
                   venda.get(i).setClientes_Codigo(clientes.get(cbClientes.getSelectedIndex()).getCodigo());  
                   venda.get(i).setDataVenda(data);  
                   venda.get(i).setCodigo(codigo);  
                   vc.cadastrarVenda(venda.get(i));  
               }  
               JOptionPane.showMessageDialog(this, "Venda cadastrada com sucesso!");  
           } catch (Exception ex) {  
               JOptionPane.showMessageDialog(this, "Erro ao cadastrar Venda!");  
           }  
       }  
       
   } 
    
    
}

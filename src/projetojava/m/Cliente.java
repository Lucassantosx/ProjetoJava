/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojava.m;

/**
 *
 * @author Lucas Xavier
 */
public class Cliente  extends Pessoa{

	private int CPF ;
	
	public Cliente(String nome, String endereço, String telefone,String email, String sexo, int CPF) {
		super(nome, endereço, telefone,email,sexo);
                
		this.CPF = CPF;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

}

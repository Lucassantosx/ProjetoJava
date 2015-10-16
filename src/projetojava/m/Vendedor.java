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
public class Vendedor extends Pessoa{
    
    
    private double salario ;
	private int matricula ;
	
	
	public Vendedor(String nome, String endereço, String telefone,String email,String sexo,
			double salario, int matricula) {
		super(nome, endereço, telefone, email, sexo);
             
		this.salario = salario;
		this.matricula = matricula;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	
}



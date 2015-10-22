/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Lucas Xavier
 */
    
    abstract class Pessoa {
	
	private String nome ;
	private String endereço ;
	private String telefone ;
	private String email ;
        private String sexo;
	
	public Pessoa(String nome, String endereço, String telefone, String email, String sexo ) {
		super();
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.email = email ;
                this.sexo = sexo ;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereço() {
		return endereço;
	}


	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
	
	
        
	
	}
    


package loja;

//Autor: Paulo Szpikula, 29/10/2015 20:00
//Descrição: Classe usuario

public class Usuario {

	private String id;
	private String idDoCliente;
	private String senha;
	
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdDoCliente() {
		return idDoCliente;
	}
	
	public void setIdDoCliente(String idDoCliente) {
		this.idDoCliente = idDoCliente;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}

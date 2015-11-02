package loja;

//Autor: Paulo Szpikula, 29/10/2015 20:00
//Descrição: Classe usuario

public class Usuario {

	private int id;
	private int idDoCliente;
	private String senha;
	
	
	
	public Usuario(int id, int idDoCliente, String senha) {
		super();
		this.id = id;
		this.idDoCliente = idDoCliente;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdDoCliente() {
		return idDoCliente;
	}
	
	public void setIdDoCliente(int idDoCliente) {
		this.idDoCliente = idDoCliente;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}

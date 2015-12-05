package loja;

//Autor: Paulo Szpikula, 29/10/2015 20:00
//Descrição: Classe usuario

public class Usuario {

	private int id;
	private int idDoCliente;
	private String nome;
	private String senha;
	
	
	
	public Usuario(int id, int idDoCliente, String nome, String senha) {
		super();
		this.id = id;
		this.idDoCliente = idDoCliente;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}

package loja;

//Autor: Paulo Szpikula, 21/11/2015 08:33
//Descrição: Classe Pedido

public class Pedido {
	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String estado;
	private String email;
	private String genero;

	private int id_pedido;
	
	public Pedido(int id, String nome, String telefone, String endereco, String cidade, String estado, String email, String genero, int id_pedido) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
		this.id_pedido = id_pedido;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}	
	
	public int getId_pedido() {
		return id_pedido;
	}
	
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
}








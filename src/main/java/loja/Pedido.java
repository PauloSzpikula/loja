package loja;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

//Autor: Paulo Szpikula, 21/11/2015 08:33
//Descrição: Classe Pedido

public class Pedido {
	private int id;
	private int id_cliente;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String estado;
	private String email;
	private String genero;
	private BigDecimal total;
	private BigDecimal valor_pago;
	private BigDecimal troco;
	private boolean status;
	private Timestamp data;
	
	public Pedido(int id, int id_cliente, String nome, String telefone, String endereco, String cidade, String estado, String email, String genero, BigDecimal total, BigDecimal valor_pago, BigDecimal troco, boolean status, Timestamp data) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;		
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
		this.total = total;
		this.valor_pago = valor_pago;
		this.troco = troco;
		this.status = status;
		this.data = data;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	
	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}


	public BigDecimal getTotal() {
		return total;
	}

	public BigDecimal getValor_pago() {
		return valor_pago;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void setValor_pago(BigDecimal valor_pago) {
		this.valor_pago = valor_pago;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
}
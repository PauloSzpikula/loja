package loja;

import java.math.BigDecimal;

//Autor: Paulo Szpikula, 29/10/2015 19:45
//Descri��o: Classe Produto

public class Produto {

	private int id;
	private float codigoDeBarras;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal valor;
	private BigDecimal margemDeLucro;
	
	public Produto(int id, float codigoDeBarras, String categoria, String descricao, String unidade, BigDecimal valor, BigDecimal margemDeLucro) {
		super();
		this.id = id;
		this.codigoDeBarras = codigoDeBarras;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.valor = valor;
		this.margemDeLucro = margemDeLucro;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getCodigoDeBarras() {
		return codigoDeBarras;
	}
	
	public void setCodigoDeBarras(float codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getMargemDeLucro() {
		return margemDeLucro;
	}
	
	public void setMargemDeLucro(BigDecimal margemDeLucro) {
		this.margemDeLucro = margemDeLucro;
	}
}

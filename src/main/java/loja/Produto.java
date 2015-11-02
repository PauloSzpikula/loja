package loja;

import java.math.BigDecimal;

//Autor: Paulo Szpikula, 29/10/2015 19:45
//Descrição: Classe Produto

public class Produto {

	private int id;
	private float codigoDeBarras;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal margemDeLucro;
	
	public Produto(int id, float codigoDeBarras, String categoria, String descricao, String unidade, BigDecimal custo, BigDecimal margemDeLucro) {
		super();
		this.id = id;
		this.codigoDeBarras = codigoDeBarras;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.margemDeLucro = margemDeLucro;
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
	
	public BigDecimal getCusto() {
		return custo;
	}
	
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	
	public BigDecimal getMargemDeLucro() {
		return margemDeLucro;
	}
	
	public void setMargemDeLucro(BigDecimal margemDeLucro) {
		this.margemDeLucro = margemDeLucro;
	}
}

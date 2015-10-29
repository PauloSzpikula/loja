package loja;

import java.math.BigDecimal;

//Autor: Paulo Szpikula, 29/10/2015 19:45
//Descrição: Classe Produto

public class Produto {

	private int id;
	private float codigoDeBarras;
	private Categoria categoria;
	private String descricao;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemDeLucro;
	
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Unidade getUnidade() {
		return unidade;
	}
	
	public void setUnidade(Unidade unidade) {
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

package loja;

import java.math.BigDecimal;

public class Item {

	private int id;
	private int id_pedido;
	private int id_produto;
	private float codigoDeBarras;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal valor;
	private BigDecimal margemDeLucro;
	private int quantidade;
	private BigDecimal valot_total;
	
	
	public Item(int id, int id_pedido, int id_produto, float codigoDeBarras, String categoria, String descricao, String unidade, BigDecimal valor, BigDecimal margemDeLucro, int quantidade, BigDecimal valot_total) {
		super();
		this.id = id;
		this.id_pedido = id_pedido;
		this.id_produto = id_produto;
		this.codigoDeBarras = codigoDeBarras;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.valor = valor;
		this.margemDeLucro = margemDeLucro;
		this.quantidade = quantidade;
		this.valot_total = valot_total;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValot_total() {
		return valot_total;
	}
	public void setValot_total(BigDecimal valot_total) {
		this.valot_total = valot_total;
	}
	
	
		
}

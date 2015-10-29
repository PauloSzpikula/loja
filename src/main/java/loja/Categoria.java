package loja;

// Autor: Paulo Szpikula, 29/10/2015 19:35
// Descri��o: Enum de categorias dos produtos

public enum Categoria {

	LIMPEZA("Limpeza"),
	PECAS("Pe�as"),
	ALIMENTACAO("Alimenta��o"),
	ETC("Etc");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Categoria(String nome) {
		this.nome = nome;
	}
}

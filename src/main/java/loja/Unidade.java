package loja;

//Autor: Paulo Szpikula, 29/10/2015 19:50
//Descrição: Enum das unidades dos produtos

public enum Unidade {

	KG ("Kilograma"), 
	UN ("Unidade"),
	PCT ("Pacote"),
	CX ("Caixa");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Unidade(String nome) {
		this.nome = nome;
	}
}

package loja;

//Autor: Paulo Szpikula, 29/10/2015 19:40
//Descrição: Enum dos generos

public enum Genero {
	
	M ("Maculino"),
	F ("Feminino");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Genero(String nome) {
		this.nome = nome;
	}

}

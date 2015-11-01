package loja;

import java.util.List;

//Autor: Paulo Szpikula, 31/10/2015 21:30
//Descrição: Interface do modelo cliente 

public interface ClienteDao {

	public void inserir(Cliente c);

	public List<Cliente> listar();
	
	public void atualizar(Cliente c);

	public void excluir(Cliente c);
	
}

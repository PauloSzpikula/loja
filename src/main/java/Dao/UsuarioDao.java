package Dao;

import java.util.List;

import loja.Cliente;

//Autor: Paulo Szpikula, 31/10/2015 21:30
//Descrição: Interface do modelo cliente 

public interface UsuarioDao {

	public void inserir(Cliente c);

	public List<Cliente> listar();
	
	public void atualizar(Cliente c);

	public void excluir(Cliente c);
	
}

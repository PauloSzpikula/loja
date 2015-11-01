package Dao;

import java.sql.Connection;
import java.util.List;

import loja.Cliente;

//Autor: Paulo Szpikula, 31/10/2015 21:40
//Descrição: Implementação da Interface para manipular o modelo do cliente 

public class ProdutoDaoImpl implements ClienteDao {

private static Connection con;
	
	private Connection getConnection() {
		
		synchronized (con) {
			if (con == null) {
				
			}
			return con;
		}
	}
	
	public void inserir(Cliente c) {
	
	}

	public List<Cliente> listar() {
		
		return null;
	}
	
	public void atualizar(Cliente c) {
		
	}

	public void excluir(Cliente c) {
		
	}
	
}

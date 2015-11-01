package Dao;

import java.sql.SQLException;
import java.util.List;
import loja.Cliente;

//Autor: Paulo Szpikula, 31/10/2015 21:30
//Descrição: Interface do modelo cliente 

public interface ClienteDao {

	public void abrirConexao() throws SQLException;
	public void fecharConexao() throws SQLException;

	public void create(Cliente c) throws SQLException;
	public List<Cliente> read() throws SQLException;
	public void update(Cliente c) throws SQLException;
	public void delete(Cliente c) throws SQLException;
}

package dao;

import java.sql.SQLException;
import java.util.List;

import loja.Cliente;
import loja.Usuario;

//Autor: Paulo Szpikula, 31/10/2015 21:30
//Descrição: Interface do modelo usuario 

public interface UsuarioDao {

	public void abrirConexao() throws SQLException;
	public void fecharConexao() throws SQLException;

	public void create(Usuario u) throws SQLException;
	public List<Usuario> read() throws SQLException;
	public void update(Usuario u) throws SQLException;
	public void delete(int id) throws SQLException;
}

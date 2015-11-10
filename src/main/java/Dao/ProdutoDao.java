package Dao;

import java.sql.SQLException;
import java.util.List;
import loja.Produto;

//Autor: Paulo Szpikula, 31/10/2015 21:30
//Descrição: Interface do modelo produto 

public interface ProdutoDao {

	public void abrirConexao() throws SQLException;
	public void fecharConexao() throws SQLException;

	public void create(Produto p) throws SQLException;
	public List<Produto> read() throws SQLException;
	public void update(Produto p) throws SQLException;
	public void delete(int id) throws SQLException;
}

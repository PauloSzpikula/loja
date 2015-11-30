package Dao;

import java.sql.SQLException;
import java.util.List;

import loja.Item;

//Autor: Paulo Szpikula, 29/11/2015 22:36
//Descrição: Interface do modelo Item

public interface ItemDao {

	public void abrirConexao() throws SQLException;
	public void fecharConexao() throws SQLException;

	public void create(Item i) throws SQLException;
	public List<Item> read() throws SQLException;
	public void update(Item p) throws SQLException;
	public void delete(int id) throws SQLException;
}

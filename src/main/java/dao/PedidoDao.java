package dao;

import java.sql.SQLException;
import java.util.List;
import loja.Pedido;

//Autor: Paulo Szpikula, 21/11/2015 08:04
//Descrição: Interface do modelo Pedido

public interface PedidoDao {

	public void abrirConexao() throws SQLException;
	public void fecharConexao() throws SQLException;

	public void create(Pedido p) throws SQLException;
	public List<Pedido> read() throws SQLException;
	public void update(Pedido p) throws SQLException;
	public void delete(int id) throws SQLException;
}

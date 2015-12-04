package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import loja.Cliente;
import loja.Item;
import loja.Item;

//Autor: Paulo Szpikula, 29/11/2015 22:36
//Descrição: Implementação da Interface para manipular o modelo do Item

public class ItemDaoImpl implements ItemDao {

	private Connection con;
//	CREATE TABLE ITEM(ID INT AUTO_INCREMENT PRIMARY KEY, ID_PEDIDO INT, ID_PRODUTO INT, CODBARRAS DOUBLE, CATEGORIA VARCHAR(30), DESCRICAO VARCHAR(50), UNIDADE VARCHAR(5), VALOR DECIMAL(18,2), MARGEMLUCRO DECIMAL(18,2), QUANTIDADE INT, VALORTOTAL DECIMAL(18,2));	
	
	@Override
	public void abrirConexao() throws SQLException {
		String url = "jdbc:h2:~/trabalho4Bimestre";
		String user = "sa";
		String pass = "sa";
		con = DriverManager.getConnection(url, user, pass);
	}
	
	@Override
	public void fecharConexao() throws SQLException {
		con.close();
	}
	
	@Override
	public void create(Item i) throws SQLException {
		abrirConexao();
		//preparando o comando SQL
		PreparedStatement ps = con.prepareStatement("INSERT INTO ITEM (ID_PEDIDO, ID_PRODUTO, CODBARRAS, CATEGORIA, DESCRICAO, UNIDADE, VALOR, MARGEMLUCRO, QUANTIDADE, VALORTOTAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, i.getId_pedido());		
		ps.setInt(2, i.getId_produto());
		ps.setFloat(3, i.getCodigoDeBarras());
		ps.setString(4, i.getCategoria());
		ps.setString(5, i.getDescricao());
		ps.setString(6, i.getUnidade());
		ps.setBigDecimal(7, i.getValor());
		ps.setBigDecimal(8, i.getMargemDeLucro());
		ps.setInt(9, i.getQuantidade());
		ps.setBigDecimal(10, i.getValot_total());
		//executando o comando SQL
		ps.executeUpdate();
		//fechando a conexão
		ps.close();
		fecharConexao();
	}
	
	@Override
	public ArrayList<Item> read() throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		ArrayList<Item> lista = new ArrayList<Item>();
		
		abrirConexao();
		//preparando o comando SQL
		Statement st = con.createStatement();
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery("SELECT * FROM ITEM");
		// percorremos os registros um a um adicionando na lista
		while (result.next()) {
			int id = result.getInt(1);
			int id_pedido = result.getInt(2);		
			int id_produto = result.getInt(3);
			float codigoDeBarras = result.getFloat(4);
			String categoria = result.getString(5);
			String descricao = result.getString(6);
			String unidade = result.getString(7);
			BigDecimal valor = result.getBigDecimal(8);
			BigDecimal margemDeLucro = result.getBigDecimal(9);
			int quantidade = result.getInt(10);
			BigDecimal valot_total = result.getBigDecimal(11);
			Item i = new Item(id, id_pedido, id_produto, codigoDeBarras, categoria, descricao, unidade, valor, margemDeLucro, quantidade, valot_total);
			lista.add(i);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	@Override
	public void update(Item p) throws SQLException {
		abrirConexao();
		
		PreparedStatement sql = con.prepareStatement("UPDATE ITEM SET ID_PEDIDO = ?, ID_PRODUTO = ?, CODBARRAS = ?, CATEGORIA = ?, DESCRICAO = ?, UNIDADE = ?, VALOR = ?, MARGEMLUCRO = ?, QUANTIDADE = ?, VALORTOTAL = ?, WHERE ID = ?");
		sql.setInt(1, p.getId_pedido());
		sql.setInt(2, p.getId_produto());
		sql.setFloat(3, p.getCodigoDeBarras());
		sql.setString(4, p.getCategoria());
		sql.setString(5, p.getDescricao());
		sql.setString(6, p.getUnidade());
		sql.setBigDecimal(7, p.getValor());
		sql.setBigDecimal(8, p.getMargemDeLucro());
		sql.setInt(9, p.getQuantidade());
		sql.setBigDecimal(10, p.getValot_total());
		sql.setInt(11, p.getId());
		//executando o comando SQL
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
	@Override
	public void delete(int id) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("DELETE FROM ITEM WHERE ID = ?");
		sql.setInt(1, id);
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
	

	public Item pegaItem(int id) throws SQLException {

		abrirConexao();
	
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM ITEM WHERE ID = "+ id + " LIMIT 1");
		
		Item item = new Item();
		
		while (result.next()) {
			item.setId(result.getInt(1));
			item.setId_pedido(result.getInt(2));
			item.setId_produto(result.getInt(3));
			item.setCodigoDeBarras(result.getFloat(4));
			item.setCategoria(result.getString(5));
			item.setDescricao(result.getString(6));
			item.setUnidade(result.getString(7));
			item.setValor(result.getBigDecimal(8));
			item.setMargemDeLucro(result.getBigDecimal(9));
			item.setQuantidade(result.getInt(10));
			item.setValot_total(result.getBigDecimal(11));
		}

		fecharConexao();
		// retorna a lista completa
		return item;
	}

	public ArrayList<String> listaIdProdutos() throws SQLException {
		ArrayList<String> lista = new ArrayList<String>();
		
		abrirConexao();
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("SELECT ID, DESCRICAO FROM PRODUTO");
		while (result.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append(result.getInt(1));
			sb.append(" - ");
			sb.append(result.getString(2));
			lista.add(sb.toString());
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}

	public ArrayList<Item> ListaItensDoId(int id) throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		ArrayList<Item> lista = new ArrayList<Item>();
		
		abrirConexao();
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM ITEM WHERE ID_PEDIDO = "+ id);
		
		// percorremos os registros um a um adicionando na lista
		while (result.next()) {
			//int id = result.getInt(1);
			int id_pedido = result.getInt(2);		
			int id_produto = result.getInt(3);
			float codigoDeBarras = result.getFloat(4);
			String categoria = result.getString(5);
			String descricao = result.getString(6);
			String unidade = result.getString(7);
			BigDecimal valor = result.getBigDecimal(8);
			BigDecimal margemDeLucro = result.getBigDecimal(9);
			int quantidade = result.getInt(10);
			BigDecimal valot_total = result.getBigDecimal(11);
			Item item = new Item(id, id_pedido, id_produto, codigoDeBarras, categoria, descricao, unidade, valor, margemDeLucro, quantidade, valot_total);
			lista.add(item);
		}

		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	
	public void somaTotal(int id) throws SQLException {
		 
		abrirConexao();
		PreparedStatement ps = con.prepareStatement("UPDATE ITEM SET VALORTOTAL = (SELECT SUM(VALOR) FROM ITEM WHERE pedido_id = ?) where id = ?");
		ps.setInt(1, id);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
		fecharConexao();
		
	}

	
	
//	public void somaTotal(int id) throws SQLException {
//		 
//		abrirConexao();
//		PreparedStatement ps = con.prepareStatement("UPDATE PRODUTO SET VALORTOTAL = (SELECT SUM(VALOR) FROM ITEM WHERE pedido_id = ?) where id = ?");
//		ps.setInt(1, id);
//		ps.setInt(2, id);
//		ps.executeUpdate();
//		ps.close();
//		fecharConexao();
//		
//	}

}
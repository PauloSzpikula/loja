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

import loja.Item;
import loja.Item;

//Autor: Paulo Szpikula, 29/11/2015 22:36
//Descrição: Implementação da Interface para manipular o modelo do Item

public class ItemDaoImpl implements ItemDao {

	private Connection con;
//	CREATE TABLE ITEM(ID INT PRIMARY KEY, ID_PEDIDO INT, ID_PRODUTO INT, CODBARRAS DOUBLE, CATEGORIA VARCHAR(30), DESCRICAO VARCHAR(50), UNIDADE VARCHAR(5), CUSTO DECIMAL(18,2), MARGEMLUCRO DECIMAL(18,2), QUANTIDADE INT, VALORTOTAL DECIMAL(18,2));	
	
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
		PreparedStatement ps = con.prepareStatement("INSERT INTO ITEM (ID, ID_PEDIDO, ID_PRODUTO, CODBARRAS, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO, QUANTIDADE, VALORTOTAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, i.getId());
		ps.setInt(2, i.getId_pedido());		
		ps.setInt(3, i.getId_produto());
		ps.setFloat(4, i.getCodigoDeBarras());
		ps.setString(5, i.getCategoria());
		ps.setString(6, i.getDescricao());
		ps.setString(7, i.getUnidade());
		ps.setBigDecimal(8, i.getCusto());
		ps.setBigDecimal(9, i.getMargemDeLucro());
		ps.setInt(10, i.getQuantidade());
		ps.setBigDecimal(11, i.getValot_total());
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
			BigDecimal custo = result.getBigDecimal(8);
			BigDecimal margemDeLucro = result.getBigDecimal(9);
			int quantidade = result.getInt(10);
			BigDecimal valot_total = result.getBigDecimal(11);
			Item i = new Item(id, id_pedido, id_produto, codigoDeBarras, categoria, descricao, unidade, custo, margemDeLucro, quantidade, valot_total);
			lista.add(i);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	@Override
	public void update(Item p) throws SQLException {
		abrirConexao();
		
		PreparedStatement sql = con.prepareStatement("UPDATE ITEM SET ID = ?, ID_PEDIDO = ?, ID_PRODUTO = ?, CODBARRAS = ?, CATEGORIA = ?, DESCRICAO = ?, UNIDADE = ?, CUSTO = ?, MARGEMLUCRO = ?, QUANTIDADE = ?, VALORTOTAL = ?, WHERE ID = ?");
		sql.setInt(1, p.getId());
		sql.setInt(2, p.getId_pedido());
		sql.setInt(3, p.getId_produto());
		sql.setFloat(4, p.getCodigoDeBarras());
		sql.setString(5, p.getCategoria());
		sql.setString(6, p.getDescricao());
		sql.setString(7, p.getUnidade());
		sql.setBigDecimal(8, p.getCusto());
		sql.setBigDecimal(9, p.getMargemDeLucro());
		sql.setInt(10, p.getQuantidade());
		sql.setBigDecimal(11, p.getValot_total());
		sql.setInt(14, p.getId());
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
	

	public List<Item> pegaPedido(int x) throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		List<Item> lista = new ArrayList<Item>();
		abrirConexao();
	
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ITEM WHERE ID = ");
		sb.append(String.valueOf(x));
		sb.append(";");		
		Statement st = con.createStatement();
		
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery(String.valueOf(sb));

		while (result.next()) {

			int id = result.getInt(1);
			int id_pedido = result.getInt(2);		
			int id_produto = result.getInt(3);
			float codigoDeBarras = result.getFloat(4);
			String categoria = result.getString(5);
			String descricao = result.getString(6);
			String unidade = result.getString(7);
			BigDecimal custo = result.getBigDecimal(8);
			BigDecimal margemDeLucro = result.getBigDecimal(9);
			int quantidade = result.getInt(10);
			BigDecimal valot_total = result.getBigDecimal(11);
			
			Item i = new Item(id, id_pedido, id_produto, codigoDeBarras, categoria, descricao, unidade, custo, margemDeLucro, quantidade, valot_total);
			lista.add(i);
		}

		fecharConexao();
		// retorna a lista completa
		return lista;
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



}
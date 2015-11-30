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
import loja.Produto;

//Autor: Paulo Szpikula, 01/10/2015 09:11
//Descrição: Implementação da Interface para manipular o modelo do produto 

public class ProdutoDaoImpl implements ProdutoDao {

	private Connection con;

//	CREATE TABLE PRODUTO(ID INT PRIMARY KEY, CODBARRAS DOUBLE, CATEGORIA VARCHAR(30), DESCRICAO VARCHAR(50), UNIDADE VARCHAR(5), CUSTO DECIMAL(18,2), MARGEMLUCRO DECIMAL(18,2));
	
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
	public void create(Produto p) throws SQLException {
		abrirConexao();
		//preparando o comando SQL
		PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUTO (ID, CODBARRAS, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO) VALUES (?, ?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, p.getId());
		ps.setFloat(2, p.getCodigoDeBarras());
		ps.setString(3, p.getCategoria());
		ps.setString(4, p.getDescricao());
		ps.setString(5, p.getUnidade());
		ps.setBigDecimal(6, p.getValor());
		ps.setBigDecimal(7, p.getMargemDeLucro());
		//executando o comando SQL
		ps.executeUpdate();
		//fechando a conexão
		ps.close();
		fecharConexao();
	}
	
	@Override
	public ArrayList<Produto> read() throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		abrirConexao();
		//preparando o comando SQL
		Statement st = con.createStatement();
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery("SELECT * FROM PRODUTO");
		// percorremos os registros um a um adicionando na lista
		if (result != null) {
			while (result.next()) {
				int id = result.getInt(1);
				float codigoDeBarras = result.getFloat(2);
				String categoria = result.getString(3);
				String descricao = result.getString(4);
				String unidade = result.getString(5);
				BigDecimal valor = result.getBigDecimal(6);
				BigDecimal margemDeLucro = result.getBigDecimal(7);
				Produto p = new Produto(id, codigoDeBarras, categoria, descricao, unidade, valor, margemDeLucro);
				lista.add(p);
			}
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	@Override
	public void update(Produto p) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("UPDATE PRODUTO SET ID = ?, CODBARRAS = ?, CATEGORIA = ?, DESCRICAO = ?, UNIDADE = ?, CUSTO = ?, MARGEMLUCRO = ? WHERE ID = ?");
		sql.setInt(1, p.getId());
		sql.setFloat(2, p.getCodigoDeBarras());
		sql.setString(3, p.getCategoria());
		sql.setString(4, p.getDescricao());
		sql.setString(5, p.getUnidade());
		sql.setBigDecimal(6, p.getValor());
		sql.setBigDecimal(7, p.getMargemDeLucro());
		sql.setInt(8, p.getId());
		//executando o comando SQL
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
	@Override
	public void delete(int id) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
		sql.setInt(1, id);
		sql.executeUpdate();
		sql.close();
		//read();
		fecharConexao();
	}
	
	public List<Produto> pegaProduto(int x) throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		List<Produto> lista = new ArrayList<Produto>();
		
		abrirConexao();
		//preparando o comando SQL

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM PRODUTO WHERE ID = ");
		sb.append(String.valueOf(x));
		sb.append(";");		

		Statement st = con.createStatement();		
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery(String.valueOf(sb));
		// percorremos os registros um a um adicionando na lista
		while (result.next()) {
			int id = result.getInt(1);
			float codigoDeBarras = result.getFloat(2);
			String categoria = result.getString(3);
			String descricao = result.getString(4);
			String unidade = result.getString(5);
			BigDecimal valor = result.getBigDecimal(6);
			BigDecimal margemDeLucro = result.getBigDecimal(7);
			Produto p = new Produto(id, codigoDeBarras, categoria, descricao, unidade, valor, margemDeLucro);
			lista.add(p);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
}

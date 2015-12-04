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
import loja.Pedido;
import loja.Produto;

//Autor: Paulo Szpikula, 01/10/2015 09:11
//Descrição: Implementação da Interface para manipular o modelo do produto 

public class ProdutoDaoImpl implements ProdutoDao {

	private Connection con;

//	CREATE TABLE PRODUTO(ID INT AUTO_INCREMENT PRIMARY KEY, CODBARRAS DOUBLE, CATEGORIA VARCHAR(30), DESCRICAO VARCHAR(50), UNIDADE VARCHAR(5), CUSTO DECIMAL(18,2), MARGEMLUCRO DECIMAL(18,2));
	
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
		PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUTO (CODBARRAS, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO) VALUES (?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setFloat(1, p.getCodigoDeBarras());
		ps.setString(2, p.getCategoria());
		ps.setString(3, p.getDescricao());
		ps.setString(4, p.getUnidade());
		ps.setBigDecimal(5, p.getValor());
		ps.setBigDecimal(6, p.getMargemDeLucro());
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
	
	public Produto pegaProduto(int id) throws SQLException {

		abrirConexao();
		
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM PRODUTO WHERE ID = "+ id + " LIMIT 1");
		
		Produto produto = new Produto();
		
		while (result.next()) {
			produto.setId(result.getInt(1));
			produto.setCodigoDeBarras(result.getInt(2));
			produto.setCategoria(result.getString(3));
			produto.setDescricao(result.getString(4));
			produto.setUnidade(result.getString(5));
			produto.setValor(result.getBigDecimal(6));
			produto.setMargemDeLucro(result.getBigDecimal(7));
		}
		fecharConexao();
		// retorna a lista completa
		return produto;
	}
}

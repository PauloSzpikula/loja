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

import loja.Pedido;

//Autor: Paulo Szpikula, 21/11/2015 08:05
//Descrição: Implementação da Interface para manipular o modelo do Pedido

public class PedidoDaoImpl implements PedidoDao {

	private Connection con;
//	CREATE TABLE PEDIDO(ID INT PRIMARY KEY, ID_CLIENTE INT, NOME VARCHAR(30), TELEFONE VARCHAR(12), ENDERECO VARCHAR(50), CIDADE VARCHAR(50), ESTADO VARCHAR(50), EMAIL VARCHAR(50), GENERO CHAR, TOTAL DECIMAL, VALOR_PAGO DECIMAL, TROCO DECIMAL, STATUS BOOLEAN);
	
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
	public void create(Pedido p) throws SQLException {
		abrirConexao();
		//preparando o comando SQL
		PreparedStatement ps = con.prepareStatement("INSERT INTO PEDIDO (ID, ID_CLIENTE, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO, TOTAL, VALOR_PAGO, TROCO, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, p.getId());
		ps.setInt(2, p.getId_cliente());		
		ps.setString(3, p.getNome());
		ps.setString(4, p.getTelefone());
		ps.setString(5, p.getEndereco());
		ps.setString(6, p.getCidade());
		ps.setString(7, p.getEstado());
		ps.setString(8, p.getEmail());
		ps.setString(9, p.getGenero());
		ps.setBigDecimal(10, p.getTotal());
		ps.setBigDecimal(11, p.getValor_pago());
		ps.setBigDecimal(12, p.getTroco());
		ps.setBoolean(13, p.getStatus());
		//executando o comando SQL
		ps.executeUpdate();
		//fechando a conexão
		ps.close();
		fecharConexao();
	}
	
	@Override
	public ArrayList<Pedido> read() throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		
		abrirConexao();
		//preparando o comando SQL
		Statement st = con.createStatement();
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery("SELECT * FROM PEDIDO");
		// percorremos os registros um a um adicionando na lista
		while (result.next()) {
			int id = result.getInt(1);
			int id_cliente = result.getInt(2);
			String nome = result.getString(3);
			String telefone = result.getString(4);
			String endereco = result.getString(5);
			String cidade = result.getString(6);
			String estado = result.getString(7);
			String email = result.getString(8);
			String genero = result.getString(9);
			BigDecimal total = result.getBigDecimal(10);
			BigDecimal valor_pago = result.getBigDecimal(11);
			BigDecimal troco = result.getBigDecimal(12);
			boolean status = result.getBoolean(13);
			Pedido p = new Pedido(id, id_cliente, nome, telefone, endereco, cidade, estado, email, genero, total, valor_pago, troco, status);
			lista.add(p);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	@Override
	public void update(Pedido p) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("UPDATE PEDIDO SET ID = ?, ID_PEDIDO = ?, NOME = ?, TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?, EMAIL = ?, GENERO = ?, TOTAL = ?, VALOR_PAGO = ?, TROCO = ?, STATUS = ? WHERE ID = ?");
		sql.setInt(1, p.getId());
		sql.setInt(2, p.getId_cliente());
		sql.setString(3, p.getNome());
		sql.setString(4, p.getTelefone());
		sql.setString(5, p.getEndereco());
		sql.setString(6, p.getCidade());
		sql.setString(7, p.getEstado());
		sql.setString(8, p.getEmail());
		sql.setString(9, p.getGenero());
		sql.setBigDecimal(10, p.getTotal());
		sql.setBigDecimal(11, p.getValor_pago());
		sql.setBigDecimal(12, p.getTroco());
		sql.setBoolean(13, p.getStatus());
		sql.setInt(14, p.getId());
		//executando o comando SQL
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
	@Override
	public void delete(int id) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("DELETE FROM PEDIDO WHERE ID = ?");
		sql.setInt(1, id);
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}	
}
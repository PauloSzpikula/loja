package Dao;

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
	private int id_pedido = 0;
//	CREATE TABLE PEDIDO(ID INT PRIMARY KEY, NOME VARCHAR(30), TELEFONE VARCHAR(12), ENDERECO VARCHAR(50), CIDADE VARCHAR(50), ESTADO VARCHAR(50), EMAIL VARCHAR(50), GENERO CHAR, ID_PEDIDO INT);
	
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
		PreparedStatement ps = con.prepareStatement("INSERT INTO PEDIDO (ID, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO, ID_PEDIDO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, p.getId());
		ps.setString(2, p.getNome());
		ps.setString(3, p.getTelefone());
		ps.setString(4, p.getEndereco());
		ps.setString(5, p.getCidade());
		ps.setString(6, p.getEstado());
		ps.setString(7, p.getEmail());
		ps.setString(8, p.getGenero());
		ps.setInt(9, id_pedido++);
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
			String nome = result.getString(2);
			String telefone = result.getString(3);
			String endereco = result.getString(4);
			String cidade = result.getString(5);
			String estado = result.getString(6);
			String email = result.getString(7);
			String genero = result.getString(8);
			int id_pedido = result.getInt(9);
			Pedido p = new Pedido(id, nome, telefone, endereco, cidade, estado, email, genero, id_pedido);
			lista.add(p);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	@Override
	public void update(Pedido p) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("UPDATE PEDIDO SET ID = ?, NOME = ?, TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?, EMAIL = ?, GENERO = ?, ID_PEDIDO = ? WHERE ID = ?");
		sql.setInt(1, p.getId());
		sql.setString(2, p.getNome());
		sql.setString(3, p.getTelefone());
		sql.setString(4, p.getEndereco());
		sql.setString(5, p.getCidade());
		sql.setString(6, p.getEstado());
		sql.setString(7, p.getEmail());
		sql.setString(8, p.getGenero());
		sql.setInt(9, p.getId_pedido());
		sql.setInt(10, p.getId());
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
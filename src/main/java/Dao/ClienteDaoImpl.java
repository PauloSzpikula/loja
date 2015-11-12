package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import loja.Cliente;

//Autor: Paulo Szpikula, 31/10/2015 21:40
//Descrição: Implementação da Interface para manipular o modelo do cliente 

public class ClienteDaoImpl implements ClienteDao {

	private Connection con;

//	CREATE TABLE CLIENTE(ID INT PRIMARY KEY, NOME VARCHAR(30), TELEFONE VARCHAR(12), ENDERECO VARCHAR(50), CIDADE VARCHAR(50), ESTADO VARCHAR(50), EMAIL VARCHAR(50), GENERO CHAR);
	
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
	public void create(Cliente c) throws SQLException {
		abrirConexao();
		//preparando o comando SQL
		PreparedStatement ps = con.prepareStatement("INSERT INTO CLIENTE (ID, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getTelefone());
		ps.setString(4, c.getEndereco());
		ps.setString(5, c.getCidade());
		ps.setString(6, c.getEstado());
		ps.setString(7, c.getEmail());
		ps.setString(8, c.getGenero());		
		//executando o comando SQL
		ps.executeUpdate();
		//fechando a conexão
		ps.close();
		fecharConexao();
	}
	
	@Override
	public ArrayList<Cliente> read() throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		abrirConexao();
		//preparando o comando SQL
		Statement st = con.createStatement();
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery("SELECT * FROM CLIENTE");
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
			Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
			lista.add(c);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}
	
	@Override
	public void update(Cliente c) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("UPDATE CLIENTE SET ID = ?, NOME = ?, TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?, EMAIL = ?, GENERO = ? WHERE ID = ?");
		sql.setInt(1, c.getId());
		sql.setString(2, c.getNome());
		sql.setString(3, c.getTelefone());
		sql.setString(4, c.getEndereco());
		sql.setString(5, c.getCidade());
		sql.setString(6, c.getEstado());
		sql.setString(7, c.getEmail());
		sql.setString(8, c.getGenero());
		sql.setInt(9, c.getId());
		//executando o comando SQL
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
	@Override
	public void delete(int id) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
		sql.setInt(1, id);
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
}
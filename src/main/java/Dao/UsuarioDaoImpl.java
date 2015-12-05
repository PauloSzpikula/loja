package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import loja.Cliente;
import loja.Usuario;

//Autor: Paulo Szpikula, 31/10/2015 21:40
//Descri��o: Implementa��o da Interface para manipular o modelo do usuario 

public class UsuarioDaoImpl implements UsuarioDao {

	private Connection con;

//	CREATE TABLE USUARIO(ID INT AUTO_INCREMENT PRIMARY KEY, ID_CLIENTE INT, NOME VARCHAR(30), SENHA VARCHAR(30));
	
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
	public void create(Usuario u) throws SQLException {
		abrirConexao();
		//preparando o comando SQL
		PreparedStatement ps = con.prepareStatement("INSERT INTO USUARIO (ID_CLIENTE, NOME, SENHA) VALUES (?, ?, ?)");
		//Atribuindo valor para as vari�veis ?
		ps.setInt(1, u.getIdDoCliente());
		ps.setString(2, u.getNome());
		ps.setString(3, u.getSenha());
		//executando o comando SQL
		ps.executeUpdate();
		//fechando a conex�o
		ps.close();
		fecharConexao();
	}
	
	@Override
	public ArrayList<Usuario> read() throws SQLException {
		// uma vari�vel lista, que vai armazenar todos os registros do banco
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		abrirConexao();
		//preparando o comando SQL
		Statement st = con.createStatement();
		// a vari�vel result recebe todos os registros do banco
		ResultSet result = st.executeQuery("SELECT * FROM USUARIO");
		// percorremos os registros um a um adicionando na lista
		while (result.next()) {
			int id_usuario = result.getInt(1);
			int id_cliente = result.getInt(2);
			String nome = result.getString(3);
			String senha = result.getString(4);
			Usuario u = new Usuario(id_usuario, id_cliente, nome, senha);
			lista.add(u);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}	
	
	@Override
	public void update(Usuario u) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("UPDATE USUARIO SET ID = ?, ID_CLIENTE = ?, NOME = ?, SENHA = ? WHERE ID = ?");
		sql.setInt(1, u.getId());
		sql.setInt(2, u.getIdDoCliente());
		sql.setString(3, u.getNome());
		sql.setString(4, u.getSenha());
		sql.setInt(5, u.getId());
		//executando o comando SQL
		sql.executeUpdate();
		sql.close();
		fecharConexao();
	}
	
	@Override
	public void delete(int id) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("DELETE FROM USUARIO WHERE ID = ?");
		sql.setInt(1, id);
		sql.executeUpdate();
		sql.close();
		//read();
		fecharConexao();
	}
	
	public boolean procurar_login(String nome, String senha) throws SQLException {
		
		String nome_usuario = "";
		boolean resultado = false;
		
		abrirConexao();

		Statement st = con.createStatement();

		ResultSet result = st.executeQuery("SELECT NOME FROM USUARIO WHERE NOME = '"+ nome +"' AND SENHA = '"+ senha +"' LIMIT 1;");
		
		// comparar resultado transformando num boolean
		while (result.next()) {
			nome_usuario = result.getString(1);
		}
		
		if (nome.equals(nome_usuario)) {
			resultado = true;
		}
		
		fecharConexao();

		return resultado;
	}


}

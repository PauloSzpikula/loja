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
//Descrição: Implementação da Interface para manipular o modelo do usuario 

public class UsuarioDaoImpl implements UsuarioDao {

	private Connection con;

//	CREATE TABLE USUARIO(ID INT PRIMARY KEY, ID_CLIENTE INT, SENHA VARCHAR(30));
	
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
		PreparedStatement ps = con.prepareStatement("INSERT INTO USUARIO (ID, ID_CLIENTE, SENHA) VALUES (?, ?, ?)");
		//Atribuindo valor para as variáveis ?
		ps.setInt(1, u.getId());
		ps.setInt(2, u.getIdDoCliente());
		ps.setString(3, u.getSenha());
		//executando o comando SQL
		ps.executeUpdate();
		//fechando a conexão
		ps.close();
		fecharConexao();
	}
	
	@Override
	public ArrayList<Usuario> read() throws SQLException {
		// uma variável lista, que vai armazenar todos os registros do banco
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		abrirConexao();
		//preparando o comando SQL
		Statement st = con.createStatement();
		// a variável result recebe todos os registros do banco
		ResultSet result = st.executeQuery("SELECT * FROM USUARIO");
		// percorremos os registros um a um adicionando na lista
		while (result.next()) {
			int id_usuario = result.getInt(1);
			int id_cliente = result.getInt(2);
			String senha = result.getString(3);
			Usuario u = new Usuario(id_usuario, id_cliente, senha);
			lista.add(u);
		}
		fecharConexao();
		// retorna a lista completa
		return lista;
	}	
	
	@Override
	public void update(Usuario u) throws SQLException {
		abrirConexao();
		PreparedStatement sql = con.prepareStatement("UPDATE USUARIO SET ID = ?, ID_CLIENTE = ?, SENHA = ? WHERE ID = ?");
		sql.setInt(1, u.getId());
		sql.setInt(2, u.getIdDoCliente());
		sql.setString(3, u.getSenha());
		sql.setInt(4, u.getId());
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
	
	public boolean procurar_login(int id, String senha) throws SQLException {
		
		int id_usuario = -1;
		boolean resultado = false;
		
		abrirConexao();

		Statement st = con.createStatement();

		ResultSet result = st.executeQuery("SELECT ID FROM USUARIO WHERE ID = "+id+" AND SENHA = '"+senha+"' LIMIT 1;");
		// comparar resultado transformando num boolean
		while (result.next()) {
			id_usuario = result.getInt(1);
		}
		
		if (id == id_usuario) {
			resultado = true;
		}
		
		fecharConexao();

		return resultado;
	}


}

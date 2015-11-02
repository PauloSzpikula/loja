package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}

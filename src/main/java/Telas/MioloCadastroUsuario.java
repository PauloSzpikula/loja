package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Tela do cadastrar usuário

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import Dao.ClienteDaoImpl;
import Dao.UsuarioDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import loja.Cliente;
import loja.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MioloCadastroUsuario extends JPanel {
	private JTextField txt_id_usuario;
	private JTextField txt_senha;

	private ModeloUsuario modelo;
	
	// implementação do usuário no banco
	UsuarioDaoImpl usdao = new UsuarioDaoImpl();
	
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	private JTable table;
	/**
	 * Create the panel.
	 */
	public MioloCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("ID CLIENTE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox cb_id_cliente = new JComboBox();
		cb_id_cliente.removeAllItems();
		try {
			ArrayList<Integer> lista = populaComboBox();
			Iterator i = lista.iterator(); 
			while(i.hasNext()) {  
				  cb_id_cliente.addItem(String.valueOf(i.next()));  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_cb_id_cliente = new GridBagConstraints();
		gbc_cb_id_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cb_id_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_id_cliente.gridx = 2;
		gbc_cb_id_cliente.gridy = 0;
		add(cb_id_cliente, gbc_cb_id_cliente);
		
		JLabel lblNewLabel_1 = new JLabel("ID USU\u00C1RIO");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_id_usuario = new JTextField();
		GridBagConstraints gbc_txt_id_usuario = new GridBagConstraints();
		gbc_txt_id_usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_id_usuario.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id_usuario.gridx = 2;
		gbc_txt_id_usuario.gridy = 1;
		add(txt_id_usuario, gbc_txt_id_usuario);
		txt_id_usuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SENHA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txt_senha = new JTextField();
		GridBagConstraints gbc_txt_senha = new GridBagConstraints();
		gbc_txt_senha.insets = new Insets(0, 0, 5, 0);
		gbc_txt_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_senha.gridx = 2;
		gbc_txt_senha.gridy = 2;
		add(txt_senha, gbc_txt_senha);
		txt_senha.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String id_u = txt_id_usuario.getText().trim();
					String senha_u = txt_senha.getText().trim();
					
					// testa se tudo está de acordo para a inserção
					if (!id_u.isEmpty() & !senha_u.isEmpty()) {
						
						int id = Integer.parseInt(txt_id_usuario.getText().trim());
						int id_cliente = Integer.parseInt(cb_id_cliente.getSelectedItem().toString());
						String senha = txt_senha.getText().trim();

						// instancia um noco cadastro
						Usuario u = new Usuario(id, id_cliente, senha);
						ac_criar(u);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		panel.add(btnNewButton_1);

		// instancia o ModeloCadastro
		modelo = new ModeloUsuario();
		// seta o modelo da tabela 
		table.setModel(modelo);

		try {
			ac_ler();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	protected void ac_criar(Usuario u) throws SQLException{
		// cria uma lista
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
			
		// busca pelo usdao.read() todos os registros do banco
		lista = usdao.read();
			
		// uma variável booleana para testar se tem ids duplicados
		boolean testaIdDuplicado = false;
			
		int id = 0;
		// valida se o numero é numero e se é duplicado
		try {
			// varre a lista de cadastros do banco
			for (Usuario uu : lista) {
				// verifica se o id da lista é igual ao informado no textFild
				if (uu.getId() == u.getId()) {
					// seta verdadeiro para ids duplicados
					testaIdDuplicado = true;
				}
			}
			// aqui é lançado um erro caso o id seja dulicado
			if (testaIdDuplicado) {
				JOptionPane.showMessageDialog(this, "Id Duplicado, tente outro meu amiguinho!");
				return;
			} else {
				// éééé passou não tem duplicidade
				id = Integer.parseInt(txt_id_usuario.getText().trim());
			}

		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "Id Inválido!");
			return;
		}
		// passa pro modelo os valores do novo cadastro para ser adicionado numa lista
		modelo.incluir(u);
		
		// cria no banco um novo cadastro
		usdao.create(u);

		// limpa os campos de texto da tela
		limparCampos();
		
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");

		
		
	}

	private ArrayList<Integer> populaComboBox() throws SQLException {
        ArrayList<Integer> array = new ArrayList<Integer>();  
		array = cdao.listaIdClientes();
		return array;
	}
	
	
	protected void ac_ler() throws SQLException {
		// limpa a tabela para não duplicar tudo
		modelo.clear();
		// cria uma lista que vai conter a outra lista -- isso é muito loko
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		// lista recebe o retorno do read()
		lista = usdao.read();

		// varre a lista inserindo em outra lista
		for (Usuario u : lista) { 
			// inclui a bagaça
			modelo.incluir(u);
		}
	}
	
	
	private void limparCampos() {
		txt_id_usuario.setText("");
		txt_senha.setText("");
	}
}

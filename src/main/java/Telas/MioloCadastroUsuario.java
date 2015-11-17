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
import java.math.BigDecimal;
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
import loja.Produto;
import loja.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MioloCadastroUsuario extends JPanel {
	private JTextField txt_senha;
	private JTextField txt_id_usuario;
	private ModeloUsuario modelo;
	private JTable table;

	// implementação do usuário no banco
	UsuarioDaoImpl usdao = new UsuarioDaoImpl();
	
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
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
		
		
		JLabel label = new JLabel("ID USU\u00C1RIO");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		txt_id_usuario = new JTextField();
		txt_id_usuario.setColumns(10);
		GridBagConstraints gbc_txt_id_usuario = new GridBagConstraints();
		gbc_txt_id_usuario.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id_usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_id_usuario.gridx = 2;
		gbc_txt_id_usuario.gridy = 0;
		add(txt_id_usuario, gbc_txt_id_usuario);
		
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
		JLabel lblNewLabel = new JLabel("ID CLIENTE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_cb_id_cliente = new GridBagConstraints();
		gbc_cb_id_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cb_id_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_id_cliente.gridx = 2;
		gbc_cb_id_cliente.gridy = 1;
		add(cb_id_cliente, gbc_cb_id_cliente);
		
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				int linhaSelecionada = table.getSelectedRow();
				txt_id_usuario.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,0)).trim());
				cb_id_cliente.setEditable(true);
				cb_id_cliente.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,1)).trim());
				cb_id_cliente.setEditable(false);
				txt_senha.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,2)).trim());						
			}
		});
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
		
		JButton btn_create = new JButton("Create");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String id_u = txt_id_usuario.getText().trim();
					String senha_u = txt_senha.getText().trim();
					
					// cria uma lista
					ArrayList<Usuario> lista = new ArrayList<Usuario>();
					// busca pelo usdao.read() todos os registros do banco
					lista = usdao.read();
					
					// valida se o numero é numero e se é duplicado
					int id = 0;
					if (id_u.matches("[0-9]")) {
						id = Integer.parseInt(id_u);
					} else {
						mensagemDeErro();
						return;
					}
					
					// uma variável booleana para testar se tem ids duplicados
					boolean testaIdDuplicado = false;
					
					int id_c = Integer.parseInt(cb_id_cliente.getSelectedItem().toString());
					
					// varre a lista de cadastros do banco
					for (Usuario uu : lista) {
						// verifica se o id da lista é igual ao informado no textFild
						if (uu.getId() == id || uu.getIdDoCliente() == id_c ) {
							// seta verdadeiro para ids duplicados
							testaIdDuplicado = true;
						}
					}
					// aqui é lançado um erro caso o id seja dulicado
					if (testaIdDuplicado) {
						mensagemIdDuplicado();
						return;
					}
					
					// testa se tudo está de acordo para a inserção
					if (!id_u.isEmpty() & !senha_u.isEmpty()) {
						
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
		panel.add(btn_create);
		
		JButton btn_read = new JButton("Read");
		btn_read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de ler os registros
				try {				
					ac_ler();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btn_read);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de atualizar
				try {				

					String id_u = txt_id_usuario.getText().trim();
					
					// cria uma lista
					ArrayList<Usuario> lista = new ArrayList<Usuario>();
					// busca pelo usdao.read() todos os registros do banco
					lista = usdao.read();
					
					// valida se o numero é numero
					int id = -1;
					if (id_u.matches("[0-9]")) {
						id = Integer.parseInt(id_u);
					} else {
						mensagemDeErro();
						return;
					}
					
					// uma variável booleana para testar se tem ids duplicados
					boolean testaIdDuplicado = false;
					
					int id_c = Integer.parseInt(cb_id_cliente.getSelectedItem().toString());
					
					// varre a lista de cadastros do banco
					for (Usuario uu : lista) {
						// verifica se o id da lista é igual ao informado no textFild
						if (uu.getIdDoCliente() == id_c ) {
							// seta verdadeiro para ids duplicados
							testaIdDuplicado = true;
						}
					}
					// aqui é lançado um erro caso o id seja dulicado
					if (testaIdDuplicado) {
						mensagemIdDuplicado();
						return;
					}
					
					if (!id_u.isEmpty()) {

						int id_cliente = Integer.parseInt(cb_id_cliente.getSelectedItem().toString());
						String senha = txt_senha.getText().trim();

						// instancia um noco cadastro
						Usuario u = new Usuario(id, id_cliente, senha);
						ac_atualizar(u);
						
					} else {
						mensagemDeErro();	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de deletar
				try {
					String id_u = txt_id_usuario.getText();
					if (!id_u.isEmpty()) {
						ac_deletar();
					} else {
						mensagemDeErro();	
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btn_delete);

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
	
	protected void ac_deletar() throws SQLException {
		
		// resposta do usuário, é emitida por um JOptionPane
		int resposta = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Deletar",JOptionPane.YES_OPTION);
		
		if (resposta == 0) {
			int id = Integer.parseInt(txt_id_usuario.getText().trim());
			
			// deleta o usuário craiando uma nova instância de Cadastro passando só o id
			usdao.delete(id);
			
			// atualiza tudo
			ac_ler();
		}
	}

	protected void ac_atualizar(Usuario u) throws SQLException {
		/// atualiza no banco
		usdao.update(u);
		
		// atualizar a tabela
		ac_ler();
	}

	protected void mensagemIdDuplicado() {
		JOptionPane.showMessageDialog(this, "Id Duplicado, tente outro meu amiguinho!");
	}
	
	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
		
	}
	
	protected void ac_criar(Usuario u) throws SQLException{
		// passa pro modelo os valores do novo cadastro para ser adicionado numa lista
		modelo.incluir(u);
		// cria no banco um novo cadastro
		usdao.create(u);

		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		ac_ler();
	}

	private ArrayList<Integer> populaComboBox() throws SQLException {
        return cdao.listaIdClientes();
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
		// limpa os campos de texto da tela
		limparCampos();
	}
	
	private void limparCampos() {
		txt_id_usuario.setText("");
		txt_senha.setText("");
	}
}

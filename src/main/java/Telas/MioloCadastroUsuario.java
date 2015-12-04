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
import modelos.ModeloUsuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MioloCadastroUsuario extends JPanel {
	private JTextField txt_senha;
	private ModeloUsuario modelo = new ModeloUsuario();
	private JTable table;
	private int id_selecionado;

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
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JComboBox cb_id_cliente = new JComboBox();
		cb_id_cliente.removeAllItems();
		try {
			ArrayList<String> lista = populaComboBox();
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
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_cb_id_cliente = new GridBagConstraints();
		gbc_cb_id_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cb_id_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_id_cliente.gridx = 2;
		gbc_cb_id_cliente.gridy = 0;
		add(cb_id_cliente, gbc_cb_id_cliente);
		
		JLabel lblNewLabel_2 = new JLabel("SENHA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txt_senha = new JTextField();
		GridBagConstraints gbc_txt_senha = new GridBagConstraints();
		gbc_txt_senha.insets = new Insets(0, 0, 5, 0);
		gbc_txt_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_senha.gridx = 2;
		gbc_txt_senha.gridy = 1;
		add(txt_senha, gbc_txt_senha);
		txt_senha.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				int linhaSelecionada = table.getSelectedRow();
				id_selecionado = Integer.parseInt(String.valueOf(modelo.getValueAt(linhaSelecionada,0)).trim());
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
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn_create = new JButton("Create");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String senha_u = txt_senha.getText().trim();
					
					String id_nome = cb_id_cliente.getSelectedItem().toString().trim().replaceAll("\\s+", "");
					String id_cli = id_nome.substring(0,id_nome.indexOf("-"));			
					
					// testa se tudo está de acordo para a inserção
					if (!senha_u.isEmpty()) {
						
						// instancia um noco cadastro
						Usuario usuario = new Usuario(0, Integer.parseInt(id_cli), senha_u);
						ac_criar(usuario);
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

					String senha_u = txt_senha.getText().trim();

					if (!senha_u.isEmpty()) {

						String id_nome = cb_id_cliente.getSelectedItem().toString().trim().replaceAll("\\s+", "");
						String id_cli = id_nome.substring(0,id_nome.indexOf("-"));

						// instancia um noco cadastro
						Usuario u = new Usuario(id_selecionado, Integer.parseInt(id_cli), senha_u);
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
					ac_deletar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btn_delete);
		
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
			// deleta o usuário craiando uma nova instância de Cadastro passando só o id
			usdao.delete(id_selecionado);
			
			// atualiza tudo
			ac_ler();
		}
	}

	protected void ac_atualizar(Usuario usuario) throws SQLException {
		/// atualiza no banco
		usdao.update(usuario);
		
		// atualizar a tabela
		ac_ler();
	}
	
	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}
	
	protected void ac_criar(Usuario usuario) throws SQLException{
		// cria no banco um novo cadastro
		usdao.create(usuario);
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		ac_ler();
	}

	private ArrayList<String> populaComboBox() throws SQLException {
        return cdao.listaIdClientes();
	}
	
	protected void ac_ler() throws SQLException {
		// limpa os campos de texto da tela
		limparCampos();
		// atualiza a tabela
		atualizarLista();
	}
	
	protected void atualizarLista() throws SQLException {
		modelo.setarLista(usdao.read());
	}
	
	private void limparCampos() {
		txt_senha.setText("");
	}
}

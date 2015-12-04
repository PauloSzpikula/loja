package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Tela do cadastrar Cliente

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import loja.Cliente;
import loja.Estado;
import loja.Genero;
import modelos.ModeloCliente;

import javax.swing.JButton;

import Dao.ClienteDaoImpl;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.renderer.StringValues;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MioloCadastroCliente extends JPanel {
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private JTextField txt_endereco;
	private JTextField txt_cidade;
	private JTextField txt_email;
	private ModeloCliente modelo = new ModeloCliente();
	private int id_selecionado;
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	/**
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNome = new JLabel("NOME");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridwidth = 2;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		add(lblNome, gbc_lblNome);
		
		txt_nome = new JTextField();
		GridBagConstraints gbc_txt_nome = new GridBagConstraints();
		gbc_txt_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_nome.insets = new Insets(0, 0, 5, 0);
		gbc_txt_nome.gridx = 2;
		gbc_txt_nome.gridy = 0;
		add(txt_nome, gbc_txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TELEFONE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txt_telefone = new JTextField();
		GridBagConstraints gbc_txt_telefone = new GridBagConstraints();
		gbc_txt_telefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_telefone.insets = new Insets(0, 0, 5, 0);
		gbc_txt_telefone.gridx = 2;
		gbc_txt_telefone.gridy = 1;
		add(txt_telefone, gbc_txt_telefone);
		txt_telefone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txt_endereco = new JTextField();
		GridBagConstraints gbc_txt_endereco = new GridBagConstraints();
		gbc_txt_endereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_endereco.insets = new Insets(0, 0, 5, 0);
		gbc_txt_endereco.gridx = 2;
		gbc_txt_endereco.gridy = 2;
		add(txt_endereco, gbc_txt_endereco);
		txt_endereco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIDADE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_cidade = new JTextField();
		GridBagConstraints gbc_txt_cidade = new GridBagConstraints();
		gbc_txt_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cidade.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cidade.gridx = 2;
		gbc_txt_cidade.gridy = 3;
		add(txt_cidade, gbc_txt_cidade);
		txt_cidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("ESTADO");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridwidth = 2;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 4;
		add(lblEstado, gbc_lblEstado);
		
		JComboBox cb_estado = new JComboBox(Estado.values());
		GridBagConstraints gbc_cb_estado = new GridBagConstraints();
		gbc_cb_estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_estado.insets = new Insets(0, 0, 5, 0);
		gbc_cb_estado.gridx = 2;
		gbc_cb_estado.gridy = 4;
		add(cb_estado, gbc_cb_estado);
		
		JLabel lblEmail = new JLabel("EMAIL");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);
		
		txt_email = new JTextField();
		GridBagConstraints gbc_txt_email = new GridBagConstraints();
		gbc_txt_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_email.insets = new Insets(0, 0, 5, 0);
		gbc_txt_email.gridx = 2;
		gbc_txt_email.gridy = 5;
		add(txt_email, gbc_txt_email);
		txt_email.setColumns(10);
		
		JLabel lblGenero = new JLabel("G\u00CANERO");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.gridwidth = 2;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 6;
		add(lblGenero, gbc_lblGenero);
		
		JComboBox cb_genero = new JComboBox(Genero.values());
		GridBagConstraints gbc_cb_genero = new GridBagConstraints();
		gbc_cb_genero.insets = new Insets(0, 0, 5, 0);
		gbc_cb_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_genero.gridx = 2;
		gbc_cb_genero.gridy = 6;
		add(cb_genero, gbc_cb_genero);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de incluir
				try {
					
					String email_c = txt_email.getText().trim();
					
					// testa se os campos estão preenchidos para a inserção
					if (!email_c.isEmpty()) {
						
						String nome = txt_nome.getText().trim();
						String telefone = txt_telefone.getText().trim();
						String endereco = txt_endereco.getText().trim();
						String cidade = txt_cidade.getText().trim();
						String estado = cb_estado.getSelectedItem().toString();
						String email = txt_email.getText().trim();
						String genero = cb_genero.getSelectedItem().toString();
						
						// instancia um noco cadastro
						Cliente c = new Cliente(0, nome, telefone, endereco, cidade, estado, email, genero);
						
						ac_criar(c);
					} else {
						mensagemDeErro();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ler");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de ler os registros
				try {					
					atualizarLista();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de atualizar
				try {
					
					String email_c = txt_email.getText().trim();

					if (!email_c.isEmpty()) {
					
						String nome = txt_nome.getText().trim();
						String telefone = txt_telefone.getText().trim();
						String endereco = txt_endereco.getText().trim();
						String cidade = txt_cidade.getText().trim();
						String estado = cb_estado.getSelectedItem().toString();
						String email = txt_email.getText().trim();
						String genero = cb_genero.getSelectedItem().toString();
	
						// instancia um noco cadastro
						Cliente c = new Cliente(id_selecionado, nome, telefone, endereco, cidade, estado, email, genero);
						
						ac_atualizar(c);
					} else {
						mensagemDeErro();
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de deletar
				try {					
					ac_deletar();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);

		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = table.getSelectedRow();
				id_selecionado = (int) modelo.getValueAt(linhaSelecionada,0);
				txt_nome.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,1)).trim());
				txt_telefone.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,2)).trim());
				txt_endereco.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,3)).trim());
				txt_cidade.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,4)).trim());
				cb_estado.setEditable(true);
				cb_estado.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,5)).trim());
				cb_estado.setEditable(false);
				txt_email.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,6)).trim());
				cb_genero.setEditable(true);
				cb_genero.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,7)).trim());
				cb_genero.setEditable(false);
			}
		});
		scrollPane.setViewportView(table);
		
		table.setModel(modelo);
	
		//atualizar a lista
		try {					
			atualizarLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}
	
	protected void ac_criar(Cliente cliente) throws SQLException {
		// cria no banco um novo cadastro
		cdao.create(cliente);
		
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		// atualiza a tabela
		atualizarLista();
	}
	
	protected void ac_atualizar(Cliente c) throws SQLException {
		// atualiza no banco
		cdao.update(c);
		// atualizar a tabela
		atualizarLista();
	}

	protected void ac_deletar() throws SQLException{
		// resposta do usuário, é emitida por um JOptionPane
		int resposta = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Deletar",JOptionPane.YES_OPTION);
		if (resposta == 0) {
			// deleta o usuário craiando uma nova instância de Cadastro passando só o id
			cdao.delete(id_selecionado);
			
			// atualiza tabela
			atualizarLista();
		}
	}
	
	protected void atualizarLista() throws SQLException {
		// limpa os campos de texto da tela
		limparCampos();
		modelo.setarLista(cdao.read());
	}
	
	private void limparCampos() {
		txt_nome.setText("");
		txt_telefone.setText("");
		txt_endereco.setText("");
		txt_cidade.setText("");
		txt_email.setText("");
	}
}






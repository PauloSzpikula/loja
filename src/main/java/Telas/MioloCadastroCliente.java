package Telas;

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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MioloCadastroCliente extends JPanel {
	private JTextField txt_id;
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private JTextField txt_endereco;
	private JTextField txt_cidade;
	private JTextField txt_email;
	
	private ModeloCliente modelo;

	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	/**
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txt_id = new JTextField();
		GridBagConstraints gbc_txt_id = new GridBagConstraints();
		gbc_txt_id.fill = GridBagConstraints.BOTH;
		gbc_txt_id.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id.gridx = 2;
		gbc_txt_id.gridy = 0;
		add(txt_id, gbc_txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		txt_nome = new JTextField();
		GridBagConstraints gbc_txt_nome = new GridBagConstraints();
		gbc_txt_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_nome.insets = new Insets(0, 0, 5, 0);
		gbc_txt_nome.gridx = 2;
		gbc_txt_nome.gridy = 1;
		add(txt_nome, gbc_txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TELEFONE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txt_telefone = new JTextField();
		GridBagConstraints gbc_txt_telefone = new GridBagConstraints();
		gbc_txt_telefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_telefone.insets = new Insets(0, 0, 5, 0);
		gbc_txt_telefone.gridx = 2;
		gbc_txt_telefone.gridy = 2;
		add(txt_telefone, gbc_txt_telefone);
		txt_telefone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txt_endereco = new JTextField();
		GridBagConstraints gbc_txt_endereco = new GridBagConstraints();
		gbc_txt_endereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_endereco.insets = new Insets(0, 0, 5, 0);
		gbc_txt_endereco.gridx = 2;
		gbc_txt_endereco.gridy = 3;
		add(txt_endereco, gbc_txt_endereco);
		txt_endereco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIDADE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_cidade = new JTextField();
		GridBagConstraints gbc_txt_cidade = new GridBagConstraints();
		gbc_txt_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cidade.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cidade.gridx = 2;
		gbc_txt_cidade.gridy = 4;
		add(txt_cidade, gbc_txt_cidade);
		txt_cidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("ESTADO");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 5;
		add(lblEstado, gbc_lblEstado);
		
		JComboBox cb_estado = new JComboBox(Estado.values());
		GridBagConstraints gbc_cb_estado = new GridBagConstraints();
		gbc_cb_estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_estado.insets = new Insets(0, 0, 5, 0);
		gbc_cb_estado.gridx = 2;
		gbc_cb_estado.gridy = 5;
		add(cb_estado, gbc_cb_estado);
		
		JLabel lblEmail = new JLabel("EMAIL");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		txt_email = new JTextField();
		GridBagConstraints gbc_txt_email = new GridBagConstraints();
		gbc_txt_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_email.insets = new Insets(0, 0, 5, 0);
		gbc_txt_email.gridx = 2;
		gbc_txt_email.gridy = 6;
		add(txt_email, gbc_txt_email);
		txt_email.setColumns(10);
		
		JLabel lblGenero = new JLabel("G\u00CANERO");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.gridx = 1;
		gbc_lblGenero.gridy = 7;
		add(lblGenero, gbc_lblGenero);
		
		JComboBox cb_genero = new JComboBox(Genero.values());
		GridBagConstraints gbc_cb_genero = new GridBagConstraints();
		gbc_cb_genero.insets = new Insets(0, 0, 5, 0);
		gbc_cb_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_genero.gridx = 2;
		gbc_cb_genero.gridy = 7;
		add(cb_genero, gbc_cb_genero);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 9;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de incluir
				try {
					
					int id = Integer.parseInt(txt_id.getText().trim());
					String nome = txt_nome.getText().trim();
					String telefone = txt_telefone.getText().trim();
					String endereco = txt_endereco.getText().trim();
					String cidade = txt_cidade.getText().trim();
					String estado = cb_estado.getSelectedItem().toString();
					String email = txt_email.getText().trim();
					String genero = cb_genero.getSelectedItem().toString();
					
					// instancia um noco cadastro
					Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
					
					ac_criar(c);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Read");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de ler os registros
				try {					
					ac_ler();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de atualizar
				try {
					
					int id = Integer.parseInt(txt_id.getText().trim());
					String nome = txt_nome.getText().trim();
					String telefone = txt_telefone.getText().trim();
					String endereco = txt_endereco.getText().trim();
					String cidade = txt_cidade.getText().trim();
					String estado = cb_estado.getSelectedItem().toString();
					String email = txt_email.getText().trim();
					String genero = cb_genero.getSelectedItem().toString();

					// instancia um noco cadastro
					Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
					
					ac_atualizar(c);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
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
				txt_id.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,0)).trim());
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
		
		// instancia o ModeloCadastro
		modelo = new ModeloCliente();
		// seta o modelo da tabela 
		table.setModel(modelo);
		
	}
	
	protected void ac_criar(Cliente c) throws SQLException {
	
		// cria uma lista
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
			
		// busca pelo cdao.read() todos os registros do banco
		lista = cdao.read();
			
		// uma variável booleana para testar se tem ids duplicados
		boolean testaIdDuplicado = false;
			
		int id = 0;
		// valida se o numero é numero e se é duplicado
		try {
			// varre a lista de cadastros do banco
			for (Cliente cc : lista) {
				// verifica se o id da lista é igual ao informado no textFild
				if (cc.getId() == c.getId()) {
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
				id = Integer.parseInt(txt_id.getText().trim());
			}

		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "Id Inválido!");
			return;
		}
		// passa pro modelo os valores do novo cadastro para ser adicionado numa lista
		modelo.incluir(c);
		
		// cria no banco um novo cadastro
		cdao.create(c);

		// limpa os campos de texto da tela
		limparCampos();
		
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");

		ac_ler();
	}

	protected void ac_ler() throws SQLException {
		// limpa a tabela para não duplicar tudo
		modelo.clear();
		// cria uma lista que vai conter a outra lista -- isso é muito loko
		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		// lista recebe o retorno do read()
		lista = cdao.read();

		// varre a lista inserindo em outra lista
		for (Cliente c : lista) { 
			// inclui a bagaça
			modelo.incluir(c);
		}
	}
	
	protected void ac_atualizar(Cliente c) throws SQLException{		
				
		int id = 0;
		// valida se o numero é numero
		try{
			id = c.getId();			
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "Id Inválido!");
			return;
		}

		// atualiza no banco
		cdao.update(c);
		
		// atualizar a tabela
		ac_ler();
		
		// limpa os campos de texto da tela
		limparCampos();
	}

	protected void ac_deletar() throws SQLException{
		// cria um vetor de variáveis opcoes do tipo objeto
		Object[] opcoes = { "sim", "não" };
		// uma variavel resposta do tipo objeto
		Object resposta;
		// enquanto a resposta do usuário for nulla
		do {
			// resposta a resposta do usuário, que é emitida por um JOptionPane
			resposta = JOptionPane.showInputDialog(null,"Tem certeza que deseja fazer isso?","Deserialização",JOptionPane.PLAIN_MESSAGE,null,opcoes,"não");
			if (resposta == "não") {
				return;
			}
		} while (resposta == null);
		
		int id = 0;
		// valida se o numero é numero
		try{
			id = Integer.parseInt(txt_id.getText().trim());			
		} catch (Exception e){
			JOptionPane.showMessageDialog(this, "Id Inválido!");
			return;
		}
		
		// deleta o usuário craiando uma nova instância de Cadastro passando só o id
		cdao.delete(new Cliente(id, null, null, null, null, null, null, null));
		
		// atualiza tudo
		ac_ler();
		
		// limpa os campos de texto da tela
		limparCampos();
	}

	private void limparCampos() {
		txt_id.setText("");
		txt_nome.setText("");
		txt_telefone.setText("");
		txt_endereco.setText("");
		txt_cidade.setText("");
		txt_email.setText("");
	}
}

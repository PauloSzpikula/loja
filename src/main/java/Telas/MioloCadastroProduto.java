package Telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;

import javax.swing.JButton;

import Dao.ClienteDaoImpl;
import Dao.ProdutoDaoImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import loja.Categoria;
import loja.Cliente;
import loja.Produto;
import loja.Unidade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class MioloCadastroProduto extends JPanel {
	private JTextField txt_id;
	private JTextField txt_cod_barras;
	private JTextField txt_descricao;
	private JTextField txt_custo;
	private JTable table;

	private ModeloProduto modelo;
	private JTextField txt_margem_lucro;

	private String txt_categoria;
	private String txt_unidade;
	
	// implementação do produto no banco
	ProdutoDaoImpl cdao = new ProdutoDaoImpl();
	
	/**
	 * Create the panel.
	 */
	public MioloCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txt_id = new JTextField();
		GridBagConstraints gbc_txt_id = new GridBagConstraints();
		gbc_txt_id.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_id.gridx = 2;
		gbc_txt_id.gridy = 0;
		add(txt_id, gbc_txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00D3D. BARRAS");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_cod_barras = new JTextField();
		GridBagConstraints gbc_txt_cod_barras = new GridBagConstraints();
		gbc_txt_cod_barras.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cod_barras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cod_barras.gridx = 2;
		gbc_txt_cod_barras.gridy = 1;
		add(txt_cod_barras, gbc_txt_cod_barras);
		txt_cod_barras.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CATEGORIA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox cb_categoria = new JComboBox(Categoria.values());
		GridBagConstraints gbc_cb_categoria = new GridBagConstraints();
		gbc_cb_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_cb_categoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_categoria.gridx = 2;
		gbc_cb_categoria.gridy = 2;
		add(cb_categoria, gbc_cb_categoria);
		
		JLabel lblNewLabel_3 = new JLabel("DESCRI\u00C7\u00C3O");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txt_descricao = new JTextField();
		GridBagConstraints gbc_txt_descricao = new GridBagConstraints();
		gbc_txt_descricao.insets = new Insets(0, 0, 5, 0);
		gbc_txt_descricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_descricao.gridx = 2;
		gbc_txt_descricao.gridy = 3;
		add(txt_descricao, gbc_txt_descricao);
		txt_descricao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UNIDADE");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox cb_unidade = new JComboBox(Unidade.values());
		GridBagConstraints gbc_cb_unidade = new GridBagConstraints();
		gbc_cb_unidade.insets = new Insets(0, 0, 5, 0);
		gbc_cb_unidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_unidade.gridx = 2;
		gbc_cb_unidade.gridy = 4;
		add(cb_unidade, gbc_cb_unidade);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTO");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridwidth = 2;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txt_custo = new JTextField();
		GridBagConstraints gbc_txt_custo = new GridBagConstraints();
		gbc_txt_custo.insets = new Insets(0, 0, 5, 0);
		gbc_txt_custo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_custo.gridx = 2;
		gbc_txt_custo.gridy = 5;
		add(txt_custo, gbc_txt_custo);
		txt_custo.setColumns(10);
		
		
		// instancia o ModeloCadastro
		modelo = new ModeloProduto();
		
		JLabel lblNewLabel_6 = new JLabel("MARGEM DE LUCRO");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridwidth = 2;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txt_margem_lucro = new JTextField();
		GridBagConstraints gbc_txt_margem_lucro = new GridBagConstraints();
		gbc_txt_margem_lucro.insets = new Insets(0, 0, 5, 0);
		gbc_txt_margem_lucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_margem_lucro.gridx = 2;
		gbc_txt_margem_lucro.gridy = 6;
		add(txt_margem_lucro, gbc_txt_margem_lucro);
		txt_margem_lucro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				int linhaSelecionada = table.getSelectedRow();
				txt_id.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,0)));
				txt_cod_barras.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,1)));
				// ainda não funciona
				cb_categoria.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,2)));
				txt_descricao.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,3)));
				// ainda não funciona
				cb_unidade.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,4)));
				txt_custo.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,6)));
				txt_margem_lucro.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,7)));
			}
		});
		scrollPane.setViewportView(table);
		// seta o modelo da tabela 
		table.setModel(modelo);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de incluir
				try {
					txt_categoria = cb_categoria.getSelectedItem().toString();
					txt_unidade = cb_unidade.getSelectedItem().toString();					
					ac_criar();

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
					txt_categoria = cb_categoria.getSelectedItem().toString();
					txt_unidade = cb_unidade.getSelectedItem().toString();	
					ac_atualizar();
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

	}
	
	protected void ac_criar() throws SQLException {
		// cria uma lista
		ArrayList<Produto> lista = new ArrayList<Produto>();
			
		// busca pelo cdao.read() todos os registros do banco
		lista = cdao.read();
			
		// uma variável booleana para testar se tem ids duplicados
		boolean testaIdDuplicado = false;
			
		int id = 0;
		// valida se o numero é numero e se é duplicado
		try {
			// varre a lista de cadastros do banco
			for (Produto p : lista) { 
				// verifica se o id da lista é igual ao informado no textFild
				if (p.getId() == Integer.parseInt(txt_id.getText().trim())) {
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

			float codigoDeBarras = Float.valueOf(txt_cod_barras.getText());
			String categoria = txt_categoria;
			String descricao = txt_descricao.getText().trim();
			String unidade = txt_unidade;
			BigDecimal custo = BigDecimal.valueOf(Float.valueOf(txt_custo.getText()));
			BigDecimal margemDeLucro = BigDecimal.valueOf(Float.valueOf(txt_margem_lucro.getText()));

			// instancia um noco cadastro
			Produto p = new Produto(id, codigoDeBarras, categoria, descricao, unidade, custo, margemDeLucro);
			// passa pro modelo os valores do novo cadastro para ser adicionado numa lista
			modelo.incluir(p);
			
			// cria no banco um novo cadastro
			cdao.create(p);

			// limpa os campos de texto da tela
			limparCampos();
			
			JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");

			ac_ler();	
	}

	protected void ac_ler() throws SQLException {
		
	}

	protected void ac_atualizar() throws SQLException {
		
	}
	
	protected void ac_deletar() throws SQLException {
		
	}
	
	private void limparCampos() {
		txt_id.setText("");
		txt_cod_barras.setText("");
		txt_descricao.setText("");
		txt_custo.setText("");
		txt_margem_lucro.setText("");
	}
}

package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Tela do cadastrar Produto

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

import Dao.ProdutoDaoImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import loja.Categoria;
import loja.Cliente;
import loja.Produto;
import loja.Unidade;
import modelos.ModeloProduto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class MioloCadastroProduto extends JPanel {
	private JTextField txt_cod_barras;
	private JTextField txt_descricao;
	private JTextField txt_valor;
	private JTable table;
	private ModeloProduto modelo = new ModeloProduto();
	private JTextField txt_margem_lucro;
	private int id_selecionado;

	// implementação do produto no banco
	ProdutoDaoImpl pdao = new ProdutoDaoImpl();
	
	/**
	 * Create the panel.
	 */
	public MioloCadastroProduto() {
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00D3D. BARRAS");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_cod_barras = new JTextField();
		GridBagConstraints gbc_txt_cod_barras = new GridBagConstraints();
		gbc_txt_cod_barras.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cod_barras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cod_barras.gridx = 2;
		gbc_txt_cod_barras.gridy = 0;
		add(txt_cod_barras, gbc_txt_cod_barras);
		txt_cod_barras.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CATEGORIA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox cb_categoria = new JComboBox(Categoria.values());
		GridBagConstraints gbc_cb_categoria = new GridBagConstraints();
		gbc_cb_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_cb_categoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_categoria.gridx = 2;
		gbc_cb_categoria.gridy = 1;
		add(cb_categoria, gbc_cb_categoria);
		
		JLabel lblNewLabel_3 = new JLabel("DESCRI\u00C7\u00C3O");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txt_descricao = new JTextField();
		GridBagConstraints gbc_txt_descricao = new GridBagConstraints();
		gbc_txt_descricao.insets = new Insets(0, 0, 5, 0);
		gbc_txt_descricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_descricao.gridx = 2;
		gbc_txt_descricao.gridy = 2;
		add(txt_descricao, gbc_txt_descricao);
		txt_descricao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UNIDADE");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox cb_unidade = new JComboBox(Unidade.values());
		GridBagConstraints gbc_cb_unidade = new GridBagConstraints();
		gbc_cb_unidade.insets = new Insets(0, 0, 5, 0);
		gbc_cb_unidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_unidade.gridx = 2;
		gbc_cb_unidade.gridy = 3;
		add(cb_unidade, gbc_cb_unidade);
		
		JLabel lblNewLabel_5 = new JLabel("VALOR");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridwidth = 2;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txt_valor = new JTextField();
		GridBagConstraints gbc_txt_custo = new GridBagConstraints();
		gbc_txt_custo.insets = new Insets(0, 0, 5, 0);
		gbc_txt_custo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_custo.gridx = 2;
		gbc_txt_custo.gridy = 4;
		add(txt_valor, gbc_txt_custo);
		txt_valor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("MARGEM DE LUCRO");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridwidth = 2;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txt_margem_lucro = new JTextField();
		GridBagConstraints gbc_txt_margem_lucro = new GridBagConstraints();
		gbc_txt_margem_lucro.insets = new Insets(0, 0, 5, 0);
		gbc_txt_margem_lucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_margem_lucro.gridx = 2;
		gbc_txt_margem_lucro.gridy = 5;
		add(txt_margem_lucro, gbc_txt_margem_lucro);
		txt_margem_lucro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = table.getSelectedRow();
				id_selecionado = (int) modelo.getValueAt(linhaSelecionada,0);
				txt_cod_barras.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,1)).trim());
				cb_categoria.setEditable(true);
				cb_categoria.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,2)).trim());
				cb_categoria.setEditable(false);
				txt_descricao.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,3)).trim());
				cb_unidade.setEditable(true);
				cb_unidade.setSelectedItem(String.valueOf(modelo.getValueAt(linhaSelecionada,4)).trim());
				cb_unidade.setEditable(false);
				txt_valor.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,5)).trim());
				txt_margem_lucro.setText(String.valueOf(modelo.getValueAt(linhaSelecionada,6)).trim());
			}
		});
		scrollPane.setViewportView(table);
		
		// seta o modelo da tabela 
		table.setModel(modelo);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de incluir
				try {
					String codBar_p = txt_cod_barras.getText().trim();
					String custo_p = txt_valor.getText().trim();
					String marLuc_p = txt_margem_lucro.getText().trim();
					
					// testa se tudo está de acordo para a inserção
					if (!codBar_p.isEmpty() & !custo_p.isEmpty() & !marLuc_p.isEmpty()) {
						
						float codigoDeBarras = Float.valueOf(txt_cod_barras.getText().trim());
						String categoria = String.valueOf(cb_categoria.getSelectedItem());
						String descricao = txt_descricao.getText().trim();
						String unidade = String.valueOf(cb_unidade.getSelectedItem());
						BigDecimal custo = BigDecimal.valueOf(Float.valueOf(txt_valor.getText().trim()));
						BigDecimal margemDeLucro = BigDecimal.valueOf(Float.valueOf(txt_margem_lucro.getText().trim()));
	
						// instancia um noco cadastro
						Produto produto = new Produto(0, codigoDeBarras, categoria, descricao, unidade, custo, margemDeLucro);
						
						ac_criar(produto);
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

					String codBar_p = txt_cod_barras.getText().trim();
					String custo_p = txt_valor.getText().trim();
					String marLuc_p = txt_margem_lucro.getText().trim();
					
					if (!codBar_p.isEmpty() & !custo_p.isEmpty() & !marLuc_p.isEmpty()) {

						float codigoDeBarras = Float.valueOf(txt_cod_barras.getText().trim());
						String categoria = String.valueOf(cb_categoria.getSelectedItem());
						String descricao = txt_descricao.getText().trim();
						String unidade = String.valueOf(cb_unidade.getSelectedItem());
						BigDecimal custo = BigDecimal.valueOf(Float.valueOf(txt_valor.getText()));
						BigDecimal margemDeLucro = BigDecimal.valueOf(Float.valueOf(txt_margem_lucro.getText()));
	
						// instancia um noco cadastro
						Produto produto = new Produto(id_selecionado, codigoDeBarras, categoria, descricao, unidade, custo, margemDeLucro);
						
						ac_atualizar(produto);
						
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

		try {				
			atualizarLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}

	protected void ac_criar(Produto produto) throws SQLException {
		// cria no banco um novo cadastro
		pdao.create(produto);
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		atualizarLista();
	}

	protected void ac_atualizar(Produto produto) throws SQLException {
		// atualiza no banco
		pdao.update(produto);
		// atualizar a tabela
		atualizarLista();
	}
	
	protected void ac_deletar() throws SQLException {
		// resposta do usuário, é emitida por um JOptionPane
		int resposta = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Deletar",JOptionPane.YES_OPTION);
		if (resposta == 0) {
			// deleta o usuário craiando uma nova instância de Cadastro passando só o id
			pdao.delete(id_selecionado);
			// atualiza tudo
			atualizarLista();
		}
	}

	protected void atualizarLista() throws SQLException {
		// limpa os campos de texto da tela
		limparCampos();
		modelo.setarLista(pdao.read());
	}
	
	private void limparCampos() {
		txt_cod_barras.setText("");
		txt_descricao.setText("");
		txt_valor.setText("");
		txt_margem_lucro.setText("");
	}
}

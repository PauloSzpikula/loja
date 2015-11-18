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

public class MioloCadastroVenda extends JPanel {
	private ModeloCliente modelo;
	private JTextField textField;

	
	/**
	 * Create the panel.
	 */
	public MioloCadastroVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("CLIENTE");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.gridwidth = 2;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		JComboBox cb_cliente = new JComboBox();
		GridBagConstraints gbc_cb_cliente = new GridBagConstraints();
		gbc_cb_cliente.insets = new Insets(0, 0, 5, 5);
		gbc_cb_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_cliente.gridx = 2;
		gbc_cb_cliente.gridy = 0;
		add(cb_cliente, gbc_cb_cliente);
		
		JLabel lblNome = new JLabel("PRODUTO");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.gridwidth = 2;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		JComboBox cb_produto = new JComboBox();
		GridBagConstraints gbc_cb_produto = new GridBagConstraints();
		gbc_cb_produto.insets = new Insets(0, 0, 5, 5);
		gbc_cb_produto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_produto.gridx = 2;
		gbc_cb_produto.gridy = 1;
		add(cb_produto, gbc_cb_produto);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		// seta o modelo da tabela 
		table.setModel(modelo);
		
		JLabel lblValorTotal = new JLabel("VALOR TOTAL R$:");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.gridwidth = 2;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 3;
		add(lblValorTotal, gbc_lblValorTotal);
		
		JLabel lblNewLabel = new JLabel("00,00");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblValorPagoR = new JLabel("VALOR PAGO R$:");
		GridBagConstraints gbc_lblValorPagoR = new GridBagConstraints();
		gbc_lblValorPagoR.gridwidth = 2;
		gbc_lblValorPagoR.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagoR.gridx = 0;
		gbc_lblValorPagoR.gridy = 4;
		add(lblValorPagoR, gbc_lblValorPagoR);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTrocoR = new JLabel("TROCO R$:");
		GridBagConstraints gbc_lblTrocoR = new GridBagConstraints();
		gbc_lblTrocoR.gridwidth = 2;
		gbc_lblTrocoR.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrocoR.gridx = 0;
		gbc_lblTrocoR.gridy = 5;
		add(lblTrocoR, gbc_lblTrocoR);
		
		JLabel label = new JLabel("00,00");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 5;
		add(label, gbc_label);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de incluir
				try {

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
//					String id_p = txt_id.getText();
//					if (!id_p.isEmpty()) {
//						ac_deletar();
//					} else {
//						mensagemDeErro();	
//					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);
		
		// instancia o ModeloCadastro
		modelo = new ModeloCliente();
	
		//atualizar a lista
		try {					
			ac_ler();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void mensagemIdDuplicado() {
		JOptionPane.showMessageDialog(this, "Id Duplicado, tente outro meu amiguinho!");
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}
	
	protected void ac_criar(Cliente c) throws SQLException {
//		// passa pro modelo os valores do novo cadastro para ser adicionado numa lista
//		modelo.incluir(c);
//		// cria no banco um novo cadastro
//		cdao.create(c);
//		
//		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
//		// atualiza a tabela
//		ac_ler();
	}

	protected void ac_ler() throws SQLException {
//		// limpa a tabela para não duplicar tudo
//		modelo.clear();
//		// cria uma lista que vai conter a outra lista -- isso é muito loko
//		ArrayList<Cliente> lista = new ArrayList<Cliente>();
//
//		// lista recebe o retorno do read()
//		lista = cdao.read();
//
//		// varre a lista inserindo em outra lista
//		for (Cliente c : lista) { 
//			// inclui a bagaça
//			modelo.incluir(c);
//		}
//		
//		// limpa os campos de texto da tela
//		limparCampos();
	}
	
	protected void ac_atualizar(Cliente c) throws SQLException {
//		// atualiza no banco
//		cdao.update(c);
//		// atualizar a tabela
//		ac_ler();
	}

	protected void ac_deletar() throws SQLException{
//		// resposta do usuário, é emitida por um JOptionPane
//		int resposta = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Deletar",JOptionPane.YES_OPTION);
//		if (resposta == 0) {
//			int id = Integer.parseInt(txt_id.getText().trim());
//						
//			// deleta o usuário craiando uma nova instância de Cadastro passando só o id
//			cdao.delete(id);
//			
//			// atualiza tudo
//			ac_ler();
//		}
	}

	private void limparCampos() {
	}
}






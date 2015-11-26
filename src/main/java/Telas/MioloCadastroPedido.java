package Telas;

//Autor: Paulo Szpikula, 19/11/2015 20:33
//Descrição: Tela do cadastrar Pedido

import javafx.scene.Parent;

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
import loja.Pedido;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import Dao.ClienteDaoImpl;
import Dao.PedidoDaoImpl;

public class MioloCadastroPedido extends JPanel {
	private ModeloPedido modelo;
	private JTextField textField;

	// implementação do cliente no banco
	PedidoDaoImpl pdao = new PedidoDaoImpl();
	
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	private JTextField txt_id_pedido;
	
	
	/**
	 * Create the panel.
	 */
	public MioloCadastroPedido() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 162};
		gridBagLayout.rowHeights = new int[]{0, 36, 0, 47, 0, 0, 0, 143, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("CLIENTE");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridwidth = 2;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		JComboBox cb_cliente = new JComboBox();
		cb_cliente.removeAllItems();
		try {
			ArrayList<String> lista = populaComboBox();
			Iterator i = lista.iterator(); 
			while(i.hasNext()) {  
				  cb_cliente.addItem(String.valueOf(i.next()));  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_cb_cliente = new GridBagConstraints();
		gbc_cb_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cb_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_cliente.gridx = 2;
		gbc_cb_cliente.gridy = 0;
		add(cb_cliente, gbc_cb_cliente);
		
		JLabel lblIdPedido = new JLabel("ID PEDIDO");
		GridBagConstraints gbc_lblIdPedido = new GridBagConstraints();
		gbc_lblIdPedido.gridwidth = 2;
		gbc_lblIdPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdPedido.gridx = 0;
		gbc_lblIdPedido.gridy = 1;
		add(lblIdPedido, gbc_lblIdPedido);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.setEnabled(false);
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCadastroPedidoItem janela = new JanelaCadastroPedidoItem();
		        janela.setLocationRelativeTo(null);
		        janela.setVisible(true);
			}
		});
		
		txt_id_pedido = new JTextField();
		GridBagConstraints gbc_txt_id_pedido = new GridBagConstraints();
		gbc_txt_id_pedido.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id_pedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_id_pedido.gridx = 2;
		gbc_txt_id_pedido.gridy = 1;
		add(txt_id_pedido, gbc_txt_id_pedido);
		txt_id_pedido.setColumns(10);
		GridBagConstraints gbc_btnAdicionarProduto = new GridBagConstraints();
		gbc_btnAdicionarProduto.anchor = GridBagConstraints.EAST;
		gbc_btnAdicionarProduto.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarProduto.gridx = 2;
		gbc_btnAdicionarProduto.gridy = 2;
		add(btnAdicionarProduto, gbc_btnAdicionarProduto);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		// instancia o ModeloCadastro
		modelo = new ModeloPedido();
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		// seta o modelo da tabela 
		table.setModel(modelo);
		
		JLabel lblValorTotal = new JLabel("VALOR TOTAL R$:");
		lblValorTotal.setEnabled(false);
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.anchor = GridBagConstraints.EAST;
		gbc_lblValorTotal.gridwidth = 2;
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 4;
		add(lblValorTotal, gbc_lblValorTotal);
		
		JLabel lblNewLabel = new JLabel("00,00");
		lblNewLabel.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblValorPagoR = new JLabel("VALOR PAGO R$:");
		lblValorPagoR.setEnabled(false);
		GridBagConstraints gbc_lblValorPagoR = new GridBagConstraints();
		gbc_lblValorPagoR.anchor = GridBagConstraints.EAST;
		gbc_lblValorPagoR.gridwidth = 2;
		gbc_lblValorPagoR.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorPagoR.gridx = 0;
		gbc_lblValorPagoR.gridy = 5;
		add(lblValorPagoR, gbc_lblValorPagoR);
		
		textField = new JTextField();
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTrocoR = new JLabel("TROCO R$:");
		lblTrocoR.setEnabled(false);
		GridBagConstraints gbc_lblTrocoR = new GridBagConstraints();
		gbc_lblTrocoR.anchor = GridBagConstraints.EAST;
		gbc_lblTrocoR.gridwidth = 2;
		gbc_lblTrocoR.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrocoR.gridx = 0;
		gbc_lblTrocoR.gridy = 6;
		add(lblTrocoR, gbc_lblTrocoR);
		
		JLabel label = new JLabel("00,00");
		label.setEnabled(false);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 2;
		gbc_label.gridy = 6;
		add(label, gbc_label);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de incluir
				try {
					String id_p = txt_id_pedido.getText().trim();
					String id_cc = cb_cliente.getSelectedItem().toString();

					
					// cria uma lista
					ArrayList<Pedido> lista = new ArrayList<Pedido>();
					// busca pelo cdao.read() todos os registros do banco
					lista = pdao.read();
					
					// valida se o numero é numero e se é duplicado
					int id = 0;
					if (id_p.matches("[0-9]")) {
						id = Integer.parseInt(id_p);
					} else {
						mensagemDeErro();
						return;
					}
					
					// uma variável booleana para testar se tem ids duplicados
					boolean testaIdDuplicado = false;
					
					// varre a lista de cadastros do banco
					for (Pedido pp : lista) {
						// verifica se o id da lista é igual ao informado no textFild
						if (pp.getId() == id) {
							// seta verdadeiro para ids duplicados
							testaIdDuplicado = true;
						}
					}
					// aqui é lançado um erro caso o id seja dulicado
					if (testaIdDuplicado) {
						mensagemIdDuplicado();
						return;
					}
					
					
					String id_nome = cb_cliente.getSelectedItem().toString().trim().replaceAll("\\s+", "");
					
					String id_cli = id_nome.substring(0,id_nome.indexOf("-"));			
					
					int id_c = Integer.parseInt(id_cli);
					
					
					// testa se os campos estão preenchidos para a inserção
					if (!id_p.isEmpty() & !id_cc.isEmpty()) {
						
						// instancia um noco cadastro
						Pedido p = new Pedido(id, id_c, null, null, null, null, null, null, null, null, null, null);
						
						ac_criar(p);
					}
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
//				try {
//					
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ação de deletar
//				try {					
//					String id_p = txt_id.getText();
//					if (!id_p.isEmpty()) {
//						ac_deletar();
//					} else {
//						mensagemDeErro();	
//					}	
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
			}
		});
		panel.add(btnNewButton_3);
	
		//atualizar a lista
		try {					
			ac_ler();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private ArrayList<String> populaComboBox() throws SQLException {
        return cdao.listaIdClientes();
	}
	
	protected void mensagemIdDuplicado() {
		JOptionPane.showMessageDialog(this, "Id Duplicado, tente outro meu amiguinho!");
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}
	
	protected void ac_criar(Pedido p) throws SQLException {
		// passa pro modelo os valores do novo cadastro para ser adicionado numa lista
		modelo.incluir(p);
		// cria no banco um novo cadastro
		pdao.create(p);
		
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		// atualiza a tabela
		ac_ler();
	}

	protected void ac_ler() throws SQLException {
		// limpa a tabela para não duplicar tudo
		modelo.clear();
		// cria uma lista que vai conter a outra lista -- isso é muito loko
		ArrayList<Pedido> lista = new ArrayList<Pedido>();

		// lista recebe o retorno do read()
		lista = pdao.read();

		// varre a lista inserindo em outra lista
		for (Cliente c : lista) { 
			// inclui a bagaça
			modelo.incluir(c);
		}
		
		// limpa os campos de texto da tela
		limparCampos();
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






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
import modelos.ModeloPedido;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import Dao.ClienteDaoImpl;
import Dao.PedidoDaoImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MioloCadastroPedido extends JPanel {
	private ModeloPedido modelo = new ModeloPedido();
	private int id_selecionado;
	
	// implementação do cliente no banco
	PedidoDaoImpl pdao = new PedidoDaoImpl();
	
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	/**
	 * Create the panel.
	 */
	public MioloCadastroPedido() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 162};
		gridBagLayout.rowHeights = new int[]{0, 169, 32, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_btnAdicionarProduto = new GridBagConstraints();
		gbc_btnAdicionarProduto.anchor = GridBagConstraints.EAST;
		gbc_btnAdicionarProduto.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarProduto.gridx = 2;
		gbc_btnAdicionarProduto.gridy = 2;
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
				
		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = table.getSelectedRow();
				id_selecionado = (int) modelo.getValueAt(linhaSelecionada,0);
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
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaCadastroPedido janela = new JanelaCadastroPedido();
		        janela.setLocationRelativeTo(null);
		        janela.setVisible(true);
		        
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atualizar Tabela");
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
					if (id_selecionado != 0) {						
						JanelaEditarPedido janela = new JanelaEditarPedido(pdao.pegaPedido(id_selecionado));
				        janela.setLocationRelativeTo(null);
				        janela.setVisible(true);
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
					if (id_selecionado != 0) {
						ac_deletar();
					} else {
						mensagemDeErro();
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnFecharCompra = new JButton("Fechar Pedido");
		btnFecharCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (id_selecionado != 0) {	
						JanelaFecharPedido janela = new JanelaFecharPedido(pdao.pegaPedido(id_selecionado));
				        janela.setLocationRelativeTo(null);
				        janela.setVisible(true);
					} else {
						mensagemDeErro();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}       
			}
		});
		panel.add(btnFecharCompra);
	
		//atualizar a lista
		try {					
			atualizarLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	protected void ac_criar(Pedido pedido) throws SQLException {
//		pdao.create(pedido);
//		pdao.totalPedido(pedido.getId());
//		atualizarLista();
//	}

	protected void ac_deletar() throws SQLException{
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
		modelo.setarLista(pdao.read());
	}
	
	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, selecione alguma linha!");
	}
}






package Telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Dao.ItemDaoImpl;
import Dao.PedidoDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import loja.Item;
import loja.Pedido;
import modelos.ModeloItem;
import modelos.ModeloPedido;

public class JanelaEditarPedido extends JDialog {

	private static Pedido pedido = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ModeloItem modelo = new ModeloItem();
	private int id_selecionado;
	
	// implementação do item no banco
	ItemDaoImpl idao = new ItemDaoImpl();
	
	// implementação do cliente no banco
	PedidoDaoImpl pdao = new PedidoDaoImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaEditarPedido dialog = new JanelaEditarPedido(pedido);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	public JanelaEditarPedido(Pedido pedido) {
		// pedido global recebe pedido enviado
		this.pedido = pedido;
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("ID PEDIDO");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{	
			JLabel lblNewLabel_2 = new JLabel(String.valueOf(pedido.getId()));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 0;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("CLIENTE");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_3 = new JLabel(String.valueOf(pedido.getNome()));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 1;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("ITENS DO PEDIDO");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_4.gridwidth = 2;
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 2;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 2;
			gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 3;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				table = new JTable();
				// seta o modelo da tabela 
				table.setModel(modelo);
				
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int linhaSelecionada = table.getSelectedRow();
						id_selecionado = Integer.parseInt(String.valueOf(modelo.getValueAt(linhaSelecionada,0)));
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Criar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						try {
							pdao.totalPedido(pedido.getId());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						JanelaEditarItem janela = new JanelaEditarItem(pedido);
						janela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						janela.setVisible(true);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnExcluir = new JButton("Deletar");
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// ação de deletar
						try {
							ac_deletar();
							pdao.totalPedido(pedido.getId());
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
				{
					JButton btnLer = new JButton("Ler");
					btnLer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								atualizarLista();
								pdao.totalPedido(pedido.getId());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					buttonPane.add(btnLer);
				}
				buttonPane.add(btnExcluir);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							pdao.totalPedido(pedido.getId());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
		//atualizar a lista
		try {					
			atualizarLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void ac_deletar() throws SQLException {
		// resposta do usuário, é emitida por um JOptionPane
		int resposta = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Deletar",JOptionPane.YES_OPTION);
		
		if (resposta == 0) {
			// deleta o usuário craiando uma nova instância de Cadastro passando só o id
			idao.delete(id_selecionado);
			// atualiza tabela
			atualizarLista();
		}
	}

	protected void atualizarLista() throws SQLException {
		modelo.setarLista(idao.ListaItensDoId(pedido.getId()));
	}

}

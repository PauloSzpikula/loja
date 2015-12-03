package Telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Dao.ItemDaoImpl;
import Dao.PedidoDaoImpl;
import Dao.ProdutoDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import loja.Cliente;
import loja.Item;
import loja.Pedido;
import loja.Produto;

public class JanelaEditarPedidoItem extends JDialog {
	
	private static Pedido pedido = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_qtd;
	JComboBox cb_item;
	
	// implementa��o do item no banco
	ItemDaoImpl idao = new ItemDaoImpl();
	
	// implementa��o do produto no banco
	ProdutoDaoImpl pdao = new ProdutoDaoImpl();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaEditarPedidoItem dialog = new JanelaEditarPedidoItem(pedido);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JanelaEditarPedidoItem(Pedido pedido) {
		// pedido global recebe pedido enviado
		this.pedido = pedido;
		setModal(true);
		setBounds(100, 100, 450, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			cb_item = new JComboBox();
			cb_item.removeAllItems();			
			try {
				ArrayList<String> lista = populaComboBox();
				Iterator i = lista.iterator(); 
				while(i.hasNext()) {  
					cb_item.addItem(String.valueOf(i.next()));  
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		{
			JLabel lblProduto = new JLabel("PRODUTO");
			GridBagConstraints gbc_lblProduto = new GridBagConstraints();
			gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
			gbc_lblProduto.anchor = GridBagConstraints.EAST;
			gbc_lblProduto.gridx = 0;
			gbc_lblProduto.gridy = 0;
			contentPanel.add(lblProduto, gbc_lblProduto);
		}
		
		GridBagConstraints gbc_cb_item = new GridBagConstraints();
		gbc_cb_item.insets = new Insets(0, 0, 5, 0);
		gbc_cb_item.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_item.gridx = 1;
		gbc_cb_item.gridy = 0;
		contentPanel.add(cb_item, gbc_cb_item);
		{
			JLabel lblNewLabel_1 = new JLabel("QUANTIDADE");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txt_qtd = new JTextField();
			GridBagConstraints gbc_txt_qtd = new GridBagConstraints();
			gbc_txt_qtd.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_qtd.gridx = 1;
			gbc_txt_qtd.gridy = 1;
			contentPanel.add(txt_qtd, gbc_txt_qtd);
			txt_qtd.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// a��o de incluir
						try {
							String qtd = txt_qtd.getText().trim();
							
							String id_desc = cb_item.getSelectedItem().toString().trim().replaceAll("\\s+", "");
							String id_item = id_desc.substring(0,id_desc.indexOf("-"));			


							// testa se os campos est�o preenchidos para a inser��o
							if (!qtd.isEmpty()) {
												
								Produto produto = pdao.pegaProduto(Integer.parseInt(id_item));																
								// instancia um noco cadastro
								Item item = new Item(0, pedido.getId(), produto.getId(), produto.getCodigoDeBarras(), produto.getCategoria(), produto.getDescricao(), produto.getUnidade(), produto.getValor(), produto.getMargemDeLucro(), Integer.parseInt(qtd), null);
								
								ac_criar(item);
							}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void ac_criar(Item i) throws SQLException{
		// cria no banco um novo cadastro
		idao.create(i);
		JOptionPane.showMessageDialog(this, "Opera��o realizada com sucesso!");
		dispose();
	}

	private ArrayList<String> populaComboBox() throws SQLException {
        return idao.listaIdProdutos();
	}
	
	protected void mensagemIdDuplicado() {
		JOptionPane.showMessageDialog(this, "Id Duplicado, tente outro meu amiguinho!");
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Opera��o n�o pode ser realizada, preencha todos os campos corretamente!");
	}

}

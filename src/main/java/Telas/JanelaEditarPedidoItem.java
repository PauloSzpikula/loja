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

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_qtd;
	JComboBox cb_item;
	
	// implementa��o do cliente no banco
	ItemDaoImpl idao = new ItemDaoImpl();
	
	// implementa��o do produto no banco
	ProdutoDaoImpl pdao = new ProdutoDaoImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaEditarPedidoItem dialog = new JanelaEditarPedidoItem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JanelaEditarPedidoItem() {
		setModal(true);
		setBounds(100, 100, 450, 122);
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
			JLabel lblNewLabel = new JLabel("ITEM");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
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
			
			GridBagConstraints gbc_cb_item = new GridBagConstraints();
			gbc_cb_item.insets = new Insets(0, 0, 5, 0);
			gbc_cb_item.fill = GridBagConstraints.HORIZONTAL;
			gbc_cb_item.gridx = 1;
			gbc_cb_item.gridy = 0;
			contentPanel.add(cb_item, gbc_cb_item);
		}
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
							String id_p = cb_item.getSelectedItem().toString();
							String qtd = txt_qtd.getText().trim();
							
							String id_desc = cb_item.getSelectedItem().toString().trim().replaceAll("\\s+", "");
							
							String id_item = id_desc.substring(0,id_desc.indexOf("-"));			
							
							// cria uma lista
							ArrayList<Item> lista = new ArrayList<Item>();
							// busca pelo cdao.read() todos os registros do banco
							lista = idao.read();
							
							// valida se o numero � numero e se � duplicado
							int id = 0;
							if (id_item.matches("[0-9]+")) {
								id = Integer.parseInt(id_item);
							} else {
								mensagemDeErro();
								return;
							}
							
							// uma vari�vel booleana para testar se tem ids duplicados
							boolean testaIdDuplicado = false;
							
							// varre a lista de cadastros do banco
							for (Item ii : lista) {
								// verifica se o id da lista � igual ao informado no textFild
								if (ii.getId() == id) {
									// seta verdadeiro para ids duplicados
									testaIdDuplicado = true;
								}
							}
							// aqui � lan�ado um erro caso o id seja dulicado
							if (testaIdDuplicado) {
								mensagemIdDuplicado();
								return;
							}

							// testa se os campos est�o preenchidos para a inser��o
							if (!id_p.isEmpty() & !qtd.isEmpty()) {
								
								
								// montar a consulta do cliente no banco para popular o resto dos campos
								
								List<Produto> lista_produto = new ArrayList<Produto>();
								lista_produto = pdao.pegaProduto(id);
																
								float codigoDeBarras = null;
								String categoria = null;
								String descricao = null;
								String unidade = null;
								BigDecimal custo = null;
								BigDecimal margemDeLucro = null;
								
								Cliente cliente = new Cliente();
								for (Cliente c: lista_cliente) { 
									telefone = c.getTelefone();
									endereco = c.getEndereco();
									cidade = c.getCidade();
									estado = c.getEstado();
									email = c.getEmail();
									genero = c.getGenero();
								}					
								
								// instancia um noco cadastro
								Item i = new Item(id, id_pedido, id_produto, codigoDeBarras, categoria, descricao, unidade, custo, margemDeLucro, quantidade, valot_total);
								
								ac_criar(i);
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

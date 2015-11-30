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
	
	private static final Pedido p = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_qtd;
	JComboBox cb_item;
	private JTextField txt_id_item;
	
	// implementação do item no banco
	ItemDaoImpl idao = new ItemDaoImpl();
	
	// implementação do produto no banco
	ProdutoDaoImpl pdao = new ProdutoDaoImpl();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaEditarPedidoItem dialog = new JanelaEditarPedidoItem(p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JanelaEditarPedidoItem(Pedido p) {
		setModal(true);
		setBounds(100, 100, 450, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("ID ITEM");
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
		}
		
		{
			txt_id_item = new JTextField();
			GridBagConstraints gbc_txt_id_item = new GridBagConstraints();
			gbc_txt_id_item.insets = new Insets(0, 0, 5, 0);
			gbc_txt_id_item.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_id_item.gridx = 1;
			gbc_txt_id_item.gridy = 0;
			contentPanel.add(txt_id_item, gbc_txt_id_item);
			txt_id_item.setColumns(10);
		}
		{
			JLabel lblProduto = new JLabel("PRODUTO");
			GridBagConstraints gbc_lblProduto = new GridBagConstraints();
			gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
			gbc_lblProduto.anchor = GridBagConstraints.EAST;
			gbc_lblProduto.gridx = 0;
			gbc_lblProduto.gridy = 1;
			contentPanel.add(lblProduto, gbc_lblProduto);
		}
		
		GridBagConstraints gbc_cb_item = new GridBagConstraints();
		gbc_cb_item.insets = new Insets(0, 0, 5, 0);
		gbc_cb_item.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_item.gridx = 1;
		gbc_cb_item.gridy = 1;
		contentPanel.add(cb_item, gbc_cb_item);
		{
			JLabel lblNewLabel_1 = new JLabel("QUANTIDADE");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txt_qtd = new JTextField();
			GridBagConstraints gbc_txt_qtd = new GridBagConstraints();
			gbc_txt_qtd.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_qtd.gridx = 1;
			gbc_txt_qtd.gridy = 2;
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
						// ação de incluir
						try {
							String id_i = txt_id_item.getText().trim();
							String id_p = cb_item.getSelectedItem().toString();
							String qtd = txt_qtd.getText().trim();
							
							String id_desc = cb_item.getSelectedItem().toString().trim().replaceAll("\\s+", "");
							
							String id_item = id_desc.substring(0,id_desc.indexOf("-"));			
							
							// cria uma lista
							ArrayList<Item> lista = new ArrayList<Item>();
							// busca pelo cdao.read() todos os registros do banco
							lista = idao.read();
							
							// valida se o numero é numero e se é duplicado
							int id = 0;
							if (id_i.matches("[0-9]+")) {
								id = Integer.parseInt(id_i);
							} else {
								mensagemDeErro();
								return;
							}
							
							// uma variável booleana para testar se tem ids duplicados
							boolean testaIdDuplicado = false;
							
							// varre a lista de cadastros do banco
							for (Item ii : lista) {
								// verifica se o id da lista é igual ao informado no textFild
								if (ii.getId() == id) {
									// seta verdadeiro para ids duplicados
									testaIdDuplicado = true;
								}
							}
							// aqui é lançado um erro caso o id seja dulicado
							if (testaIdDuplicado) {
								mensagemIdDuplicado();
								return;
							}

							// testa se os campos estão preenchidos para a inserção
							if (!id_i.isEmpty() & !id_p.isEmpty() & !qtd.isEmpty()) {
								
								
								// montar a consulta do cliente no banco para popular o resto dos campos
								
								List<Produto> lista_produto = new ArrayList<Produto>();
								lista_produto = pdao.pegaProduto(id);
								
								int id_produto = 0;								
								float codigoDeBarras = 0;
								String categoria = null;
								String descricao = null;
								String unidade = null;
								BigDecimal valor = null;
								BigDecimal margemDeLucro = null;
								
								Produto produto = new Produto();
								for (Produto p: lista_produto) { 
									id_produto = p.getId();
									codigoDeBarras = p.getCodigoDeBarras();
									categoria = p.getCategoria();
									descricao = p.getDescricao();
									unidade = p.getUnidade();
									valor = p.getValor();
									margemDeLucro = p.getMargemDeLucro();
								}					
								
								// instancia um noco cadastro
								Item i = new Item(id, p.getId(), id_produto, codigoDeBarras, categoria, descricao, unidade, valor, margemDeLucro, Integer.parseInt(qtd), null);
								
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
	
	protected void ac_criar(Item i) throws SQLException{
		// cria no banco um novo cadastro
		idao.create(i);
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		dispose();
	}

	private ArrayList<String> populaComboBox() throws SQLException {
        return idao.listaIdProdutos();
	}
	
	protected void mensagemIdDuplicado() {
		JOptionPane.showMessageDialog(this, "Id Duplicado, tente outro meu amiguinho!");
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}

}

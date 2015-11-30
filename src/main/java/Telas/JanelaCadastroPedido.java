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

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Dao.ClienteDaoImpl;
import Dao.PedidoDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import loja.Cliente;
import loja.Pedido;

public class JanelaCadastroPedido extends JDialog {
	
	// implementação do cliente no banco
	PedidoDaoImpl pdao = new PedidoDaoImpl();
	
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();

	private JComboBox cb_cliente;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaCadastroPedido dialog = new JanelaCadastroPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JanelaCadastroPedido() {
		setModal(true);
		setBounds(100, 100, 450, 128);
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
			JLabel lblNewLabel = new JLabel("CLIENTE");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			
			cb_cliente = new JComboBox();
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
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 0;
			contentPanel.add(cb_cliente, gbc_comboBox);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("ID PEDIDO");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txt_id = new JTextField();
			GridBagConstraints gbc_txt_id = new GridBagConstraints();
			gbc_txt_id.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_id.gridx = 1;
			gbc_txt_id.gridy = 1;
			contentPanel.add(txt_id, gbc_txt_id);
			txt_id.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Criar Pedido");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// ação de incluir
						try {
							String id_p = txt_id.getText().trim();
							String id_cc = cb_cliente.getSelectedItem().toString();

							
							// cria uma lista
							ArrayList<Pedido> lista = new ArrayList<Pedido>();
							// busca pelo cdao.read() todos os registros do banco
							lista = pdao.read();
							
							// valida se o numero é numero e se é duplicado
							int id = 0;
							if (id_p.matches("[0-9]+")) {
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
							String nome_cli = id_nome.substring(id_nome.indexOf("-")+1);
							int id_c = Integer.parseInt(id_cli);
							
							
							// testa se os campos estão preenchidos para a inserção
							if (!id_p.isEmpty() & !id_cc.isEmpty()) {
								
								
								// montar a consulta do cliente no banco para popular o resto dos campos
								
								List<Cliente> lista_cliente = new ArrayList<Cliente>();
								lista_cliente = cdao.pegaCliente(id_c);
								
								String telefone = null;
								String endereco = null;
								String cidade = null;
								String estado = null;
								String email = null;
								String genero = null;
								
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
								Pedido p = new Pedido(id, id_c, nome_cli, telefone, endereco, cidade, estado, email, genero, null, null, null, false);
								
								ac_criar(p);
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
	protected void ac_criar(Pedido p) throws SQLException {		
		// cria no banco um novo cadastro
		pdao.create(p);
		
		JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		
		dispose();
		
		JanelaEditarPedido janela = new JanelaEditarPedido(p);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
		
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
	
}

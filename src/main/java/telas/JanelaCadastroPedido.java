package telas;

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

import dao.ClienteDaoImpl;
import dao.PedidoDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
		setBounds(100, 100, 450, 105);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("CLIENTE");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
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
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 0;
			contentPanel.add(cb_cliente, gbc_comboBox);
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
							// pega o conteúdo do combobox e retira os espaços
							String id_nome = cb_cliente.getSelectedItem().toString().trim().replaceAll("\\s+", "");
							// faz uma substring só do id
							String id_cli = id_nome.substring(0,id_nome.indexOf("-"));
							
							// testa se os campos estão preenchidos para a inserção
							if (!id_nome.isEmpty()) {
								// instancia o cliente
								Cliente cliente = new Cliente();
								// cliente recebe o respectivo cliente buscado do banco
								cliente = cdao.pegaCliente(Integer.parseInt(id_cli));
																
								Pedido p = new Pedido(0, cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCidade(), cliente.getEstado(), cliente.getEmail(), cliente.getGenero(), null, null, null, false, null);
								
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

	
	protected void ac_criar(Pedido pedido) throws SQLException {		
		// cria no banco um novo cadastro
		pdao.create(pedido);
		
		dispose();
//		ArrayList<Pedido> lista = new ArrayList<Pedido>();
//		lista = pdao.read();
//		int ultimo_id = 0;
//		
//		for (Pedido p: lista) {
//			ultimo_id++;
//		}

//		JanelaEditarPedido janela = new JanelaEditarPedido(pdao.pegaPedido(ultimo_id));
//        janela.setLocationRelativeTo(null);
//        janela.setVisible(true);
	}
	
	private ArrayList<String> populaComboBox() throws SQLException {
        return cdao.listaIdClientes();
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, preencha todos os campos corretamente!");
	}
	
}

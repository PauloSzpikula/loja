package Telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import dao.PedidoDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import loja.Pedido;

public class JanelaFecharPedido extends JDialog {

	private static Pedido pedido = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_valor_pago;
	BigDecimal troco = null;
	JLabel lbl_troco;
	// implementação do cliente no banco
	PedidoDaoImpl pdao = new PedidoDaoImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JanelaFecharPedido dialog = new JanelaFecharPedido(pedido);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public JanelaFecharPedido(Pedido pedido) throws SQLException {
		// pedido global recebe pedido enviado
		this.pedido = pedido;
		setModal(true);
		setBounds(100, 100, 224, 155);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.WEST);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{74, 124, 0};
		gbl_contentPanel.rowHeights = new int[]{14, 14, 20, 14, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Id do Pedido");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNewLabel_4 = new JLabel(String.valueOf(pedido.getId()));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 0;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Valor do Pedido");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_5 = new JLabel(String.valueOf("R$ " + pedido.getTotal()));
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 1;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Valor Pago");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			txt_valor_pago = new JTextField();
			GridBagConstraints gbc_txt_valor_pago = new GridBagConstraints();
			gbc_txt_valor_pago.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_valor_pago.insets = new Insets(0, 0, 5, 0);
			gbc_txt_valor_pago.gridx = 1;
			gbc_txt_valor_pago.gridy = 2;
			contentPanel.add(txt_valor_pago, gbc_txt_valor_pago);
			txt_valor_pago.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Troco");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			lbl_troco = new JLabel(String.valueOf("R$ " + troco));
			GridBagConstraints gbc_lbl_troco = new GridBagConstraints();
			gbc_lbl_troco.anchor = GridBagConstraints.WEST;
			gbc_lbl_troco.gridx = 1;
			gbc_lbl_troco.gridy = 3;
			contentPanel.add(lbl_troco, gbc_lbl_troco);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							String valor_pago = txt_valor_pago.getText().trim();
							
							if (!valor_pago.isEmpty()) {

								BigDecimal val_pago = new BigDecimal(valor_pago.replaceAll(",", "."));
								troco = pedido.getTotal().subtract(val_pago);								

								lbl_troco.setText(String.valueOf("R$ " + troco));
															
								pdao.valorPago(val_pago, troco, pedido.getId());
							
							} else {
								mensagemDeErro();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Fechar Janela");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.pedido = pdao.pegaPedido(pedido.getId());
		
	}

	protected void mensagemDeErro() {
		JOptionPane.showMessageDialog(this, "Operação não pode ser realizada, informe o valor a ser pago!");
	}
	
}

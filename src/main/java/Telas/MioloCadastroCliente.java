package Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MioloCadastroCliente extends JPanel {
	private JTextField txt_id;
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private JTextField txt_cidade;
	private JTextField txt_email;

	/**
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txt_id = new JTextField();
		GridBagConstraints gbc_txt_id = new GridBagConstraints();
		gbc_txt_id.fill = GridBagConstraints.BOTH;
		gbc_txt_id.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id.gridx = 2;
		gbc_txt_id.gridy = 0;
		add(txt_id, gbc_txt_id);
		txt_id.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		txt_nome = new JTextField();
		GridBagConstraints gbc_txt_nome = new GridBagConstraints();
		gbc_txt_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_nome.insets = new Insets(0, 0, 5, 0);
		gbc_txt_nome.gridx = 2;
		gbc_txt_nome.gridy = 1;
		add(txt_nome, gbc_txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TELEFONE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txt_telefone = new JTextField();
		GridBagConstraints gbc_txt_telefone = new GridBagConstraints();
		gbc_txt_telefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_telefone.insets = new Insets(0, 0, 5, 0);
		gbc_txt_telefone.gridx = 2;
		gbc_txt_telefone.gridy = 2;
		add(txt_telefone, gbc_txt_telefone);
		txt_telefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIDADE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_cidade = new JTextField();
		GridBagConstraints gbc_txt_cidade = new GridBagConstraints();
		gbc_txt_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cidade.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cidade.gridx = 2;
		gbc_txt_cidade.gridy = 3;
		add(txt_cidade, gbc_txt_cidade);
		txt_cidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("ESTADO");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.gridx = 1;
		gbc_lblEstado.gridy = 4;
		add(lblEstado, gbc_lblEstado);
		
		JComboBox cb_estado = new JComboBox();
		GridBagConstraints gbc_cb_estado = new GridBagConstraints();
		gbc_cb_estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_estado.insets = new Insets(0, 0, 5, 0);
		gbc_cb_estado.gridx = 2;
		gbc_cb_estado.gridy = 4;
		add(cb_estado, gbc_cb_estado);
		
		JLabel lblEmail = new JLabel("EMAIL");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);
		
		txt_email = new JTextField();
		GridBagConstraints gbc_txt_email = new GridBagConstraints();
		gbc_txt_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_email.insets = new Insets(0, 0, 5, 0);
		gbc_txt_email.gridx = 2;
		gbc_txt_email.gridy = 5;
		add(txt_email, gbc_txt_email);
		txt_email.setColumns(10);
		
		JLabel lblGenero = new JLabel("GENERO");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.gridx = 1;
		gbc_lblGenero.gridy = 6;
		add(lblGenero, gbc_lblGenero);
		
		JComboBox cb_genero = new JComboBox();
		GridBagConstraints gbc_cb_genero = new GridBagConstraints();
		gbc_cb_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_genero.gridx = 2;
		gbc_cb_genero.gridy = 6;
		add(cb_genero, gbc_cb_genero);

	}

}

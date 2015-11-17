package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Tela do cadastrar usuário

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;

import loja.Cliente;
import Dao.ClienteDaoImpl;
import Dao.UsuarioDaoImpl;


public class MioloCadastroUsuario extends JPanel {
	private JTextField txt_id_usuario;
	private JTextField txt_senha;

	// implementação do produto no banco
	UsuarioDaoImpl usdao = new UsuarioDaoImpl();
	
	// implementação do cliente no banco
	ClienteDaoImpl cdao = new ClienteDaoImpl();
	
	
	private Connection con;
	/**
	 * Create the panel.
	 */
	public MioloCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("ID CLIENTE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
//		DefaultComboBoxModel<ArrayList> lista = new DefaultComboBoxModel<ArrayList>();
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			lista = populaComboBox();
			Iterator<Cliente> it = lista.iterator();
			while (it.hasNext()) {
				Cliente cat = it.next();
		
				cat.getId();
		
		
				comboBox.addItem(cat.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		
		
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("ID USU\u00C1RIO");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txt_id_usuario = new JTextField();
		GridBagConstraints gbc_txt_id_usuario = new GridBagConstraints();
		gbc_txt_id_usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_id_usuario.insets = new Insets(0, 0, 5, 0);
		gbc_txt_id_usuario.gridx = 2;
		gbc_txt_id_usuario.gridy = 1;
		add(txt_id_usuario, gbc_txt_id_usuario);
		txt_id_usuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SENHA");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txt_senha = new JTextField();
		GridBagConstraints gbc_txt_senha = new GridBagConstraints();
		gbc_txt_senha.insets = new Insets(0, 0, 5, 0);
		gbc_txt_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_senha.gridx = 2;
		gbc_txt_senha.gridy = 2;
		add(txt_senha, gbc_txt_senha);
		txt_senha.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Create");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		panel.add(btnNewButton_1);

		

		
	}

	
//	public List<Cliente> populaComboBox() {  
//        List<Cliente> array = new ArrayList<Cliente>();  
//        ResultSet result = con.query("SELECT * FROM CLIENTE");  
//        try {  
//            while (result.next()) {  
//                Cliente pais = new Cliente();  
//                pais.setId(result.getInt("cod_pais"));  
//                array.add(pais);  
//            }  
//        } catch (SQLException ex) {  
//        	
//        }  
//        return array;  
//    }  
	
	
	
	private List<Cliente> populaComboBox() throws SQLException {
        List<Cliente> array = new ArrayList<Cliente>();  
		array = cdao.listaIdClientes();
		return array;
	}
}

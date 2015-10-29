package loja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 352);
		
		JMenuBar BarraMenu = new JMenuBar();
		setJMenuBar(BarraMenu);
		
		JMenu Menu = new JMenu("Menu");
		BarraMenu.add(Menu);
		
		JMenuItem mntmCadastroDeCliente = new JMenuItem("Cadastro de Cliente");
		Menu.add(mntmCadastroDeCliente);
		
		JMenuItem mntmCadastroDeProduto = new JMenuItem("Cadastro de Produto");
		Menu.add(mntmCadastroDeProduto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

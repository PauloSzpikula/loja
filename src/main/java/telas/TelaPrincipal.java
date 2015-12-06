package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {

		blockParaLogin();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 522);
		
		JMenuBar BarraMenu = new JMenuBar();
		setJMenuBar(BarraMenu);
		
		JMenu Menu = new JMenu("Menu");
		BarraMenu.add(Menu);
		
		JMenuItem mntmCadastroDeCliente = new JMenuItem("Cadastro de Cliente");
		mntmCadastroDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaCliente();
			}
		});
		
		JMenuItem mntmCadastroDeUsuario = new JMenuItem("Cadastro de Usuário");
		mntmCadastroDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaUsuario();
			}
		});
		Menu.add(mntmCadastroDeUsuario);
		Menu.add(mntmCadastroDeCliente);
		
		JMenuItem mntmCadastroDeProduto = new JMenuItem("Cadastro de Produto");
		mntmCadastroDeProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaProduto();
			}
		});
		Menu.add(mntmCadastroDeProduto);
		
		JMenuItem mntmCadastroDePedido = new JMenuItem("Cadastro de Pedido");
		mntmCadastroDePedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaPedido();
			}
		});
		Menu.add(mntmCadastroDePedido);
		
		
		JMenuItem mntmGerarRelatrios = new JMenuItem("Gerar Relat\u00F3rios");
		mntmGerarRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaRelatorios();
			}
		});
		Menu.add(mntmGerarRelatrios);

		JMenuItem mntmTrocarDeUsurio = new JMenuItem("Trocar de Usu\u00E1rio");
		mntmTrocarDeUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaLogin();
			}
		});
		Menu.add(mntmTrocarDeUsurio);

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	
	protected void abrirTelaRelatorios() {
		TelaRelatorios telaRelatorios = new TelaRelatorios();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorios);
			}
		};
		telaRelatorios.setCloseAction(action);

		tabbedPane.addTab("Relatórios", telaRelatorios);
	}

	private void blockParaLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};
		
		TelaLogin painelLogin = new TelaLogin(acaoOk);
		glass = new BlockPanel(painelLogin);

		setGlassPane(glass);

		glass.setVisible(true);
	}
	
	private void abrirTelaCliente() {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Cliente", telaCadastroCliente);
	}
	
	private void abrirTelaProduto() {
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroProduto);
			}
		};
		telaCadastroProduto.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Produto", telaCadastroProduto);
	}
	
	public void abrirTelaUsuario() {
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroUsuario);
			}
		};
		telaCadastroUsuario.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Usuário", telaCadastroUsuario);
	}
	
	private void abrirTelaPedido() {
		TelaCadastroPedido telaCadastroPedido = new TelaCadastroPedido();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroPedido);
			}
		};
		telaCadastroPedido.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Pedido", telaCadastroPedido);
	}
	
	private void abrirTelaLogin() {
		blockParaLogin();
	}
	
}

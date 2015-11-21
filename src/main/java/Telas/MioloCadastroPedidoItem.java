package Telas;

//Autor: Paulo Szpikula, 19/11/2015 20:40
//Descrição: Tela do cadastrar Pedido

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class MioloCadastroPedidoItem extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MioloCadastroPedidoItem frame = new MioloCadastroPedidoItem();
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
	public MioloCadastroPedidoItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setEnabled(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnFechar = new JButton("fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MioloCadastroPedidoItem itens = new MioloCadastroPedidoItem();
				itens.dispose();
			}
		});
		contentPane.add(btnFechar, BorderLayout.SOUTH);
	}

}

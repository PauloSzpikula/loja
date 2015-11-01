package loja;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroCliente extends MoldAbstrato {

	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroCliente(), BorderLayout.CENTER);
	}

}

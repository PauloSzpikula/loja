package telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import modelos.ModeloAbstrato;

public class TelaCadastroUsuario extends ModeloAbstrato {

	public TelaCadastroUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroUsuario(), BorderLayout.CENTER);
	}

}

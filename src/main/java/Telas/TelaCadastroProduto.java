package Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroProduto extends ModeloAbstrato {

	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroProduto(), BorderLayout.CENTER);
	}

}

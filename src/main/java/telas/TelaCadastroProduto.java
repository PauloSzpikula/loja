package telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import modelos.ModeloAbstrato;

public class TelaCadastroProduto extends ModeloAbstrato {

	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroProduto(), BorderLayout.CENTER);
	}

}

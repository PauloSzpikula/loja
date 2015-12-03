package Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import modelos.ModeloAbstrato;

public class TelaCadastroPedido extends ModeloAbstrato {

	public TelaCadastroPedido() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroPedido(), BorderLayout.CENTER);
	}

}

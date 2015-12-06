package telas;

import java.awt.BorderLayout;

import modelos.ModeloAbstrato;

public class TelaRelatorios extends ModeloAbstrato {

	public TelaRelatorios() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloRelatorio(), BorderLayout.CENTER);
	}

}

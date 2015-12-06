package telas;

import java.awt.BorderLayout;
import modelos.ModeloAbstrato;

public class TelaCadastroCliente extends ModeloAbstrato {

	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroCliente(), BorderLayout.CENTER);
	}

}

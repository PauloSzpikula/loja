package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Modelo da tabela do usuário

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import loja.Usuario;

public class ModeloUsuario extends AbstractTableModel {
	private ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	
	public void clear() {
		lista.clear();
	}
	

	@Override
	public Object getValueAt(int row, int col) {

		Usuario u = lista.get(row);
		switch (col) {
		case 0:
			return u.getId();
		case 1:
			return u.getIdDoCliente();
		case 2:
			return u.getSenha();
		default:
			return "Erro";
		}
	}

	public void incluir (Usuario u){
		lista.add(u);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Id do Cliente";
		case 2:
			return "Senha";
		default:
			return "Erro";
		}
	}
}

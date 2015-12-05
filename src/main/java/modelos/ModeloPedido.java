package modelos;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Modelo da tabela do Cliente

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import loja.Item;
import loja.Pedido;

public class ModeloPedido extends AbstractTableModel {
	private ArrayList<Pedido> lista = new ArrayList<Pedido>();
	
	@Override
	public int getColumnCount() {
		return 4;
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

		Pedido p = lista.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getNome();
		case 2:
			return p.getTotal();	
		case 3:
			if (p.getStatus() == true) {
				return "Fechado";
			} else {
				return "Em aberto";	
			}
		default:
			return "Erro";
		}
	}

	public void incluir (Pedido p){
		lista.add(p);
		super.fireTableDataChanged();
	}

	public void setarLista (ArrayList<Pedido> lista){
		this.lista = lista;
		super.fireTableDataChanged();
	}
	
	@Override
	public String getColumnName (int col) {

		switch (col) {
		case 0:
			return "Id Pedido";
		case 1:
			return "Nome";
		case 2:
			return "Total";
		case 3:
			return "Status";
		default:
			return "Erro";
		}
	}
}

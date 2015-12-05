package modelos;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Modelo da tabela do Cliente

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import loja.Cliente;
import loja.Item;
import loja.Pedido;

public class ModeloItem extends AbstractTableModel {
	private ArrayList<Item> lista = new ArrayList<Item>();
	
	@Override
	public int getColumnCount() {
		return 6;
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

		Item i = lista.get(row);
		switch (col) {
		case 0:
			return i.getId();
		case 1:
			return i.getDescricao();
		case 2:
			return i.getUnidade();
		case 3:
			return i.getValor();	
		case 4:
			return i.getQuantidade();
		case 5:
			return i.getValot_total();
		default:
			return "Erro";
		}
	}

	public void incluir (Item i){
		lista.add(i);
		super.fireTableDataChanged();
	}

	public void setarLista (ArrayList<Item> lista){
		this.lista = lista;
		super.fireTableDataChanged();
	}
	
	@Override
	public String getColumnName (int col) {

		switch (col) {
		case 0:
			return "Id do Item";
		case 1:
			return "Descrição";
		case 2:
			return "Unidade";
		case 3:
			return "Valor";
		case 4:
			return "Quantidade";
		case 5:
			return "Total";
		default:
			return "Erro";
		}
	}
}

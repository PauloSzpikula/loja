package modelos;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Modelo da tabela do Cliente

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import loja.Item;
import loja.Pedido;

public class ModeloPedidoItem extends AbstractTableModel {
	private ArrayList<Item> lista = new ArrayList<Item>();
	
	@Override
	public int getColumnCount() {
		return 7;
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
			return i.getId_pedido();
		case 2:
			return i.getDescricao();
		case 3:
			return i.getUnidade();
		case 4:
			return i.getValor();	
		case 5:
			return i.getQuantidade();
		case 6:
			return i.getValot_total();
		default:
			return "Erro";
		}
	}

	public void incluir (Item i){
		lista.add(i);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Id Pedido";
		case 2:
			return "Descrição";
		case 3:
			return "Unidade";
		case 4:
			return "Valor";
		case 5:
			return "Quantidade";
		case 6:
			return "Total";
		default:
			return "Erro";
		}
	}
}

package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Modelo da tabela do Cliente

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import loja.Pedido;

public class ModeloPedido extends AbstractTableModel {
	private ArrayList<Pedido> lista = new ArrayList<Pedido>();
	
	@Override
	public int getColumnCount() {
		return 5;
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
			return p.getId_cliente();
		case 2:
			return p.getTotal();
		case 3:
			return p.getValor_pago();	
		case 4:
			return p.getTroco();
		default:
			return "Erro";
		}
	}

	public void incluir (Pedido p){
		lista.add(p);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Id Cliente";
		case 2:
			return "Total";
		case 3:
			return "Valor pago";
		case 4:
			return "Troco";
		default:
			return "Erro";
		}
	}
}

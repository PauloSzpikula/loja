package Telas;

//Autor: Paulo Szpikula, 12/11/2015 20:46
//Descrição: Modelo da tabela do Produto

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import loja.Produto;

public class ModeloProduto extends AbstractTableModel {
	private ArrayList<Produto> lista = new ArrayList<Produto>();
	
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

		Produto p = lista.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getCodigoDeBarras();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMargemDeLucro();
		default:
			return "Erro";
		}
	}

	public void incluir (Produto p){
		lista.add(p);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Código de Barras";
		case 2:
			return "Categoria";
		case 3:
			return "Descrição";
		case 4:
			return "Unidade";
		case 5:
			return "Custo";
		case 6:
			return "Margem de Lucro";
		default:
			return "Erro";
		}
	}
}

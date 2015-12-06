package relatorios;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReport {

	private String arq = "C:\\Users\\Ti\\Desktop\\TADS\\workspace\\trabalho4bimestre\\loja\\RelatorioClientes.jasper";

	public SimpleReport() {
		
		TableModel tableModel = getTableModel();
		
		JasperPrint jp = null;
		try {
			
			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("empresa", "Petrobras");
	//		map.put("telefone", "123pim567pim");
			
			jp = JasperFillManager.fillReport(arq, map,new JRTableModelDataSource(tableModel));
			JasperViewer jasperViewer = new JasperViewer(jp);
			
			jasperViewer.setBounds(50, 50, 320, 240);
			jasperViewer.setLocationRelativeTo(null);
			jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
			jasperViewer.setVisible(true);
			
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	private TableModel getTableModel() {
		String[] columnNames = { "Id", "Nome", "Departamento", "Email" };
		
		String[][] data = {
				{ "1", "Hugo", "Financeiro", "hugod@univel.br" },
				{ "2", "José", "Comercial",  "josed@univel.br" },
				{ "3", "Luiz", "Contábil",   "luizd@univel.br" }
		};
		
		return new DefaultTableModel(data, columnNames);
	}

	public static void main(String[] args) {
		new SimpleReport();
	}
}
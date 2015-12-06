package relatorios;

import loja.Cliente;

import java.io.InputStream;
import java.util.ArrayList;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	
	private String arq = "C:\\Users\\Ti\\Desktop\\TADS\\workspace\\trabalho4bimestre\\loja\\RelatorioClientes.jasper";

	
	public void gerarRelatorio(ArrayList<Cliente> lista) throws JRException {
		InputStream fonte = Relatorio.class.getResourceAsStream(arq);
		
		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
		JasperViewer.viewReport(print, false);
	}
}

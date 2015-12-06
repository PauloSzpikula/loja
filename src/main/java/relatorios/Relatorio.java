package relatorios;

import java.util.ArrayList;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import loja.Cliente;


public class Relatorio {
	
	private String arq = "C:\\Users\\Ti\\Desktop\\TADS\\workspace\\trabalho4bimestre\\loja\\cliente_teste_01.jasper";
	
	public void gerarRelatorio(ArrayList<Cliente> lista)  {
		
//		InputStream fonte = Relatorio.class.getResourceAsStream(arq);
//		InputStream fonte = Relatorio.class.getResourceAsStream(arq);
//		
//		JasperReport report = JasperCompileManager.compileReport(fonte);
//		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
//		JasperViewer.viewReport(print, false);
	}
}

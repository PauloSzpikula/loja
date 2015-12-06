package relatorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class SimpleReportJdbc {

	private String arq = "C:\\Users\\Ti\\Desktop\\TADS\\workspace\\trabalho4bimestre\\loja\\RelatorioClientes.jasper";

	public SimpleReportJdbc() {

		JasperPrint jasperPrint = null;
		try {
			Connection con = getConnection();
			jasperPrint = JasperFillManager.fillReport(arq, null,con);
			
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();
			System.out.println("erro no jasper");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erro no banco");
		}
	}

	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:h2:~/trabalho4Bimestre", "sa", "sa");
		return con;
	}

	public static void main(String[] args) {
		new SimpleReportJdbc();
	}
}
package tuanlm.fpt.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tuanlm.fpt.spring.entity.Employee;

@Service
public class ReportService {
	
	public byte[] generatePDFReport() throws JRException, IOException {
		JasperReport jasperReport = JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:reports/demo.jrxml").getAbsolutePath());
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(0, "Lê Minh Tuấn", 1, "Bình Dương", (float) 100.5));
		list.add(new Employee(1, "Lê Thanh Tú", 1, "TP.HCM", (float) 10.5));
		list.add(new Employee(2, "Văn Thành Phương Đạt", 1, "Tây Ninh", (float) 90.5));
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "TuanLM15"); 
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
}

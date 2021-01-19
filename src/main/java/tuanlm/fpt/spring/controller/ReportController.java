/**
 * 
 */
package tuanlm.fpt.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tuanlm.fpt.spring.service.ReportService;

/**
 * @author Tuan
 *
 */
@RestController
@RequestMapping("api/v1/report")
@AllArgsConstructor
public class ReportController {
	private ReportService reportService;
	
	@GetMapping("pdf-report")
	public ResponseEntity<byte[]> getPDFReport() {
		try {
			return new ResponseEntity<byte[]>(reportService.generatePDFReport(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}

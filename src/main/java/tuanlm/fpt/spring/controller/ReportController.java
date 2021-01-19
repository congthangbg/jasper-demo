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
import lombok.NoArgsConstructor;
import tuanlm.fpt.spring.service.ReportService;

/**
 * @author Tuan
 *
 */
@RestController
@RequestMapping("api/v1/report")
@AllArgsConstructor
@NoArgsConstructor
public class ReportController {
	ReportService reportService;
	
	@GetMapping("pdf-report")
	public ResponseEntity<byte[]> getPDFReport() {
		return new ResponseEntity<byte[]>(HttpStatus.OK);
	}
}

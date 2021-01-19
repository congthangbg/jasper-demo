package tuanlm.fpt.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	/** The id. */
	private int id;
	
	/** The name. */
	private String name;
	
	/** The gender. */
	private int gender;
	
	/** The address. */
	private String address;
	
	/** The salary. */
	private float salary;
}

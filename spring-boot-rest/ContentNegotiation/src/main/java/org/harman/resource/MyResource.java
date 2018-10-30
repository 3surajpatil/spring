package org.harman.resource;

import org.harman.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyResource {

	
	@GetMapping(value="/")
	public String welcome()
	{
		return "Welcome...!";
	}
	

	
	@RequestMapping(value="/getEmployee/{id}/",
	method=RequestMethod.GET,produces={"application/json","application/xml"})	
	public Employee getEmployee(@PathVariable int id)
	{
		System.out.println("id is:="+id);
		
		Employee e= new Employee();
		
		e.setName("suraj");
		e.setId(10);
		e.setSalary(7657);
		
		return e;			
	}
	
	
	
}



package in.tcampus;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.tcampus.model.Student;
import in.tcampus.service.StudentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
       
    	try {
			ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application-context.xml");
			StudentService studentService=(StudentService)applicationContext.getBean("studentService");
				
			//create a student 
			
			Student student1=new Student(1,"Suraj","Pune");			
			studentService.saveStudentDetails(student1);			
			
			System.out.println("Student details Saved Successfully...!");
		
			System.out.println(studentService.getAllStudents());
							
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	       	
    	
    }
}

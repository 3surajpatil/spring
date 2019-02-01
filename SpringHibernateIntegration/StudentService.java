package in.tcampus.service;

import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.tcampus.model.Student;


public class StudentService {
	
	HibernateTemplate hibernateTemplate;


	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}



	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveStudentDetails(Student s)
	{	SessionFactory sessionFactory=hibernateTemplate.getSessionFactory();
		Transaction tx=sessionFactory.openSession().beginTransaction();
		System.out.println(s.toString());
		hibernateTemplate.save(s);		
		tx.commit();
		
	}
	
	
	public  List <Student> getAllStudents() {
		
		return hibernateTemplate.loadAll(Student.class);
	}
	
	
}

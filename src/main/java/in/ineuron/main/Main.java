package in.ineuron.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		int id = 18;
		Configuration configuration = new Configuration(); // By default it searches in hibernate.properties
		
		configuration.addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Student student = session.get(Student.class, id);
		if(student != null) {
			System.out.println("Before updation in the table :: ");
			System.out.println(student);
			System.out.println("Please enter any key to continue :: ");
			System.in.read(); // go and make changes in the database
			session.refresh(student);
			System.out.println("After updation in the table :: ");
			System.out.println(student);
		} else {
			System.out.println("Record is not available for the given id");
		}
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
		
	}

}

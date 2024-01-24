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
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///Linux");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "Admin@123");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.format_sql", "true");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		
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

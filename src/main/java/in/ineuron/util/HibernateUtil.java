package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	private HibernateUtil() {}
	static {
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
	}
	
	public static Session getSession() {
		if(session == null) 
			 session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession() {
		if(session != null)
			session.close();
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null) 
			sessionFactory.close();
		
	}
}

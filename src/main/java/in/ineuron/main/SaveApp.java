package in.ineuron.main;

import java.io.IOException;
import org.hibernate.Session;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class SaveApp {
	public static void main(String[] args) throws IOException {
		Session session = null;
		int id = 18;
		
		session = HibernateUtil.getSession();
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


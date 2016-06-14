package springmvcmvn;

import java.util.List;

import springmvcmvn.dao.StudentDAO;
import springmvcmvn.dao.StudentDAOImpl;
import springmvcmvn.model.Student;

public class Test {
	
	StudentDAO studentDAO = new StudentDAOImpl();
	
	@org.junit.Test
	public void getPath() {
		System.out.println(ClassLoader.getSystemClassLoader().getResource("././"));
	}
	
	@org.junit.Test
	public void add() {
		Student s1 = new Student(1, "liuyan", 20, "123");
		Student s2 = new Student(1, "asd", 21, "123");
		Student s3 = new Student(1, "zxc", 22, "123");
		Student s4 = new Student(1, "123", 22, "123");
		Student s5 = new Student(1, "lihuan", 22, "123");
		studentDAO.save(s5);
	}
	
	@org.junit.Test
	public void getAll() {
		List<Student> students = studentDAO.getAllStudents();
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}
}

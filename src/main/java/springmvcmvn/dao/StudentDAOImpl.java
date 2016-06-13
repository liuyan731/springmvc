package springmvcmvn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import springmvcmvn.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		Student s1 = new Student(1, "liuyan", 20);
		Student s2 = new Student(1, "asd", 21);
		Student s3 = new Student(1, "zxc", 22);
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		return students;	//模拟从数据库中取数据
	}
	
}

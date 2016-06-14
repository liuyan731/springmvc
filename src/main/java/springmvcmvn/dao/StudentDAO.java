package springmvcmvn.dao;

import java.util.List;

import springmvcmvn.model.Student;

public interface StudentDAO {
	
	public boolean save(Student student);
	
	public List<Student> getAllStudents();
}

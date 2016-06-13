package springmvcmvn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvcmvn.dao.StudentDAO;
import springmvcmvn.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();  // 模拟处理业务逻辑
	}
}

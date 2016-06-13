package springmvcmvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvcmvn.model.Student;
import springmvcmvn.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/getAll.do")	// http://localhost:8080/springmvcmvn/student/getAll.do
	public String getAll(Model model) {
		List<Student> students = studentService.getAllStudents();	// 模拟与视图相互传数据
		model.addAttribute("students", students);
		return "students";
	}
}

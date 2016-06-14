package springmvcmvn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvcmvn.model.Student;
import springmvcmvn.service.StudentService;

@Controller
@RequestMapping(value = "/student.do")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * 直接获取name和passwd（spring会自动将表单参数注入到方法参数，保证属性名一样就可以）
	 */
	@RequestMapping(params = "method=login1") // http://localhost:8080/springmvcmvn/student.do?method=login1
	public String login(String name, String passwd, Model model) {
		List<Student> students = studentService.getAllStudents();
		for (Student student2 : students) {
			if (student2.getName().equals(name) && student2.getPasswd().equals(passwd)) {
				System.out.println("登陆成功！");
				model.addAttribute("success1", "success1");
				return "success";
			}
		}
		System.out.println("登录失败！");
		model.addAttribute("message1", "Failed1");
		return "login";
	}

	/**
	 * 使用HttpServletRequest获得name和passwd
	 */
	@RequestMapping(params = "method=login2") // http://localhost:8080/springmvcmvn/student.do?method=login2
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		List<Student> students = studentService.getAllStudents();
		for (Student student2 : students) {
			if (student2.getName().equals(name) && student2.getPasswd().equals(passwd)) {
				System.out.println("登陆成功！");
				model.addAttribute("success2", "success2");
				return "success";
			}
		}
		System.out.println("登录失败！");
		model.addAttribute("message2", "Failed2");
		return "login";
	}

	/**
	 * 自动注入bean，这里需要实体类有默认的构造函数
	 */
	@RequestMapping(params = "method=login3")
	public String login(Student student, Model model) {
		String name = student.getName();
		String passwd = student.getPasswd();
		List<Student> students = studentService.getAllStudents();
		for (Student student2 : students) {
			if (student2.getName().equals(name) && student2.getPasswd().equals(passwd)) {
				System.out.println("登陆成功！");
				model.addAttribute("success3", "success3");
				return "success";
			}
		}
		System.out.println("登录失败！");
		model.addAttribute("message3", "Failed3");
		return "login";
	}

	@RequestMapping(params = "method=getAll") // http://localhost:8080/springmvcmvn/student.do?method=getAll
	public String getAll(Model model) {
		List<Student> students = studentService.getAllStudents(); // 模拟与视图相互传数据
		model.addAttribute("students", students);
		return "students";
	}

//	@RequestMapping(params = "method=query")
//	@RequestMapping(params = "method=delete")
//	@RequestMapping(params = "method=edit")
	
	@RequestMapping(params = "method=add")
	public String add(Student student) {
		System.out.println(student.getName() + ":" + student.getAge() + ":" + student.getPasswd());
		return "success";
	}
}

package springmvcmvn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvcmvn.model.Student;
import springmvcmvn.service.StudentService;

@Controller		//@Controller @Repository @Service @Component����ע��һ��bean ��spring ��������
@RequestMapping(value = "/student.do") //ע��Ϊ������ָ�����Դ�����Щ URL ����
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * ֱ�ӻ�ȡname��passwd��spring���Զ���������ע�뵽������������֤������һ���Ϳ��ԣ��Զ�ƥ�����
	 */
	@RequestMapping(params = "method=login1") // http://localhost:8080/springmvcmvn/student.do?method=login1
	public String login(String name, String passwd, Model model, HttpServletRequest request) {
		List<Student> students = studentService.getAllStudents();
		HttpSession session = request.getSession();
		for (Student student2 : students) {
			if (student2.getName().equals(name) && student2.getPasswd().equals(passwd)) {
				System.out.println("��½�ɹ���");
				model.addAttribute("success1", "success1");
				session.setAttribute("currentUser", student2);
				return "redirect:student.do?method=getAll"; // �ض���getAll
			}
		}
		System.out.println("��¼ʧ�ܣ�");
		model.addAttribute("message1", "Failed1");
		return "login";
	}

	/**
	 * ʹ��HttpServletRequest���name��passwd
	 */
	@RequestMapping(params = "method=login2") // http://localhost:8080/springmvcmvn/student.do?method=login2
	public String login(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		List<Student> students = studentService.getAllStudents();
		for (Student student2 : students) {
			if (student2.getName().equals(name) && student2.getPasswd().equals(passwd)) {
				System.out.println("��½�ɹ���");
				model.addAttribute("success2", "success2");
				return "success";
			}
		}
		System.out.println("��¼ʧ�ܣ�");
		model.addAttribute("message2", "Failed2");
		return "login";
	}

	/**
	 * �Զ�ע��bean��������Ҫʵ������Ĭ�ϵĹ��캯�����Զ�װ��
	 */
	@RequestMapping(params = "method=login3")
	public String login(Student student, Model model) {
		String name = student.getName();
		String passwd = student.getPasswd();
		List<Student> students = studentService.getAllStudents();
		for (Student student2 : students) {
			if (student2.getName().equals(name) && student2.getPasswd().equals(passwd)) {
				System.out.println("��½�ɹ���");
				model.addAttribute("success3", "success3");
				return "success";
			}
		}
		System.out.println("��¼ʧ�ܣ�");
		model.addAttribute("message3", "Failed3");
		return "login";
	}

	@RequestMapping(params = "method=getAll") // http://localhost:8080/springmvcmvn/student.do?method=getAll
	public String getAll(Model model) {
		List<Student> students = studentService.getAllStudents(); // ģ������ͼ�໥������
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping(params = "method=add")
	public String add(Student student, Model model) {
		List<Student> students = studentService.getAllStudents();
		for (Student student2 : students) {
			if(student2.getName().equals(student.getName())) {
				model.addAttribute("addFailed","�û����Ѵ��ڣ����ʧ�ܣ����������");
				return "add";
			}
		}
		
		boolean ret = studentService.addStudent(student);
		if(ret == false) {
			model.addAttribute("addFailed", "���ʧ�ܣ����������");
			return "add";
		} else {
			System.out.println("��ӳɹ�: " + student.getId() + ":" + student.getName() + ":" + student.getAge() + ":"
					+ student.getPasswd());
			return "success";
		}
	}
	
	// @RequestMapping(params = "method=query")
	// @RequestMapping(params = "method=delete")
	// @RequestMapping(params = "method=edit")
}

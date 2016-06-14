package springmvcmvn.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import liuyan.util.MyObjectOutputStream;
import springmvcmvn.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// public List<Student> getAllStudents() {
	// List<Student> students = new ArrayList<Student>();
	// Student s1 = new Student(1, "liuyan", 20, "123");
	// Student s2 = new Student(1, "asd", 21, "123");
	// Student s3 = new Student(1, "zxc", 22, "123");
	//
	// students.add(s1);
	// students.add(s2);
	// students.add(s3);
	//
	// return students; // 模拟从数据库中取数据
	// }

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			// 路径问题：统一操作绝对路径（F:/workspaceStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springmvcmvn/WEB-INF/classes/data）的数据文件
			// 但是当tomcat中的data被清除时，data的初始数据为项目中的/springmvcmvn/src/main/resources/data
			FileInputStream fis = new FileInputStream(
					"F:/workspaceStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springmvcmvn/WEB-INF/classes/data");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				Object ob = ois.readObject();
				if (ob != null) {
					Student s = (Student) ob;
					students.add(s);
				}
			}
		} catch (EOFException e) { // 使用while+Exception来读取所有的对象
			System.out.println("类对象已完全读入");
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public boolean save(Student student) {
		try {
			File file = new File(
					"F:/workspaceStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springmvcmvn/WEB-INF/classes/data");
			FileOutputStream fos = new FileOutputStream(file, true);
			// 处理对象追加出现的读取错误，使用MyObjectOutputStream类
			MyObjectOutputStream oos = MyObjectOutputStream.newInstance(file, fos);
			oos.writeObject(student);
			oos.close();
			fos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}

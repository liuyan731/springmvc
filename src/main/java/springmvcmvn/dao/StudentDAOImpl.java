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
	// return students; // ģ������ݿ���ȡ����
	// }

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			// ·�����⣺ͳһ��������·����F:/workspaceStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/springmvcmvn/WEB-INF/classes/data���������ļ�
			// ���ǵ�tomcat�е�data�����ʱ��data�ĳ�ʼ����Ϊ��Ŀ�е�/springmvcmvn/src/main/resources/data
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
		} catch (EOFException e) { // ʹ��while+Exception����ȡ���еĶ���
			System.out.println("���������ȫ����");
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
			// �������׷�ӳ��ֵĶ�ȡ����ʹ��MyObjectOutputStream��
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

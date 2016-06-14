package springmvcmvn.model;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private String passwd;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name, int age, String passwd) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.passwd = passwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}

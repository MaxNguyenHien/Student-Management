package Model;

import java.io.File;
import java.util.ArrayList;

public class StudentManagementModel {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String choose = "";
	private String tenFile = "";

	public StudentManagementModel() {
	}

	public StudentManagementModel(ArrayList<Student> studentList) {
		this.studentList = studentList;
		this.choose = "";
		this.tenFile = "";
	}
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public void insert(Student student) {
		this.studentList.add(student);
	}
	public void insertBaseOnIndex(int n,Student student) {
		this.studentList.add(n,student);
	}
	
	
	public void delete(Student student) {
		this.studentList.remove(student);
	}
	public void deleteBaseOnIndex(int n) {
		this.studentList.remove(n);
	}
	
	public void update(Student student) {
		this.studentList.remove(student);
		this.studentList.add(student);
	}

	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}
	
}

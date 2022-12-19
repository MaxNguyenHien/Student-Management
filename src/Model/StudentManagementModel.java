package Model;

import java.util.ArrayList;

public class StudentManagementModel {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String choose = "";
	
	public StudentManagementModel() {
	}

	public StudentManagementModel(ArrayList<Student> studentList) {
		this.studentList = studentList;
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
	
	public void delete(Student student) {
		this.studentList.remove(student);
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
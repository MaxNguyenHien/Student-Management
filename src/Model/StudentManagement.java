package Model;

import java.util.ArrayList;

public class StudentManagement {
	private ArrayList<Student> studentList;

	public StudentManagement() {
	}

	public StudentManagement(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Student> getListStudent() {
		return studentList;
	}

	public void setListStudent(ArrayList<Student> studentList) {
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

}

package Model;

import java.util.ArrayList;

public class StudentManagement {
	private ArrayList<Student> listStudent;

	public StudentManagement() {
	}

	public StudentManagement(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	public void insert(Student student) {
		this.listStudent.add(student);
	}
	
	public void delete(Student student) {
		this.listStudent.remove(student);
	}
	
	public void update(Student student) {
		this.listStudent.remove(student);
		this.listStudent.add(student);
	}


	
	
	
}

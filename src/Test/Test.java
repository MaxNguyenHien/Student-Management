package Test;

import java.sql.Date;

import javax.swing.UIManager;

import DAO.StudentDAO;
import Model.Province;
import Model.Student;
import View.StudentManagementView;

public class Test {

	public static void main(String[] args) {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StudentManagementView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		Province prv = new Province();
//		prv.setProvinceName("Quang Tri");
//		
//		Student std = new Student(1, "Nguyen Hien", prv , Date.valueOf("2000-02-02"), true, 3, 4, 5);
//		
//		StudentDAO.getInstance().insert(std);

	}

}

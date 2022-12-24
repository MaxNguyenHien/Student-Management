package Test;

import javax.swing.UIManager;

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

	}

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Model.Province;
import Model.Student;
import View.StudentManagementView;

public class StudentManagementController implements Action {
	private StudentManagementView SMV;
	

	public StudentManagementController(StudentManagementView SMV) {
		this.SMV = SMV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JOptionPane.showMessageDialog(SMV, src);
		
		if(src.equals("Insert")) {
			this.SMV.deleteForm();
			this.SMV.studentManagementModel.setChoose("Insert");
		} else if(src.equals("Save")) {
			try {
				int ID = Integer.valueOf(this.SMV.textField_addID.getText());
				String name = this.SMV.textField_addName.getText();
				int homeTown = this.SMV.comboBox_addHomeTown.getSelectedIndex();
				Province province = Province.getProvinceByCode(homeTown);
				Date dateOfBirth =new Date (this.SMV.textField_addDate.getText());
				boolean gender = true;
				String chooseGender = this.SMV.btn_Gender.getSelection()+"";
				if(chooseGender.equals("Male")) {
					gender = true;
				}else if(chooseGender.equals("Female")) gender = false;
				float score1 = Float.valueOf(this.SMV.textField_Score1.getText());
				float score2 = Float.valueOf(this.SMV.textField_Score2.getText());
				float score3 = Float.valueOf(this.SMV.textField_Score3.getText());
				Student std = new Student(ID,name,province,dateOfBirth,gender,score1,score2,score3);
				if(this.SMV.studentManagementModel.getChoose().equals("Insert") || this.SMV.studentManagementModel.getChoose().equals("")) {
					this.SMV.insertStudent(std);
				}else if (this.SMV.studentManagementModel.getChoose().equals("Update")){
					this.SMV.updateStudent();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	

	
}

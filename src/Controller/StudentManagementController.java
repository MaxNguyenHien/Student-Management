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
		//JOptionPane.showMessageDialog(SMV, src);
		
		if(src.equals("Insert")) {
			this.SMV.deleteForm();
			this.SMV.studentManagementModel.setChoose("Insert");
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------  
		} else if(src.equals("Update")) {
			this.SMV.studentManagementModel.setChoose("Update");
			this.SMV.showStudentInformation();
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------  
		} else if(src.equals("Save")) {
			try {
				
				if(this.SMV.studentManagementModel.getChoose().equals("Insert") || this.SMV.studentManagementModel.getChoose().equals("")) {
					this.SMV.insertStudent();
				}else if (this.SMV.studentManagementModel.getChoose().equals("Update")){
					this.SMV.updateStudent();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			this.SMV.deleteForm();
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------  
		} else if(src.equals("Discard")) {
			this.SMV.deleteForm();
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------            
			//-------------------------------------------------------------------------------------------  
		} else if(src.equals("Delete")) {
			int result = JOptionPane.showConfirmDialog(this.SMV,
                    "Delete this student?",
                    "ConFirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            	this.SMV.deleteStudentInformation();
            }else if (result == JOptionPane.NO_OPTION){   
            }        
          //-------------------------------------------------------------------------------------------            
          //-------------------------------------------------------------------------------------------            
          //-------------------------------------------------------------------------------------------              
        } else if(src.equals("Search")) {
        	this.SMV.searchStudent();
        	this.SMV.studentManagementModel.setChoose("Search");
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------          	
        } else if(src.equals("Cancel")) {
        	if(this.SMV.studentManagementModel.getChoose().equals("Search")) {
        		this.SMV.reloadTable();
        	}
        	this.SMV.studentManagementModel.setChoose("Cancel");
        	//-------------------------------------------------------------------------------------------            
    		//-------------------------------------------------------------------------------------------            
    		//-------------------------------------------------------------------------------------------
        }  else if(src.equals("Open")) {
        	this.SMV.openFileProcess();
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------          	
        } else if(src.equals("Save/Save as")) {
        	this.SMV.saveFileProcess();
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------          	
        } else if(src.equals("Exit")) {
        	this.SMV.exitWindow();
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------          	
        } else if(src.equals("About me")) {
        	this.SMV.showAboutMe();
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------            
        	//-------------------------------------------------------------------------------------------          	
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

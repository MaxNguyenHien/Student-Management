package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Province;
import Model.Student;
import Model.StudentManagementModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.StudentManagementController;

import javax.swing.JRadioButton;

public class StudentManagementView extends JFrame {

	private JPanel contentPane;
	public StudentManagementModel studentManagementModel;
	public JTextField textField_ID;
	private DefaultTableModel model; 
	public JTable table;
	public JTextField textField_addID;
	public JTextField textField_addName;
	public JTextField textField_addDate;
	public JTextField textField_Score1;
	public JTextField textField_Score2;
	public JTextField textField_Score3;
	public ButtonGroup btn_Gender;
	public JComboBox comboBox_HomeTown;
	public JComboBox comboBox_addHomeTown;
	public JRadioButton rdbtn_addMale;
	public JRadioButton rdbtn_addFemale;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementView frame = new StudentManagementView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentManagementView() {
		this.studentManagementModel = new StudentManagementModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 756);
		
		Action action = new StudentManagementController(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_File = new JMenu("File");
		menu_File.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menu_File);
		
		JMenuItem menu_Open = new JMenuItem("Open");
		menu_Open.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menu_Open);
		
		JMenuItem menu_Close = new JMenuItem("Close");
		menu_Close.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menu_Close);
		
		JSeparator separator = new JSeparator();
		menu_File.add(separator);
		
		JMenuItem menu_Exit = new JMenuItem("Exit");
		menu_Exit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menu_Exit);
		
		JMenu menu_About = new JMenu("About");
		menu_About.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menu_About);
		
		JMenuItem menu_AboutMe = new JMenuItem("About me");
		menu_AboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_About.add(menu_AboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_HomeTown = new JLabel("Home town");
		lbl_HomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_HomeTown.setBounds(26, 36, 113, 31);
		contentPane.add(lbl_HomeTown);
		
		JLabel lbl_ID = new JLabel("ID");
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ID.setBounds(382, 38, 32, 26);
		contentPane.add(lbl_ID);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_ID.setBounds(415, 29, 152, 45);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		JButton btn_Search = new JButton("Search");
		btn_Search.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Search.setBounds(624, 29, 95, 45);
		contentPane.add(btn_Search);
		
		comboBox_HomeTown = new JComboBox();
		comboBox_HomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_HomeTown.setBounds(134, 29, 204, 45);
		ArrayList<Province> listProvince = Province.getProvinceList();
		for (Province province : listProvince) {
			comboBox_HomeTown.addItem(province.getProvinceName());
		}
		contentPane.add(comboBox_HomeTown);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 98, 883, 2);
		contentPane.add(separator_1);
		
		JLabel lbl_ListStudent = new JLabel("List Student");
		lbl_ListStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ListStudent.setBounds(26, 100, 113, 31);
		contentPane.add(lbl_ListStudent);
		
		table = new JTable() {
		public boolean isCellEditable(int row, int column) {                
            return false;
            };
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Home town", "Date", "Gender", "Score 1", "Score 2", "Score 3"
			}
		));
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 141, 863, 235);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(26, 395, 883, 2);
		contentPane.add(separator_1_1);
		
		JLabel lbl_StudentInformation = new JLabel("Student Information");
		lbl_StudentInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_StudentInformation.setBounds(26, 395, 187, 31);
		contentPane.add(lbl_StudentInformation);
		
		JLabel lbl_addID = new JLabel("ID");
		lbl_addID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addID.setBounds(26, 441, 32, 26);
		contentPane.add(lbl_addID);
		
		textField_addID = new JTextField();
		textField_addID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_addID.setColumns(10);
		textField_addID.setBounds(149, 436, 204, 31);
		contentPane.add(textField_addID);
		
		textField_addName = new JTextField();
		textField_addName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_addName.setColumns(10);
		textField_addName.setBounds(149, 479, 204, 31);
		contentPane.add(textField_addName);
		
		JLabel lbl_addName = new JLabel("Name");
		lbl_addName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addName.setBounds(26, 481, 86, 26);
		contentPane.add(lbl_addName);
		
		JLabel lbl_addHomeTown = new JLabel("Home town");
		lbl_addHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addHomeTown.setBounds(26, 526, 113, 31);
		contentPane.add(lbl_addHomeTown);
		
		comboBox_addHomeTown = new JComboBox();
		comboBox_addHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_addHomeTown.setBounds(149, 520, 204, 31);
		for (Province province : listProvince) {
			comboBox_addHomeTown.addItem(province.getProvinceName());
		}
		contentPane.add(comboBox_addHomeTown);
		
		JLabel lbl_addDate = new JLabel("Date");
		lbl_addDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addDate.setBounds(26, 569, 113, 26);
		contentPane.add(lbl_addDate);
		
		textField_addDate = new JTextField();
		textField_addDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_addDate.setColumns(10);
		textField_addDate.setBounds(149, 567, 204, 31);
		contentPane.add(textField_addDate);
		
		JLabel lbl_addGender = new JLabel("Gender");
		lbl_addGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addGender.setBounds(471, 441, 73, 26);
		contentPane.add(lbl_addGender);
		
		rdbtn_addMale = new JRadioButton("Male");
		rdbtn_addMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtn_addMale.setBounds(572, 444, 73, 21);
		contentPane.add(rdbtn_addMale);
		
		rdbtn_addFemale = new JRadioButton("Female");
		rdbtn_addFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtn_addFemale.setBounds(669, 444, 103, 21);
		contentPane.add(rdbtn_addFemale);
		
		btn_Gender = new ButtonGroup();
		btn_Gender.add(rdbtn_addMale);
		btn_Gender.add(rdbtn_addFemale);
		
		
		textField_Score1 = new JTextField();
		textField_Score1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Score1.setColumns(10);
		textField_Score1.setBounds(594, 481, 108, 31);
		contentPane.add(textField_Score1);
		
		textField_Score2 = new JTextField();
		textField_Score2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Score2.setColumns(10);
		textField_Score2.setBounds(594, 524, 108, 31);
		contentPane.add(textField_Score2);
		
		JLabel lbl_addScore2 = new JLabel("Score 2");
		lbl_addScore2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addScore2.setBounds(471, 526, 86, 26);
		contentPane.add(lbl_addScore2);
		
		JLabel lbl_addScore1 = new JLabel("Score 1");
		lbl_addScore1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addScore1.setBounds(471, 486, 73, 26);
		contentPane.add(lbl_addScore1);
		
		textField_Score3 = new JTextField();
		textField_Score3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Score3.setColumns(10);
		textField_Score3.setBounds(594, 565, 108, 31);
		contentPane.add(textField_Score3);
		
		JLabel lbl_addScore3 = new JLabel("Score 3");
		lbl_addScore3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addScore3.setBounds(471, 567, 67, 26);
		contentPane.add(lbl_addScore3);
		
		JButton btn_Insert = new JButton("Insert");
		btn_Insert.addActionListener(action);
		btn_Insert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Insert.setBounds(36, 624, 133, 45);
		contentPane.add(btn_Insert);
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.addActionListener(action);
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Delete.setBounds(209, 624, 133, 45);
		contentPane.add(btn_Delete);
		
		JButton btn_Update = new JButton("Update");
		btn_Update.addActionListener(action);
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Update.setBounds(382, 624, 133, 45);
		contentPane.add(btn_Update);
		
		JButton btn_Save = new JButton("Save");
		btn_Save.addActionListener(action);
		btn_Save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Save.setBounds(555, 624, 133, 45);
		contentPane.add(btn_Save);
		
		JButton btn_Discard = new JButton("Discard");
		btn_Discard.addActionListener(action);
		btn_Discard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Discard.setBounds(733, 624, 133, 45);
		contentPane.add(btn_Discard);
		
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(26, 612, 883, 2);
		contentPane.add(separator_1_2);
		
		JButton btn_CancelSearch = new JButton("Cancel");
		btn_CancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_CancelSearch.setBounds(729, 29, 95, 45);
		contentPane.add(btn_CancelSearch);
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void deleteForm() {
		this.textField_addID.setText("");
		this.textField_addName.setText("");
		this.textField_addDate.setText("");
		this.textField_Score1.setText("");
		this.textField_Score2.setText("");
		this.textField_Score3.setText("");
		this.comboBox_HomeTown.setSelectedItem("--Choose province--");
		this.comboBox_addHomeTown.setSelectedItem("--Choose province--");
		this.btn_Gender.clearSelection();
		
		
	}

	public void insertStudent(Student std) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		this.studentManagementModel.insert(std);
		model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] {
				std.getCode()+"",
				std.getName(),
				std.getHomeTown().getProvinceName(),
				df.format(std.getDateOfBirth()),
				(std.isGender()?"Male":"Female"),
				std.getScore1()+"",
				std.getScore2()+"",
				std.getScore3()+"",
		});	
	}

	public void updateStudent(Student std) {
		int row = table.getSelectedRow();
		this.studentManagementModel.deleteBaseOnIndex(row);
		studentManagementModel.insertBaseOnIndex(row,std);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		model = (DefaultTableModel) table.getModel();
		
		model.setValueAt(std.getCode(),row,0);
		model.setValueAt(std.getName(),row,1);
		model.setValueAt(std.getHomeTown().getProvinceName(),row,2);
		model.setValueAt(df.format(std.getDateOfBirth()),row,3);
		String gender;
		if(std.isGender()==true) {
			gender = "Male";
		}else gender = "Female";
		model.setValueAt(std.getScore1(),row,5);
		model.setValueAt(std.getScore2(),row,6);
		model.setValueAt(std.getScore3(),row,7);
		
		
	}

	public void showStudentInformation() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		textField_addID.setText(model.getValueAt(row, 0)+"");
		textField_addName.setText(model.getValueAt(row, 1)+"");
		comboBox_addHomeTown.setSelectedItem(model.getValueAt(row, 2));
		textField_addDate.setText(model.getValueAt(row, 3)+"");
		String gender = model.getValueAt(row, 4)+"";
		if(gender.equals("Male")) {
			rdbtn_addMale.setSelected(true);
		}else rdbtn_addFemale.setSelected(true);
		textField_Score1.setText(model.getValueAt(row, 5)+"");
		textField_Score2.setText(model.getValueAt(row, 6)+"");
		textField_Score3.setText(model.getValueAt(row, 7)+"");
		
		
		
	}

	public void deleteStudentInformation() {
		int row = table.getSelectedRow();
		this.studentManagementModel.deleteBaseOnIndex(row);
		model.removeRow(row);
		
	}
}

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.border.BevelBorder;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
	private DefaultTableModel model2;
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
		menu_File.addActionListener(action);
		menu_File.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menu_File);

		JMenuItem menu_Open = new JMenuItem("Open");
		menu_Open.addActionListener(action);
		menu_Open.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menu_Open);

		JMenuItem menu_SaveAndSaveAs = new JMenuItem("Save/Save as");
		menu_SaveAndSaveAs.addActionListener(action);
		menu_SaveAndSaveAs.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menu_SaveAndSaveAs);

		JSeparator separator = new JSeparator();
		menu_File.add(separator);

		JMenuItem menu_Exit = new JMenuItem("Exit");
		menu_Exit.addActionListener(action);
		menu_Exit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menu_File.add(menu_Exit);

		JMenu menu_About = new JMenu("About");
		menu_About.addActionListener(action);
		menu_About.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menu_About);

		JMenuItem menu_AboutMe = new JMenuItem("About me");
		menu_AboutMe.addActionListener(action);
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
		btn_Search.addActionListener(action);
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
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Home town", "Date", "Gender", "Score 1", "Score 2", "Score 3" }));

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
		btn_CancelSearch.addActionListener(action);
		btn_CancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_CancelSearch.setBounds(729, 29, 95, 45);
		contentPane.add(btn_CancelSearch);

		this.setLocationRelativeTo(null);
		this.setResizable(false);
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

	public void insertStudent() {
		model = (DefaultTableModel) table.getModel();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		int ID = Integer.valueOf(this.textField_addID.getText());
		String name = this.textField_addName.getText();
		int homeTown = this.comboBox_addHomeTown.getSelectedIndex();
		Province province = Province.getProvinceByCode(homeTown);
		Date dateOfBirth = new Date(this.textField_addDate.getText());
		boolean gender = true;

		if (this.rdbtn_addMale.isSelected()) {
			gender = true;
		} else if (this.rdbtn_addFemale.isSelected())
			gender = false;
		float score1 = Float.valueOf(this.textField_Score1.getText());
		float score2 = Float.valueOf(this.textField_Score2.getText());
		float score3 = Float.valueOf(this.textField_Score3.getText());

		Student std = new Student(ID, name, province, dateOfBirth, gender, score1, score2, score3);
		this.studentManagementModel.insert(std);

		int iDTb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getCode();
		String nameTb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getName();
		String homeTownTb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getHomeTown().getProvinceName();
		String dateOfBirthTb = df.format(this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getDateOfBirth());
		String genderTb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).isGender() ? "Male" : "Female";
		float score1Tb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getScore1();
		float score2Tb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getScore1();
		float score3Tb = this.studentManagementModel.getStudentList()
				.get(this.studentManagementModel.getStudentList().size() - 1).getScore1();
		Object[] data = { iDTb, nameTb, homeTownTb, dateOfBirthTb, genderTb, score1Tb, score2Tb, score3Tb };
		model.addRow(data);

	}

	public void updateStudent() {
		model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		int ID = Integer.valueOf(this.textField_addID.getText());
		String name = this.textField_addName.getText();
		int homeTown = this.comboBox_addHomeTown.getSelectedIndex();
		Province province = Province.getProvinceByCode(homeTown);
		Date dateOfBirth = new Date(this.textField_addDate.getText());
		boolean gender = true;

		if (this.rdbtn_addMale.isSelected()) {
			gender = true;
		} else if (this.rdbtn_addFemale.isSelected())
			gender = false;
		float score1 = Float.valueOf(this.textField_Score1.getText());
		float score2 = Float.valueOf(this.textField_Score2.getText());
		float score3 = Float.valueOf(this.textField_Score3.getText());

		Student std = new Student(ID, name, province, dateOfBirth, gender, score1, score2, score3);
		this.studentManagementModel.deleteBaseOnIndex(row);
		this.studentManagementModel.insertBaseOnIndex(row, std);

		int iDTb = this.studentManagementModel.getStudentList().get(row).getCode();
		String nameTb = this.studentManagementModel.getStudentList().get(row).getName();
		String homeTownTb = this.studentManagementModel.getStudentList().get(row).getHomeTown().getProvinceName();
		String dateOfBirthTb = df.format(this.studentManagementModel.getStudentList().get(row).getDateOfBirth());
		String genderTb = this.studentManagementModel.getStudentList().get(row).isGender() ? "Male" : "Female";
		float score1Tb = this.studentManagementModel.getStudentList().get(row).getScore1();
		float score2Tb = this.studentManagementModel.getStudentList().get(row).getScore1();
		float score3Tb = this.studentManagementModel.getStudentList().get(row).getScore1();
		Object[] data = { iDTb, nameTb, homeTownTb, dateOfBirthTb, genderTb, score1Tb, score2Tb, score3Tb };

		model.removeRow(row);
		model.insertRow(row, data);

	}

	public void showStudentInformation() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		textField_addID.setText(model.getValueAt(row, 0) + "");
		textField_addName.setText(model.getValueAt(row, 1) + "");
		comboBox_addHomeTown.setSelectedItem(model.getValueAt(row, 2));
		textField_addDate.setText(model.getValueAt(row, 3) + "");
		String gender = model.getValueAt(row, 4) + "";
		if (gender.equals("Male")) {
			rdbtn_addMale.setSelected(true);
		} else
			rdbtn_addFemale.setSelected(true);
		textField_Score1.setText(model.getValueAt(row, 5) + "");
		textField_Score2.setText(model.getValueAt(row, 6) + "");
		textField_Score3.setText(model.getValueAt(row, 7) + "");

	}

	public void deleteStudentInformation() {
		int row = table.getSelectedRow();
		this.studentManagementModel.deleteBaseOnIndex(row);
		model.removeRow(row);

	}

	public void searchStudent() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		int homeTown = this.comboBox_HomeTown.getSelectedIndex();
		Province province = Province.getProvinceByCode(homeTown);
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		String iDT = this.textField_ID.getText();
		int iDi;
		if (!this.textField_ID.getText().equals("")) {
			iDi = Integer.valueOf(this.textField_ID.getText());
			for (int i = 0; i < this.studentManagementModel.getStudentList().size(); i++) {
				int iDTb = this.studentManagementModel.getStudentList().get(i).getCode();
				String nameTb = this.studentManagementModel.getStudentList().get(i).getName();
				String homeTownTb = this.studentManagementModel.getStudentList().get(i).getHomeTown().getProvinceName();
				String dateOfBirthTb = df.format(this.studentManagementModel.getStudentList().get(i).getDateOfBirth());
				String genderTb = this.studentManagementModel.getStudentList().get(i).isGender() ? "Male" : "Female";
				float score1Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
				float score2Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
				float score3Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
				if (this.comboBox_HomeTown.getSelectedIndex() == 0) {
					if ((iDi == this.studentManagementModel.getStudentList().get(i).getCode())) {
						Object[] data = { iDTb, nameTb, homeTownTb, dateOfBirthTb, genderTb, score1Tb, score2Tb,
								score3Tb };
						model.addRow(data);
					}
				} else if (this.comboBox_HomeTown.getSelectedIndex() != 0) {
					if ((this.studentManagementModel.getStudentList().get(i).getHomeTown()
							.getProvinceCode() == this.comboBox_HomeTown.getSelectedIndex())
							&& (iDi == this.studentManagementModel.getStudentList().get(i).getCode())) {
						Object[] data = { iDTb, nameTb, homeTownTb, dateOfBirthTb, genderTb, score1Tb, score2Tb,
								score3Tb };
						model.addRow(data);
					}
				}

			}
		} else {

			for (int i = 0; i < this.studentManagementModel.getStudentList().size(); i++) {
				if (this.studentManagementModel.getStudentList().get(i).getHomeTown()
						.getProvinceCode() == this.comboBox_HomeTown.getSelectedIndex()) {
					int iDTb = this.studentManagementModel.getStudentList().get(i).getCode();
					String nameTb = this.studentManagementModel.getStudentList().get(i).getName();
					String homeTownTb = this.studentManagementModel.getStudentList().get(i).getHomeTown()
							.getProvinceName();
					String dateOfBirthTb = df
							.format(this.studentManagementModel.getStudentList().get(i).getDateOfBirth());
					String genderTb = this.studentManagementModel.getStudentList().get(i).isGender() ? "Male"
							: "Female";
					float score1Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
					float score2Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
					float score3Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
					Object[] data = { iDTb, nameTb, homeTownTb, dateOfBirthTb, genderTb, score1Tb, score2Tb, score3Tb };
					model.addRow(data);
				}
			}

		}

	}

	public void reloadTable() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		for (int i = 0; i < this.studentManagementModel.getStudentList().size(); i++) {
			int iDTb = this.studentManagementModel.getStudentList().get(i).getCode();
			String nameTb = this.studentManagementModel.getStudentList().get(i).getName();
			String homeTownTb = this.studentManagementModel.getStudentList().get(i).getHomeTown().getProvinceName();
			String dateOfBirthTb = df.format(this.studentManagementModel.getStudentList().get(i).getDateOfBirth());
			String genderTb = this.studentManagementModel.getStudentList().get(i).isGender() ? "Male" : "Female";
			float score1Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
			float score2Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
			float score3Tb = this.studentManagementModel.getStudentList().get(i).getScore1();
			Object[] data = { iDTb, nameTb, homeTownTb, dateOfBirthTb, genderTb, score1Tb, score2Tb, score3Tb };
			model.addRow(data);
		}

	}

	public void showAboutMe() {
		JOptionPane.showMessageDialog(this, "Student Management App");

	}

	public void exitWindow() {
		int result = JOptionPane.showConfirmDialog(this, "Exit?", "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else if (result == JOptionPane.NO_OPTION) {

		}

	}

	public void saveFile(String tenFile) {
		try {
			this.studentManagementModel.setTenFile(tenFile);
			FileOutputStream fos = new FileOutputStream(tenFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student student : this.studentManagementModel.getStudentList()) {
				oos.writeObject(student);
			}
			oos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveFileProcess() {

		if (this.studentManagementModel.getTenFile().length() > 0) {
			saveFile(this.studentManagementModel.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}

	}

	public void openFile(String tenFile) {
		ArrayList<Student> listStudent = new ArrayList<Student>();
		try {
			this.studentManagementModel.setTenFile(tenFile);
			FileInputStream fis = new FileInputStream(tenFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student std = null;
			while ((std = (Student) ois.readObject()) != null) {
				listStudent.add(std);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.studentManagementModel.setStudentList(listStudent);
	}

	public void openFileProcess() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file.getAbsolutePath());
			reloadTable();
		}

	}

}

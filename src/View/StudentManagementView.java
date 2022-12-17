package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.StudentManagement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class StudentManagementView extends JFrame {

	private JPanel contentPane;
	private StudentManagement studentManagementModel;
	private JTextField textField_ID;
	private JTable table;
	private JTextField textField_addID;
	private JTextField textField_addName;
	private JTextField textField_addDate;
	private JTextField textField_Score1;
	private JTextField textField_Score2;
	private JTextField textField_Score3;
	
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
		this.studentManagementModel = new StudentManagement();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 756);
		
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
		lbl_HomeTown.setBounds(26, 37, 113, 31);
		contentPane.add(lbl_HomeTown);
		
		JLabel lbl_ID = new JLabel("ID");
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ID.setBounds(471, 39, 32, 26);
		contentPane.add(lbl_ID);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_ID.setBounds(514, 34, 187, 45);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		JButton btn_Find = new JButton("Find");
		btn_Find.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Find.setBounds(756, 34, 133, 45);
		contentPane.add(btn_Find);
		
		JComboBox comboBox_HomeTown = new JComboBox();
		comboBox_HomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_HomeTown.setBounds(149, 34, 258, 45);
		contentPane.add(comboBox_HomeTown);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 98, 883, 2);
		contentPane.add(separator_1);
		
		JLabel lbl_ListStudent = new JLabel("List Student");
		lbl_ListStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ListStudent.setBounds(26, 100, 113, 31);
		contentPane.add(lbl_ListStudent);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"NO", "ID", "Name", "Home town", "Date", "Gender", "Score 1", "Score 2", "Score 3"
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
		textField_addID.setBounds(149, 436, 187, 31);
		contentPane.add(textField_addID);
		
		textField_addName = new JTextField();
		textField_addName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_addName.setColumns(10);
		textField_addName.setBounds(149, 479, 187, 31);
		contentPane.add(textField_addName);
		
		JLabel lbl_addName = new JLabel("Name");
		lbl_addName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addName.setBounds(26, 481, 86, 26);
		contentPane.add(lbl_addName);
		
		JLabel lbl_addHomeTown = new JLabel("Home town");
		lbl_addHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addHomeTown.setBounds(26, 526, 113, 31);
		contentPane.add(lbl_addHomeTown);
		
		JComboBox comboBox_addHomeTown = new JComboBox();
		comboBox_addHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_addHomeTown.setBounds(149, 520, 187, 31);
		contentPane.add(comboBox_addHomeTown);
		
		JLabel lbl_addDate = new JLabel("Date");
		lbl_addDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addDate.setBounds(26, 569, 113, 26);
		contentPane.add(lbl_addDate);
		
		textField_addDate = new JTextField();
		textField_addDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_addDate.setColumns(10);
		textField_addDate.setBounds(149, 567, 187, 31);
		contentPane.add(textField_addDate);
		
		JLabel lbl_addGender = new JLabel("Gender");
		lbl_addGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addGender.setBounds(441, 441, 73, 26);
		contentPane.add(lbl_addGender);
		
		JRadioButton rdbtn_addMale = new JRadioButton("Male");
		rdbtn_addMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtn_addMale.setBounds(542, 444, 73, 21);
		contentPane.add(rdbtn_addMale);
		
		JRadioButton rdbtn_addFemale = new JRadioButton("Female");
		rdbtn_addFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtn_addFemale.setBounds(639, 444, 103, 21);
		contentPane.add(rdbtn_addFemale);
		
		textField_Score1 = new JTextField();
		textField_Score1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Score1.setColumns(10);
		textField_Score1.setBounds(564, 481, 108, 31);
		contentPane.add(textField_Score1);
		
		textField_Score2 = new JTextField();
		textField_Score2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Score2.setColumns(10);
		textField_Score2.setBounds(564, 524, 108, 31);
		contentPane.add(textField_Score2);
		
		JLabel lbl_addScore2 = new JLabel("Score 2");
		lbl_addScore2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addScore2.setBounds(441, 526, 86, 26);
		contentPane.add(lbl_addScore2);
		
		JLabel lbl_addScore1 = new JLabel("Score 1");
		lbl_addScore1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addScore1.setBounds(441, 486, 73, 26);
		contentPane.add(lbl_addScore1);
		
		textField_Score3 = new JTextField();
		textField_Score3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Score3.setColumns(10);
		textField_Score3.setBounds(564, 565, 108, 31);
		contentPane.add(textField_Score3);
		
		JLabel lbl_addScore3 = new JLabel("Score 3");
		lbl_addScore3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_addScore3.setBounds(441, 567, 67, 26);
		contentPane.add(lbl_addScore3);
		
		JButton btn_Insert = new JButton("Insert");
		btn_Insert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Insert.setBounds(36, 624, 133, 45);
		contentPane.add(btn_Insert);
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Delete.setBounds(209, 624, 133, 45);
		contentPane.add(btn_Delete);
		
		JButton btn_Update = new JButton("Update");
		btn_Update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Update.setBounds(382, 624, 133, 45);
		contentPane.add(btn_Update);
		
		JButton btn_Save = new JButton("Save");
		btn_Save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Save.setBounds(555, 624, 133, 45);
		contentPane.add(btn_Save);
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Cancel.setBounds(733, 624, 133, 45);
		contentPane.add(btn_Cancel);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(26, 612, 883, 2);
		contentPane.add(separator_1_2);
		
		
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

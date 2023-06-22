package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import Model.Student;

public class StudentDAO implements DAOInterface<Student>{
	
	private static final StudentDAO studentDAO = new StudentDAO();

	public static StudentDAO getInstance() {
		return studentDAO;
	}

	@Override
	public int insert(Student t) {
		
		int ketQua = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stdmanage", "root", "");
			
			String str = "INSERT INTO student (id, name, homeTown, dateOfBirth, gender, score1, score2, score3) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement pr = con.prepareStatement(str);
			
			pr.setInt(1, t.getCode());
			pr.setString(2, t.getName());
			pr.setString(3, t.getHomeTown().getProvinceName());
			java.util.Date utilDate = t.getDateOfBirth();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pr.setDate(4, sqlDate);
			pr.setBoolean(5, t.isGender());
			pr.setFloat(6, t.getScore1());
			pr.setFloat(7, t.getScore2());
			pr.setFloat(8, t.getScore3());
			
			ketQua = pr.executeUpdate();
			
			System.out.println("Co " + ketQua + " thay doi");
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Student t, int id) {
		
		int ketQua = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stdmanage", "root", "");
			
			String str = "UPDATE student SET id = ?, name = ?, homeTown = ?, dateOfBirth = ?, gender = ?, score1 = ?, score2 = ?, score3 = ?"
					+ " WHERE id = ?;";
			
			PreparedStatement pr = con.prepareStatement(str);
			
			pr.setInt(1, t.getCode());
			pr.setString(2, t.getName());
			pr.setString(3, t.getHomeTown().getProvinceName());
			java.util.Date utilDate = t.getDateOfBirth();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pr.setDate(4, sqlDate);
			pr.setBoolean(5, t.isGender());
			pr.setFloat(6, t.getScore1());
			pr.setFloat(7, t.getScore2());
			pr.setFloat(8, t.getScore3());
			pr.setInt(9, id);
			
			ketQua = pr.executeUpdate();
			System.out.println("Co " + ketQua + " thay doi");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return ketQua;
	}

	@Override
	public int delete(int id) {
		int ketQua = 0;
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stdmanage", "root", "");
			
			String str = "DELETE FROM student WHERE id = ?;";
			
			PreparedStatement pr = con.prepareStatement(str);
			pr.setInt(1, id);
			
			ketQua = pr.executeUpdate();
			System.out.println("Co " + ketQua + " thay doi");
			
			
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return ketQua;
	}

	@Override
	public int findById(Student t) {
		// TODO Auto-generated method stub
		return 0;
	}

}

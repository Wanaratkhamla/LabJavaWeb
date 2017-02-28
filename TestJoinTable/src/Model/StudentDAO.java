package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	private Connection con;
	
	public StudentDAO(){
		con = ConnectDatabase.getConnection();
	}
	
	public void InsertStudent(String sid , String password , int departmantID , String fname , String lname){
		String sql = "INSERT INTO student (SID,Password,departmantID,fname,lname) VALUE (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, password);
			ps.setInt(3, departmantID);
			ps.setString(4, fname);
			ps.setString(5, lname);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public Student login(String sid ,String password){
		Student student = new Student();
		String sql = "SELECT * FROM student WHERE SID = ? AND Password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				student.setCheck(true);
				student.setSID(result.getString("SID"));
				student.setPassword(result.getString("Password"));
				student.setDepartmentID(result.getInt("departmantID"));
				student.setFname(result.getString("fname"));
				student.setLname(result.getString("lname"));
			}else{
				student.setCheck(false);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return student;
	}
	
	public Student selectprofile(String sid){
		Student student = new Student();
		String sql = "SELECT * FROM student WHERE SID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sid);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				student.setSID(result.getString("SID"));
				student.setPassword(result.getString("Password"));
				student.setDepartmentID(result.getInt("departmantID"));
				student.setFname(result.getString("fname"));
				student.setLname(result.getString("lname"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return student;
	}
	
	public Department selectdepart(int did){
		Department depart = new Department();
		String sql = "SELECT * FROM departmant WHERE departmantID = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				depart.setDepartmantID(result.getInt("departmantID"));
				depart.setDepartmantName(result.getString("departmantName"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return depart;
	}
	
	public StudentDapart showProfile(String sid){
		StudentDapart studentdepart = new StudentDapart();
		Student student = selectprofile(sid);
		studentdepart.setSID(student.getSID());
		studentdepart.setFname(student.getFname());
		studentdepart.setLname(student.getLname());
		
		Department depart = selectdepart(student.getDepartmentID());
		studentdepart.setDepartmantName(depart.getDepartmantName());
		return studentdepart;
	}
	
}

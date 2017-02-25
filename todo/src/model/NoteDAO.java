package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NoteDAO {
	public ArrayList<Note> getAllTask() {
		ArrayList<Note> notes = new ArrayList<Note>();
		
	    try {
	    	// 1. ��Ŵ���� JDBC Driver
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        // 2. ��˹� URL ����Ѻ�Դ��͡Ѻ�ҹ������
	        String dbURL = "jdbc:mysql://localhost/mydb?characterEncoding=utf-8";
	        
	        // 3. ���ҧ Connection
	        Connection con = DriverManager.getConnection(dbURL, "root", "");
	        
	        // 4. ���ҧ Statement Object
	        Statement statement = con.createStatement();
	        
	        // 5. �觤���� SQL ��ѧ�ҹ������
	        ResultSet resultSet = statement.executeQuery("select * from note");

	        // 6. ��ҹ���Ѿ����ҹ�������觡�Ѻ
	        while (resultSet.next()) {
	            int nid = resultSet.getInt("nid");  
	            String task = resultSet.getString("task");
	            System.out.println(nid + "," + task);
	            Note note = new Note();
	            note.setNid(nid);
	            note.setTask(task);
	            notes.add(note);
	        }

	    } catch (ClassNotFoundException e) {
	        System.err.println("Error loading driver: " + e);
	    } catch (SQLException e) {
	        System.err.println("Error database connection: " + e);
	    }
		
		return notes;
	}
	
	public static void main(String aa[]) {
		NoteDAO notedao = new NoteDAO();
		notedao.getAllTask();
	}
}

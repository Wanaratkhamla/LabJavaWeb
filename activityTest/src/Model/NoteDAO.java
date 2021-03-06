package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.*;

public class NoteDAO {
	private Connection con;

	public NoteDAO() {
		con = ConnectDatabase.getConnection();
	}

	public void inserttask(String taskstring) {
		try {
			PreparedStatement pStatement = con
					.prepareStatement("INSERT INTO note (task) VALUES (?)");
			pStatement.setString(1, taskstring);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public void Deletetask(String nid) {
		String sql = "DELETE FROM note Where nid = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, nid);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
}

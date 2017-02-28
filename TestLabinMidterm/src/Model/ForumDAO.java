package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForumDAO {
	private Connection con;

	public ForumDAO() {
		con = ConnectDatabase.getConnection();
	}

	public void updatelove(int love, int fid) {
		String sql = "UPDATE forum SET love = ?  WHERE fid = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, love);
			ps.setInt(2, fid);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
			// TODO: handle exception
		}
	}

	public void insertforum(String detail, String author) {
		String sql = "INSERT INTO forum (detail,author,love,post_date) VALUE (?,?,0,now())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, detail);
			ps.setString(2, author);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}

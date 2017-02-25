package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class reportDB {
	private Connection con;
	public reportDB() {
		con = ConnectDatabase.getConnection();
	}
	//insertreportpawn
	//insertProduct
		public void insertreport(int PawnID, double reportpawnBuy, String reportpawnUserbuy, String reportpawnAdmin)
		{
			try {
				PreparedStatement pStatement = con.prepareStatement(
						"INSERT INTO reportpawn (PawnID, reportpawnDate, reportpawnBuy, reportpawnUserbuy, reportpawnAdmin) VALUES (?,NOW(),?,?,?)");
				pStatement.setInt(1, PawnID);
				pStatement.setDouble(2, reportpawnBuy);
				pStatement.setString(3, reportpawnUserbuy);
				pStatement.setString(4, reportpawnAdmin);
				pStatement.executeUpdate();
			} catch (SQLException e) {
				System.err.println("Error: " + e);
			}
		}
}
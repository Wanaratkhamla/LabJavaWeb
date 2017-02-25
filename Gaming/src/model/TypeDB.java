package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeDB {
	
	private Connection con;
	public TypeDB() {
		con = ConnectDatabase.getConnection();
	}
	
	public void insertType(String TypeName) {
		try {
			PreparedStatement pStatement = con
					.prepareStatement("INSERT INTO type (TypeName) VALUES (?)");
			pStatement.setString(1, TypeName);
			pStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public void editType(int TypeID,String TypeName) {		
		try {
			PreparedStatement pStatement = con.
					prepareStatement("UPDATE type SET TypeName = ? WHERE TypeID = ?");
			pStatement.setString(1,TypeName);
			pStatement.setInt(2,TypeID);
			pStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public void deleteType(int TypeID) {
		String sql = "DELETE FROM type Where TypeID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, TypeID);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
	
	public Type viewTypeById(int TypeID) {
		Type type = new Type();
		String sql = "SELECT * FROM type WHERE TypeID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, TypeID);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				type.setTypeID(result.getInt("TypeID"));
				type.setTypeName(result.getString("TypeName"));
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return type;
	}
	
	public ArrayList<Type> viewAllType() {
		ArrayList<Type> typeList = new ArrayList<Type>();
		String sql = "SELECT * FROM type";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Type type = new Type();
				type.setTypeID(result.getInt("TypeID"));
				type.setTypeName(result.getString("TypeName"));
				typeList.add(type);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return typeList;
	}
	
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDB {
	
	private Connection con;
	public BrandDB() {
		con = ConnectDatabase.getConnection();
	}
	
	public void insertBrand(String BrandName) {
		try {
			PreparedStatement pStatement = con
					.prepareStatement("INSERT INTO brand (BrandName) VALUES (?)");
			pStatement.setString(1, BrandName);
			pStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public void editBrand(int BrandID,String BrandName) {		
		try {
			PreparedStatement pStatement = con.
					prepareStatement("UPDATE brand SET BrandName = ? WHERE BrandID = ?");
			pStatement.setString(1,BrandName);
			pStatement.setInt(2,BrandID);
			pStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public void deleteBrandById(int BrandID) {
		String sql = "DELETE FROM brand Where BrandID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, BrandID);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
	
	public Brand viewBrandById(int BrandID) {
		Brand Brand = new Brand();
		String sql = "SELECT * FROM brand WHERE BrandID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, BrandID);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Brand.setBrandID(result.getInt("BrandID"));
				Brand.setBrandName(result.getString("BrandName"));
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return Brand;
	}
	
	public ArrayList<Brand> viewAllBrand() {
		ArrayList<Brand> BrandList = new ArrayList<Brand>();
		String sql = "SELECT * FROM brand";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Brand Brand = new Brand();
				Brand.setBrandID(result.getInt("BrandID"));
				Brand.setBrandName(result.getString("BrandName"));
				BrandList.add(Brand);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return BrandList;
	}
	
}

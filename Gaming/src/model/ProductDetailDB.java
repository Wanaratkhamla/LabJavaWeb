package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class ProductDetailDB {
	
	private Connection con;
	public ProductDetailDB() {
		con = ConnectDatabase.getConnection();
	}
	
	//แสดงสินค้าตาม Type
	public ArrayList<Product> viewProductByType(int TypeID) {
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM product WHERE TypeID = ?");
			statement.setInt(1, TypeID);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Product prod = new Product();
				prod.setProductID(result.getInt("ProductID"));
				prod.setBrandID(result.getInt("BrandID"));
				prod.setTypeID(result.getInt("TypeID"));
				prod.setProductName(result.getString("ProductName"));
				prod.setProductPrice(result.getDouble("ProductPrice"));
				prod.setProductNumber(result.getInt("ProductNumber"));
				prod.setProductDescription(result.getString("ProductDescription"));
				//while(result.next()) {
    	        	String imgDataBase64 = new String(Base64.getEncoder().encode(result.getBytes("Productphoto")));
    	        	String src = "data:image/jpg;base64,";
    	        	src = src.concat(imgDataBase64);
    	        	prod.setPhotosrc(src);
    	        //}
				prodList.add(prod);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return prodList;
	}
	//แสดงสินค้าตามBrand
	public ArrayList<Product> viewProductByBrand(int BrandID) {
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM product WHERE BrandID = ?");
			statement.setInt(1, BrandID);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Product prod = new Product();
				prod.setProductID(result.getInt("ProductID"));
				prod.setBrandID(result.getInt("BrandID"));
				prod.setTypeID(result.getInt("TypeID"));
				prod.setProductName(result.getString("ProductName"));
				prod.setProductPrice(result.getDouble("ProductPrice"));
				prod.setProductNumber(result.getInt("ProductNumber"));
				prod.setProductDescription(result.getString("ProductDescription"));
				//while(result.next()) {
    	        	String imgDataBase64 = new String(Base64.getEncoder().encode(result.getBytes("Productphoto")));
    	        	String src = "data:image/jpg;base64,";
    	        	src = src.concat(imgDataBase64);
    	        	prod.setPhotosrc(src);
    	        //}
				prodList.add(prod);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return prodList;
	}
	//แสดงสินค้าตามBrandและTypeที่เลือก
	public ArrayList<Product> viewProductAll(String search){
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM product WHERE ProductName OR ProductDescription LIKE ?");
			statement.setString(1,"%" + search + "%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Product prod = new Product();
				prod.setProductID(result.getInt("ProductID"));
				prod.setBrandID(result.getInt("BrandID"));
				prod.setTypeID(result.getInt("TypeID"));
				prod.setProductName(result.getString("ProductName"));
				prod.setProductPrice(result.getDouble("ProductPrice"));
				prod.setProductNumber(result.getInt("ProductNumber"));
				prod.setProductDescription(result.getString("ProductDescription"));
				//while(result.next()) {
    	        	String imgDataBase64 = new String(Base64.getEncoder().encode(result.getBytes("Productphoto")));
    	        	String src = "data:image/jpg;base64,";
    	        	src = src.concat(imgDataBase64);
    	        	prod.setPhotosrc(src);
    	        //}
				prodList.add(prod);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return prodList;
		
	}
	//
	public ArrayList<Product> viewProductByBrandAndType(String BrandId[] , String Typeid[]) {
		ArrayList<Product> prodList = new ArrayList<Product>();
		try {
			String query="SELECT * FROM product ";
			for (int i = 0 ; i < BrandId.length ; i++){
				if(i==0){
					query+= "WHERE BrandID = ? ";
				}
				query+= "AND WHERE BrandID = ? ";
			}
			for (int j = 0 ; j < Typeid.length ; j++){
				query+= "AND WHERE TypeID = ? ";
			}
			PreparedStatement statement = con.prepareStatement(query);
			int count = 0;
			for (int a = 0 ; a <= BrandId.length ; a++){
				statement.setString(a+1, BrandId[a]);
				count++;
			}
			for (int b = BrandId.length ; b <= Typeid.length + count ; b++){
				statement.setString(b, Typeid[b-BrandId.length]);
			}
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Product prod = new Product();
				prod.setProductID(result.getInt("ProductID"));
				prod.setBrandID(result.getInt("BrandID"));
				prod.setTypeID(result.getInt("TypeID"));
				prod.setProductName(result.getString("ProductName"));
				prod.setProductPrice(result.getDouble("ProductPrice"));
				prod.setProductNumber(result.getInt("ProductNumber"));
				prod.setProductDescription(result.getString("ProductDescription"));
				prodList.add(prod);
			}
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return prodList;
	}

}

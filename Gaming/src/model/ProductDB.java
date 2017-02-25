package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.annotation.MultipartConfig;

import com.mysql.jdbc.Blob;

public class ProductDB {
	
	private Connection con;
	public ProductDB() {
		con = ConnectDatabase.getConnection();
	}
	//ร�ย ร�ยพร�โ€�ร�ยจร�๏ฟฝproduct
	public void insertProduct(int BrandID,int TypeID,String ProductName,double ProductPrice,int ProductNumber,String ProductDescription,InputStream ProductPhoto) {
		try {
			PreparedStatement pStatement = con
					.prepareStatement("INSERT INTO product (BrandID, TypeID, ProductName, ProductPrice, ProductNumber, ProductDescription, ProductPhoto) "
							+ "VALUES (?,?,?,?,?,?,?)");
			pStatement.setInt(1, BrandID);
			pStatement.setInt(2, TypeID);
			pStatement.setString(3, ProductName);
			pStatement.setDouble(4, ProductPrice);
			pStatement.setInt(5, ProductNumber);
			pStatement.setString(6, ProductDescription);
			if(ProductPhoto != null){
				pStatement.setBlob(7, ProductPhoto);
			}
			pStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	//ร�ยขร�ยชร�โ€กร�ยฌproduct
	public Product viewProduct(int ProductID) {
		Product prod = new Product();
		String sql = "SELECT * FROM product WHERE ProductID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, ProductID);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
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
			}
			
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
		return prod;
	}
	//ร�ย ร�ฦ’ร�โ€ขร�โ€�ร�ยกร�ยดร�โ�ขProduct ร�ยทร�โ€�ร�ยฉร�ยงร�โ€นร�๏ฟฝร�ยด
	public ArrayList<Product> viewAllProduct() {
		ArrayList<Product> prodList = new ArrayList<Product>();
		String sql = "SELECT * FROM product";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
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
	//ร�ย ร�ฦ’ร�โ€ขร�โ€�ร�ยกร�ยฃร�ยชร�ยฉร�ยกร�โ€�ร�ฦ’ร�ยกร�ยกร�ยฉร�ยคร�ยข Product
	public void editProduct (int ProductID,String ProductName,double ProductPrice,int ProductNumber,String ProductDescription) {		
		try {
			PreparedStatement pStatement = con.
					prepareStatement("UPDATE product SET ProductName = ? , ProductPrice = ?, ProductNumber = ?, ProductDescription = ?  WHERE ProductID = ?");
			pStatement.setString(1,ProductName);
			pStatement.setDouble(2,ProductPrice);
			pStatement.setInt(3,ProductNumber);
			pStatement.setString(4,ProductDescription);
			pStatement.setInt(5,ProductID);
			pStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	// ร�ยทร�โ€�ร�ยกร�โ€�ร�ฦ’ร�โ€ฆร�ยบ Product
	public void deleteProductBy(int ProductID) {
		String sql = "DELETE FROM product Where ProductID=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, ProductID);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}
	
	public void updatenumberproduct(int ProductID, int ProductNumber) {
		//System.out.println(ProductID);
		String sql = "UPDATE product SET ProductNumber = ? WHERE ProductID = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, ProductNumber);
			statement.setInt(2, ProductID);
			statement.executeUpdate();
			//con.close();
		} catch (SQLException e) {
			System.err.println("Error Select data :" + e);
		}
	}


}

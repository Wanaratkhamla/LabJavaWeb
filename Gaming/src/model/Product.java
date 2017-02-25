package model;

import com.mysql.jdbc.Blob;

public class Product {
	private int ProductID;
	private int BrandID;
	private int TypeID;
	private String ProductName;
	private double ProductPrice;
	private int ProductNumber;
	private String ProductDescription;
	private Blob ProductPhoto ;
	private String photosrc;
	public String getPhotosrc() {
		return photosrc;
	}
	public void setPhotosrc(String photosrc) {
		this.photosrc = photosrc;
	}
	public Blob getProductPhoto() {
		return ProductPhoto;
	}
	public void setProductPhoto(Blob productPhoto) {
		ProductPhoto = productPhoto;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getBrandID() {
		return BrandID;
	}
	public void setBrandID(int brandID) {
		BrandID = brandID;
	}
	public int getTypeID() {
		return TypeID;
	}
	public void setTypeID(int typeID) {
		TypeID = typeID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public int getProductNumber() {
		return ProductNumber;
	}
	public void setProductNumber(int productNumber) {
		ProductNumber = productNumber;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	
	
	
}

package model;

public class CartDetail {
	private int CartID;
	private String Username;
	private String CartOrderdate;
	private int CartTotalProduct;
	private String CartPaydate;
	private int CartStatus;
	private double CartTotalPrice;
	
	public int OrderID;
	public int ProductID;
	public double OrderTotalPrice;
	public int OrderTotalproduct;
	
	private String ProductName;
	private String Photosrc;
	private Double ProductPrice;
	private String ProductDescription;
	public Double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(Double productPrice) {
		ProductPrice = productPrice;
	}
	public int getCartID() {
		return CartID;
	}
	public void setCartID(int cartID) {
		CartID = cartID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getCartOrderdate() {
		return CartOrderdate;
	}
	public void setCartOrderdate(String cartOrderdate) {
		CartOrderdate = cartOrderdate;
	}
	public int getCartTotalProduct() {
		return CartTotalProduct;
	}
	public void setCartTotalProduct(int cartTotalProduct) {
		CartTotalProduct = cartTotalProduct;
	}
	public String getCartPaydate() {
		return CartPaydate;
	}
	public void setCartPaydate(String cartPaydate) {
		CartPaydate = cartPaydate;
	}
	public int getCartStatus() {
		return CartStatus;
	}
	public void setCartStatus(int cartStatus) {
		CartStatus = cartStatus;
	}
	public double getCartTotalPrice() {
		return CartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		CartTotalPrice = cartTotalPrice;
	}
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public double getOrderTotalPrice() {
		return OrderTotalPrice;
	}
	public void setOrderTotalPrice(double orderTotalPrice) {
		OrderTotalPrice = orderTotalPrice;
	}
	public int getOrderTotalproduct() {
		return OrderTotalproduct;
	}
	public void setOrderTotalproduct(int orderTotalproduct) {
		OrderTotalproduct = orderTotalproduct;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getPhotosrc() {
		return Photosrc;
	}
	public void setPhotosrc(String photosrc) {
		Photosrc = photosrc;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
}

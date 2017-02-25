package model;

public class Cart {
	private int CartID;
	private String Username;
	private String CartOrderdate;
	private int CartTotalProduct;
	private String CartPaydate;
	private int CartStatus;
	private double CartTotalPrice;
	
	
	public double getCartTotalPrice() {
		return CartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		CartTotalPrice = cartTotalPrice;
	}
	public int getCartID() {
		return CartID;
	}
	public void setCartID(int cartID) {
		CartID = cartID;
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
	public void setCartPaydate(String cardPaydate) {
		CartPaydate = cardPaydate;
	}
	public int getCartStatus() {
		return CartStatus;
	}
	public void setCartStatus(int cartStatus) {
		CartStatus = cartStatus;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
}

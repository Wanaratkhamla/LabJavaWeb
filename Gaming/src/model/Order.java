package model;

public class Order {
	public int OrderID;
	public int CartID;
	public int ProductID;
	public double OrderTotalPrice;
	public int OrderTotalproduct;
	public Cart cart;
	public Product product;
	
	public double getOrderTotalPrice() {
		return OrderTotalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		OrderTotalPrice = orderTotalPrice;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getCartID() {
		return CartID;
	}

	public void setCartID(int cartID) {
		CartID = cartID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public int getOrderTotalproduct() {
		return OrderTotalproduct;
	}

	public void setOrderTotalproduct(int orderTotalproduct) {
		OrderTotalproduct = orderTotalproduct;
	}
}

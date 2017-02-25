package model;

public class pawn {
	private int PawnID;
	private String ProductID;
	private String CustomersID;
	private String PawnDate;
	private int Pawnstatus;
	private double Pawninterest;
	private String PawnDateEnd;
	private double PawnTotal;
	private double Pawnpaid;
	public double getPawnpaid() {
		return Pawnpaid;
	}
	public void setPawnpaid(double pawnpaid) {
		Pawnpaid = pawnpaid;
	}
	public double getPawnTotal() {
		return PawnTotal;
	}
	public void setPawnTotal(double pawnTotal) {
		PawnTotal = pawnTotal;
	}
	public int getPawnID() {
		return PawnID;
	}
	public void setPawnID(int pawnID) {
		PawnID = pawnID;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getCustomersID() {
		return CustomersID;
	}
	public void setCustomersID(String customersID) {
		CustomersID = customersID;
	}
	public String getPawnDate() {
		return PawnDate;
	}
	public void setPawnDate(String pawnDate) {
		PawnDate = pawnDate;
	}
	public int getPawnstatus() {
		return Pawnstatus;
	}
	public void setPawnstatus(int pawnstatus) {
		Pawnstatus = pawnstatus;
	}
	public double getPawninterest() {
		return Pawninterest;
	}
	public void setPawninterest(double pawninterest) {
		Pawninterest = pawninterest;
	}
	public String getPawnDateEnd() {
		return PawnDateEnd;
	}
	public void setPawnDateEnd(String pawnDateEnd) {
		PawnDateEnd = pawnDateEnd;
	}
}

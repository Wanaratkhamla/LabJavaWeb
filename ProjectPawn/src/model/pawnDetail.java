package model;

public class pawnDetail {
	private int PawnID;
	private String PawnDate;
	private int Pawnstatus;
	private double Pawninterest;
	private String PawnDateEnd;
	private double PawnTotal;
	private double Pawnpaid;
	
	
	private String ProductID;
	private String ProductName;
	private double ProductPrice;
	private String ProductDescription;
	
	private String CustomersID;
	private String Name;
	private String Address;
	private String PhoneNo;
	
	private int reportID;
	private String reportpawnDate;
	private double reportpawnBuy;
	private String reportpawnUserbuy;
	private String reportpawnAdmin;
	
	public String getReportpawnUserbuy() {
		return reportpawnUserbuy;
	}
	public void setReportpawnUserbuy(String reportpawnUserbuy) {
		this.reportpawnUserbuy = reportpawnUserbuy;
	}
	public String getReportpawnAdmin() {
		return reportpawnAdmin;
	}
	public void setReportpawnAdmin(String reportpawnAdmin) {
		this.reportpawnAdmin = reportpawnAdmin;
	}
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public String getReportpawnDate() {
		return reportpawnDate;
	}
	public void setReportpawnDate(String reportpawnDate) {
		this.reportpawnDate = reportpawnDate;
	}
	public double getReportpawnBuy() {
		return reportpawnBuy;
	}
	public void setReportpawnBuy(double reportpawnBuy) {
		this.reportpawnBuy = reportpawnBuy;
	}
	public int getPawnID() {
		return PawnID;
	}
	public double getPawnTotal() {
		return PawnTotal;
	}
	public void setPawnTotal(double pawnTotal) {
		PawnTotal = pawnTotal;
	}
	public void setPawnID(int pawnID) {
		PawnID = pawnID;
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
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
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
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public String getCustomersID() {
		return CustomersID;
	}
	public void setCustomersID(String customersID) {
		CustomersID = customersID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public double getPawnpaid() {
		return Pawnpaid;
	}
	public void setPawnpaid(double pawnpaid) {
		Pawnpaid = pawnpaid;
	}
}

package model;

public class reportpawn {
	private int reportID;
	private String reportpawnDate;
	private double reportpawnBuy;
	private int PawnID;
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
	public int getPawnID() {
		return PawnID;
	}
	public void setPawnID(int pawnID) {
		PawnID = pawnID;
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
}

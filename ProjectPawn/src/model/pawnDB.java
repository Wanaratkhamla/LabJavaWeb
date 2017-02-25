package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class pawnDB {
	private Connection con;
	public pawnDB() {
		con = ConnectDatabase.getConnection();
	}
	
	//insertPawn
		public void insertpawn(String ProductID,String CustomersID,double Pawninterest,String PawnDateEnd)
		{
			try {
				PreparedStatement pStatement = con.prepareStatement(
						"INSERT INTO pawn ( ProductID, CustomersID, PawnDate, Pawnstatus, Pawninterest, PawnDateEnd, Pawnpaid) VALUES (?,?,NOW(),0,?,?,0)");
				pStatement.setString(1, ProductID);
				pStatement.setString(2, CustomersID);
				pStatement.setDouble(3, Pawninterest);
				pStatement.setString(4, PawnDateEnd);
				pStatement.executeUpdate();
			} catch (SQLException e) {
				System.err.println("Error: " + e);
			}
		}
		
		//SelectProduct Un Pawn
		public ArrayList<pawn> ViewproductUnpawn() {
			ArrayList<pawn> unpawnlist = new ArrayList<pawn>();
			try {
				PreparedStatement pStatement = con.prepareStatement("SELECT * FROM pawn WHERE Pawnstatus=3");
				ResultSet resultSet = pStatement.executeQuery();
				
				while (resultSet.next()) {
					int PawnID = resultSet.getInt("PawnID");
					String ProductID = resultSet.getString("ProductID");
					String CustomersID = resultSet.getString("CustomersID");

					pawn pawn = new pawn();
					pawn.setPawnID(PawnID);
					pawn.setProductID(ProductID);
					pawn.setCustomersID(CustomersID);
					unpawnlist.add(pawn);
				}

			} catch (SQLException e) {
				System.err.println("Error: " + e);
			}
			return unpawnlist;
		}
		//SelectProductPawn
				public ArrayList<pawn> Viewpawn() {
					ArrayList<pawn> pawnlist = new ArrayList<pawn>();
					try {
						PreparedStatement pStatement = con.prepareStatement("SELECT * FROM pawn");
						ResultSet resultSet = pStatement.executeQuery();
						
						while (resultSet.next()) {
							int PawnID = resultSet.getInt("PawnID");
							String ProductID = resultSet.getString("ProductID");
							String CustomersID = resultSet.getString("CustomersID");
							String PawnDate = resultSet.getString("PawnDate");
							Double Pawninterest = resultSet.getDouble("Pawninterest");
							String PawnDateEnd = resultSet.getString("PawnDateEnd");
							int Pawnstatus = resultSet.getInt("Pawnstatus");
							Double PawnTotal = resultSet.getDouble("PawnTotal");
							Double Pawnpaid = resultSet.getDouble("Pawnpaid");
							
							pawn pawn = new pawn();
							pawn.setPawnID(PawnID);
							pawn.setProductID(ProductID);
							pawn.setCustomersID(CustomersID);
							pawn.setPawnDate(PawnDate);
							pawn.setPawninterest(Pawninterest);
							pawn.setPawnDateEnd(PawnDateEnd);
							pawn.setPawnstatus(Pawnstatus);
							pawn.setPawnTotal(PawnTotal);
							pawn.setPawnpaid(Pawnpaid);
							pawnlist.add(pawn);
						}

					} catch (SQLException e) {
						System.err.println("Error: " + e);
					}
					return pawnlist;
				}
				
				//update pawntoal
				public void updatepawntotal(int PawnID ,double PawnTotal) {
					String sql = "UPDATE pawn SET PawnTotal = ? WHERE PawnID = ?";
					try {
						PreparedStatement statement = con.prepareStatement(sql);
						statement.setDouble(1, PawnTotal);
						statement.setInt(2, PawnID);
						statement.executeUpdate();
						//con.close();
					} catch (SQLException e) {
						System.err.println("Error Select data :" + e);
					}
				}
				
				//selectpawnID
				public pawn selectpawnID(String ProductID) {
					pawn pawn = new pawn();
					String sql = "SELECT * FROM pawn WHERE ProductID=?";
					try {
						PreparedStatement statement = con.prepareStatement(sql);
						statement.setString(1, ProductID);
						ResultSet result = statement.executeQuery();
						if (result.next()) {
							pawn.setPawnID(result.getInt("PawnID"));
						}
					} catch (SQLException e) {
						System.err.println("Error Select data :" + e);
					}
					return pawn;
				}
				//updatepawnpaid
				public void updatepawnpaid(int PawnID ,double Pawnpaid) {
					String sql = "UPDATE pawn SET Pawnpaid = ? WHERE PawnID = ?";
					try {
						PreparedStatement statement = con.prepareStatement(sql);
						statement.setDouble(1, Pawnpaid);
						statement.setInt(2, PawnID);
						statement.executeUpdate();
						//con.close();
					} catch (SQLException e) {
						System.err.println("Error Select data :" + e);
					}
				}
				//selectAlltablepawn
				public pawn selectAlltablepawn(int PawnID) {
					pawn pawn = new pawn();
					String sql = "SELECT * FROM pawn WHERE PawnID=?";
					try {
						PreparedStatement statement = con.prepareStatement(sql);
						statement.setInt(1, PawnID);
						ResultSet result = statement.executeQuery();
						if (result.next()) {
							pawn.setPawnID(result.getInt("PawnID"));
							pawn.setProductID(result.getString("ProductID"));
							pawn.setCustomersID(result.getString("CustomersID"));
							pawn.setPawnDate(result.getString("PawnDate"));
							pawn.setPawnstatus(result.getInt("pawnstatus"));
							pawn.setPawninterest(result.getDouble("Pawninterest"));
							pawn.setPawnDateEnd(result.getString("PawnDateEnd"));
							pawn.setPawnTotal(result.getDouble("PawnTotal"));
							pawn.setPawnpaid(result.getDouble("Pawnpaid"));
						}
					} catch (SQLException e) {
						System.err.println("Error Select data :" + e);
					}
					return pawn;
				}
				//SelectAllreport
				public ArrayList<reportpawn> Viewreport() {
					ArrayList<reportpawn> reportlist = new ArrayList<reportpawn>();
					try {
						PreparedStatement pStatement = con.prepareStatement("SELECT * FROM reportpawn");
						ResultSet resultSet = pStatement.executeQuery();
						
						while (resultSet.next()) {
							int reportID = resultSet.getInt("reportID");
							int PawnID = resultSet.getInt("PawnID");
							String reportpawnDate = resultSet.getString("reportpawnDate");
							Double reportpawnBuy = resultSet.getDouble("reportpawnBuy");
							String reportpawnUserbuy = resultSet.getString("reportpawnUserbuy");
							String reportpawnAdmin = resultSet.getString("reportpawnAdmin");
							
							reportpawn reportpawn = new reportpawn();
							reportpawn.setReportID(reportID);
							reportpawn.setPawnID(PawnID);
							reportpawn.setReportpawnDate(reportpawnDate);
							reportpawn.setReportpawnBuy(reportpawnBuy);
							reportpawn.setReportpawnUserbuy(reportpawnUserbuy);
							reportpawn.setReportpawnAdmin(reportpawnAdmin);
							reportlist.add(reportpawn);
						}

					} catch (SQLException e) {
						System.err.println("Error: " + e);
					}
					return reportlist;
				}
				//updatePawnstatus
				public void updatePawnstatus(int PawnID ,int Pawnstatus) {
					String sql = "UPDATE pawn SET Pawnstatus = ? WHERE PawnID = ?";
					try {
						PreparedStatement statement = con.prepareStatement(sql);
						statement.setInt(1, Pawnstatus);
						statement.setInt(2, PawnID);
						statement.executeUpdate();
						//con.close();
					} catch (SQLException e) {
						System.err.println("Error Select data :" + e);
					}
				}
}

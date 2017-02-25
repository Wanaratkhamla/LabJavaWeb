package model;

public class admin {
	private String Username;
	private String Password;
	private String Name;
	private String IDCard;
	private String Address;
	private String PhoneNO;
	private boolean Check=false;
	
	public boolean getCheck() {
		return Check;
	}
	public void setCheck(boolean check) {
		Check = check;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNO() {
		return PhoneNO;
	}
	public void setPhoneNO(String phoneNO) {
		PhoneNO = phoneNO;
	}
}

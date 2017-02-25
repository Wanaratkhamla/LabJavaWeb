package model;

public class User {
	private String Username;
	private String Password;
	private String Name;
	private String Type;
	private String ID_Card;
	private String EMail;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getID_Card() {
		return ID_Card;
	}
	public void setID_Card(String iD_Card) {
		ID_Card = iD_Card;
	}
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
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

package Model;

public class User {
	
	String name;
	String email;
	String password;
	int rollNo;
	int goldPoints=0;
	
	public int getGoldPoints() {
		return goldPoints;
	}
	public void setGoldPoints(int goldPoints) {
		this.goldPoints = goldPoints;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public User(String name, String email, String password, int rollNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.rollNo = rollNo;
	}
	
	

}

package pojo;

public class PojoLibrary {
	
	//global variables
	public String name;
	public int id;
	public int phoneNo;
	public String emailId;
	
	public PojoLibrary() {
		
	}
	
	//parameterized constructor
	public PojoLibrary(String name, int id, int phoneNo, String emailId) {
		super();
		this.name = name;
		this.id = id;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	
	//getters and setters methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}

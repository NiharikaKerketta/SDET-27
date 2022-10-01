package pojo;

public class PojoArrayLibrary {
	//global variable
	String name;
	String emailId;
	int[] phoneNo;
	public PojoArrayLibrary(String name, String emailId, int[] phoneNo) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int[] getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int[] phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}

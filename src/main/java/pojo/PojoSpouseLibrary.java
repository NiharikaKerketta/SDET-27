package pojo;

public class PojoSpouseLibrary {
	String name;
	int phoneNo;
	String id;
	public PojoSpouseLibrary(String name, int phoneNo, String id) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

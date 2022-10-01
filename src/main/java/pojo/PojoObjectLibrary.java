package pojo;

public class PojoObjectLibrary {
	String empName;
	String empPhoneNo;
	Object spouse;
	
	public PojoObjectLibrary(String empName, String empPhoneNo, Object spouse) {
		super();
		this.empName = empName;
		this.empPhoneNo = empPhoneNo;
		this.spouse = spouse;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhoneNo() {
		return empPhoneNo;
	}
	public void setEmpPhoneNo(String empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}
	public Object getSpouse() {
		return spouse;
	}
	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
}

/**
 * 
 */
package nubdub.com.model;

/**
 * @author nubdu
 *
 */
public class Customer {

	private String fName;
	private String lName;
	private double phoneNum;
	private String address;
	private String state;
	private String customerID;
	private String gender;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public double getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(double phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("'fName':'").append(fName).append("',")
			.append("'lName':'").append(lName).append("',")
			.append("'phoneNum':'").append(phoneNum).append("',")
			.append("'address':'").append(address).append("',")
			.append("'state':'").append(state).append("',")
			.append("'customerID':'").append(customerID).append("',")
			.append("'gender':'").append(gender).append("'")
			.append("}");
		return sb.toString();
	}
	
	
	
}

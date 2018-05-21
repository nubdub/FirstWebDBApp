/**
 * 
 */
package nubdub.com.model;

/**
 * @author nubdu
 *
 */
public class Account {

	private String acctNum;
	private String type;
	private String currency;
	private double balance;
	private String customerID;
	private Customer owner;
	
	
	
	public Customer getOwner() {
		return owner;
	}
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
		.append("'acctNum':'").append(acctNum).append("',")
		.append("'type':'").append(type).append("',")
		.append("'currency':'").append(currency).append("',")
		.append("'balance':'").append(balance).append("',")
		.append("'customerID':'").append(customerID).append("'")
		.append("}");
	return sb.toString();
	}
	
	
	
}

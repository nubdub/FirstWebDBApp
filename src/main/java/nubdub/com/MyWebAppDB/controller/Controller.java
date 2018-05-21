/**
 * 
 */
package nubdub.com.MyWebAppDB.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nubdub.com.model.Account;
import nubdub.com.model.Customer;

/**
 * @author nubdu
 *
 */
@RestController
public class Controller {
	
	@RequestMapping("/showCustomers")
	public String showCustomers() throws SQLException {
		ResultSet rs = connectToDB("select fName, lName from customer");
		StringBuilder sb = new StringBuilder();
		List<Customer> list = new ArrayList<>();
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setfName(rs.getString(1));
			customer.setlName(rs.getString(2));
			list.add(customer);
		}
		return toJSON(list);
	}

	private ResultSet connectToDB(String sql) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/mydb", "root", "Yahoo2016!");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	@RequestMapping("/showTotalBalance")
	public String showTotalBalance() throws SQLException {
		ResultSet rs = connectToDB("select customer.fName, customer.lName, sum(account.balance) from customer, account where account.customerID = customer.customerID group by customer.customerID");
		StringBuilder sb = new StringBuilder();
		List<Customer> list = new ArrayList<>();
		while (rs.next()) {
			Customer customer = new Customer();
			Account account = new Account();
			customer.setfName(rs.getString(1));
			customer.setlName(rs.getString(2));
			account.setBalance(Double.parseDouble(rs.getString(3)));
			account.setOwner(customer);
			list.add(customer);
		}
		return toJSON(list);
	}
	
	public String toJSON(List<Customer> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("[");
		for(Customer customer: list) {
			sb.append(customer.toJSON());
		}
		sb.append("]");
		sb.append("}");
		return sb.toString();
	}

}

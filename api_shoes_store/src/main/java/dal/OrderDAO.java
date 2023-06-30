/*
package dal;

import java.sql.PreparedStatement;

import model.Customer;
import model.Product;

public class OrderDAO extends DBConnect{
	public void insertOrder(Customer c, Product p, int quantity) {
		PreparedStatement stmt = null;
		
		try {
		String sql = "INSERT INTO Orders VALUES(?,?,?)";
		stmt = connection.prepareStatement(sql);
		stmt.setInt(1, c.getId());
		stmt.setString(2, p.getId());
		stmt.setInt(3, quantity);
		
		stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insertBill(Customer c, int totalCost) {
		PreparedStatement stmt = null;
		
		try {
		String sql = "INSERT INTO Bills VALUES(?,?)";
		stmt = connection.prepareStatement(sql);
		stmt.setInt(1, c.getId());
		stmt.setInt(2, totalCost);
	
		stmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
*/
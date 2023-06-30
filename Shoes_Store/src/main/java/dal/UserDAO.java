package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class UserDAO extends DBConnect{
	public Customer checkUsernameExist(String username) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM Customers WHERE username=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
	
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String password = rs.getString("password");
				return new Customer(id, name, phone, city, username, password);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	public Customer checkAccount(String username, String password) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM Customers WHERE username=? AND password=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				return new Customer(id, name, phone, city, username, password);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	public void userRegister(Customer c) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO Customers VALUES(?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPhone());
			stmt.setString(3, c.getCity());
			stmt.setString(4, c.getUsername());
			stmt.setString(5, c.getPassword());
			System.out.println(c.getCity());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

	public void updateUser(String name, String phone, String city, int id) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "UPDATE Customers SET name = ?, phone = ?, city = ? WHERE id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, city);
			stmt.setInt(4, id);
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}

	public void updatePwd(String password, int id) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "UPDATE Customers SET password = ? WHERE id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}
	
	
}

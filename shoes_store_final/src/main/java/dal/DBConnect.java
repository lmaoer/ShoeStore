package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class DBConnect {
	protected Connection connection;

	public DBConnect() {

		try {
			String url = "jdbc:mysql://localhost:3306/shoesstore"; // get a connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "1mrbean3");
			System.out.println(connection);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBConnect dbConnect = new DBConnect();
	}
}

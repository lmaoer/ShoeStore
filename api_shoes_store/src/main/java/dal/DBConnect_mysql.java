
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class DBConnect_mysql {
	protected Connection connection;

	public DBConnect_mysql() {

		try { // remotemysql
			String url = "jdbc:mysql://localhost:3306/base64"; // get a connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "1mrbean3");
			System.out.println(connection);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBConnect_mysql dbConnect = new DBConnect_mysql();
	}
}

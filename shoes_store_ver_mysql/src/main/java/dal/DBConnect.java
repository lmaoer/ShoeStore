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
			// remotemysql
			String url = "jdbc:mysql://remotemysql.com:3306/mIVGlNpVbf?autoReconnect=true&tcpKeepAlive=true"; // get a connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, "mIVGlNpVbf", "FbO7BDCbG2");
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

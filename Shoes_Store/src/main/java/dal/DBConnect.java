package dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	protected Connection connection;

	public DBConnect() {
		try {
			// Edit URL , username, password to authenticate with your MS SQL Server
			String url = "jdbc:sqlserver://localhost:1433;databaseName=shoesStore";
			String username = "sa";
			String password = "long2001";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}
	}
	
	
	
	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		DBConnect dbConnect = new DBConnect();
		System.out.println(dbConnect.getConnection());
	}
}

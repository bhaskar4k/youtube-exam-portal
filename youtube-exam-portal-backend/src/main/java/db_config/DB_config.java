package db_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_config {
	private String JDBC_URL = "jdbc:mysql://localhost:3306/youtube_exam_portal";
	private String USER_NAME = "root";
	private String PASSWORD = "root";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			System.out.println("Fail to load the driver");
		}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL,USER_NAME,PASSWORD);
	}
}

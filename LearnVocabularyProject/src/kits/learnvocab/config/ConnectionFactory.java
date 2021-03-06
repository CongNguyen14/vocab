package kits.learnvocab.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	private String driverDb = "org.mariadb.jdbc.Driver";
	private String connectionUrl = "jdbc:mariadb://localhost:3306/vocabulary";
	private String dbUser = "root";
	private String dbPass ="123";
	
private static ConnectionFactory connectionFactory = null;
	
	private ConnectionFactory() {
		try {
			Class.forName(driverDb);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl,dbUser,dbPass);
		return conn;
	}
}

	


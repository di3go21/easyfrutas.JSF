package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DbConnection {
	
	static String db="easyfrutas";
	static String login = "di3go";
	static String password = "hola";
	static String zonaHoraria = "?serverTimezone=" + TimeZone.getDefault().getID();
	static String url = "jdbc:mysql://localhost/" + db+ zonaHoraria;

	Connection conn = null;

	public DbConnection() {

		try {
			conn = DriverManager.getConnection(url, login, password);

			if (conn != null)
				System.err.println("connection with database [" + db + "] OK");
			else 
				System.out.println("mala conex");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void disconnect() {
		if (conn!=null) {
			try {
				conn.close();
				System.out.println("Disconnection with database [" + db + "] OK");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
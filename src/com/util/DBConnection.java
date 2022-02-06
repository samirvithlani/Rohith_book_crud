package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String userName = "root";
	private static String password = "root";
	private static String urlName = "jdbc:mysql://localhost:3306/rohith";
	private static String driverclass = "com.mysql.jdbc.Driver";

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(driverclass);

			conn = DriverManager.getConnection(urlName, userName, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}

package com.ty.passwordmanager.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObject {
	private static String url = "jdbc:mysql://localhost:3306/user_jdbc";
	private static String userName = "root";
	private static String password = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
package com.dxc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
protected ConnectionManager() { }
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		String dri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dxc1";
		String un = "root";
		String pass = "root";
		
		Class.forName(dri);
		conn = DriverManager.getConnection(url, un, pass);
		conn.setAutoCommit(false);
		return conn;
	}
}

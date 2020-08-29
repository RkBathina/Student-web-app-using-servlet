package com.dxc.dao;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.dxc.util.ConnectionManager;



public class JdbcDAO {
	Connection conn = null;
	public JdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		conn = ConnectionManager.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void save() throws SQLException {
		conn.commit();
		conn.close();
	}
	
	public void undo() throws SQLException {
		conn.rollback();
		conn.close();
	}

}

package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Student1;
import com.dxc.util.ConnectionManager;

public class StudentJdbcDAO extends JdbcDAO implements DAO<Student1> {
	
	

	public StudentJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Student1 e) throws SQLException {
		boolean res = false;
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student1 VALUES(?,?,?,?,?)");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setDate(3, (java.sql.Date) e.getDob());
		pstmt.setString(4, e.getEmail());
		pstmt.setString(5, e.getMobile());
		
		if(1== pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public boolean edit(Student1 e) throws SQLException {
		boolean res = false;
		
		PreparedStatement pstmt = conn.prepareStatement("UPDATE student1 SET name=?, dob=?, email=?, mobile=? WHERE id = ?");
		pstmt.setString(1, e.getName());
		pstmt.setDate(3, (java.sql.Date) e.getDob());
		pstmt.setString(3, e.getEmail());
		pstmt.setString(4, e.getMobile());
		pstmt.setInt(5, e.getId());
		
		if(1 == pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		boolean res = false;
		
		PreparedStatement pstmt = conn.prepareStatement("DELETE FROM student1 WHERE id = ?");
		pstmt.setInt(1, id);
		if(1== pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public Student1 find(int id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		Student1 student = null;
		
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student1 WHERE id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				
				java.util.Date dd = rs.getDate(3);
				String strdob = new SimpleDateFormat("dd-MM-yyyy").format(dd);
				String email = rs.getString(4);
				String mobile = rs.getString("mobile");
				
				student = new Student1(id, name, strdob, email, mobile);
			}
		}
		finally {
			conn.close();
		}
		
		return student;
	}

	@Override
	public List<Student1> findAll() throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Student1> students = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student1");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				java.util.Date dd = rs.getDate("dob");
				String strdob = new SimpleDateFormat("dd-MM-yyyy").format(dd);
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				
				Student1 student = new Student1(id, name, strdob, email, mobile);
				students.add(student);
			}
		}
		finally {
			conn.close();
		}
		
		
		return students;
	}
	
	
	public String csvAll() throws SQLException, ParseException {
		String fullcsv="";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM student1");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			java.util.Date dd = rs.getDate("dob");
			String strdob = new SimpleDateFormat("dd-MM-yyyy").format(dd);
			String email = rs.getString("email");
			String mobile = rs.getString("mobile");
			
			Student1 student = new Student1(id, name, strdob, email, mobile);
			fullcsv+=student.toCSV()+"\n";
		}
		
		
		return fullcsv;
	}

}

package com.dxc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.dxc.beans.Student1;
import com.dxc.dao.StudentJdbcDAO;

public class StudentServiceImpl implements StudentService {

	@Override
	public boolean save(Student1 student1) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			StudentJdbcDAO studentjdbcdao = new StudentJdbcDAO();
			res = studentjdbcdao.save(student1);
			if(res)
			{
				studentjdbcdao.save();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Student1 find(int id) {
		// TODO Auto-generated method stub
		Student1 student1 = null;
		try {
			StudentJdbcDAO studentjdbcdao = new StudentJdbcDAO();
			student1 = studentjdbcdao.find(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student1;
	}

	@Override
	public List<Student1> findAll() {
		// TODO Auto-generated method stub
		List<Student1> students = null;
		try {
			StudentJdbcDAO studentjdbcdao = new StudentJdbcDAO();
			students = studentjdbcdao.findAll();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public boolean update(Student1 student1) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			StudentJdbcDAO studentjdbcdao = new StudentJdbcDAO();
			res = studentjdbcdao.edit(student1);
			if(res)
			{
				studentjdbcdao.save();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean res = false;
		StudentJdbcDAO studentjdbcdao;
		try {
			studentjdbcdao = new StudentJdbcDAO();
			res = studentjdbcdao.delete(id);
			if(res)
			{
				studentjdbcdao.save();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}

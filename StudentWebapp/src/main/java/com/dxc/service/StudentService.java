package com.dxc.service;

import java.util.List;

import com.dxc.beans.Student1;

public interface StudentService {
	
	boolean save(Student1 student1);
	Student1 find(int id);
	List<Student1> findAll();
	boolean update(Student1 student1);
	boolean delete(int id);

}

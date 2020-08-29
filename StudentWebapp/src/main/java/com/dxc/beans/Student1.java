package com.dxc.beans;

import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.management.modelmbean.ModelMBean;

public class Student1 implements Serializable, Comparable<Student1> {
	int id;
	String name;
	Date dob;
	String email;
	String mobile;
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student1(int id, String name, String strdob, String email, String mobile) throws ParseException {
		super();
		this.id = id;
		this.name = name;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		dob = df.parse(strdob);
		this.email = email;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		String strdob = new SimpleDateFormat("dd-MM-yyyy").format(dob);
		return "Student1 [id=" + id + ", name=" + name + ", dob=" + strdob + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
	public String toCSV()
	{
		String strdob = new SimpleDateFormat("dd-MM-yyyy").format(dob);
		return id+", "+name+", "+strdob+", "+email+", "+mobile ;
	}
	public static Student1 parseStudent1(String csvStudent1) throws ParseException
	{
		String[] values = csvStudent1.split(",");
		int id = Integer.parseInt(values[0].trim());
		String name = values[1].trim();
		String strdob = values[2].trim();
		String email = values[3].trim();
		String mobile = values[4].trim();
		
		Student1 student = new Student1(id, name, strdob, email, mobile);
		return student;
		
	}
	@Override
	public int compareTo(Student1 o) {
		// TODO Auto-generated method stub
		return this.id - o.getId();
	}

}

package gr.uom.demo1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {

	private String name;
	private String address;
	private int year;
	private String password;
	
	public Student(String name, String address, int year, String password) {
		this.name = name;
		this.address = address;
		this.year = year;
		this.password = password;
	}
	
	

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}

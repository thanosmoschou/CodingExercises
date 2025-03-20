package gr.uom.demo1.controllers.dto;

public class StudentStripped {
	private String name;
	private String address;
	private int year;
	public StudentStripped(String name, String address, int year) {
		super();
		this.name = name;
		this.address = address;
		this.year = year;
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

/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package progErgasia3ch8JavaBook;

public class Doctor extends Person
{
	private String doctorType;
	private double payPerVisit;
	
	public Doctor(String aName, String aDoctorType, double aPayPerVisit)
	{
		super(aName);
		this.doctorType = aDoctorType;
		this.payPerVisit = aPayPerVisit;
	}
	
	
	public boolean equals(String aDoctorType)
	{
		return  this.doctorType.equalsIgnoreCase(aDoctorType);
	}


	public String getDoctorType() 
	{
		return doctorType;
	}


	public void setDoctorType(String doctorType) 
	{
		this.doctorType = doctorType;
	}


	public double getPayPerVisit()
	{
		return payPerVisit;
	}


	public void setPayPerVisit(double payPerVisit)
	{
		this.payPerVisit = payPerVisit;
	}
	
	
	
}

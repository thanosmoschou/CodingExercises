/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */


public class Vehicle 
{
	private String companyName;
	private int cylinderNumber;
	private Person owner;
	
	public Vehicle(String aCompany, int aCylindNum, Person anOwner)
	{
		this.companyName = aCompany;
		this.cylinderNumber = aCylindNum;
		this.owner = anOwner;
	}
	
	public String getCompanyName() 
	{
		return companyName;
	}
	
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	
	public int getCylinderNumber() 
	{
		return cylinderNumber;
	}
	
	public void setCylinderNumber(int cylinderNumber) 
	{
		this.cylinderNumber = cylinderNumber;
	}
	
	public Person getOwner()
	{
		return owner;
	}
	
	public void setOwner(Person newOwner)
	{
		owner = newOwner;
	}
	
}

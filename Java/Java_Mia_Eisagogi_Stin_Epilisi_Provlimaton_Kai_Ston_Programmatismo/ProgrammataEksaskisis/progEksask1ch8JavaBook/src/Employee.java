/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */


public class Employee extends Person
{
	private double pay;
	private int hireYear;
	private String refId;
	
	public Employee(String aName, double aPay, int aHireYear, String aRefId)
	{
		super(aName);
		this.pay = aPay;
		this.hireYear = aHireYear;
		this.refId = aRefId;
		
		//if i want i can not assign the pay value and create another constuctor to assign this value
		//then i call it with this(aPay)...this keyword with () means a call for appropriate constructor
	}
	
	/*
	 * public Employee(double aPay)
	 * {
	 * 		pay = aPay;
	 * 		
	 * }
	 */

	public double getPay()
	{
		return pay;
	}

	public void setPay(double pay)
	{
		this.pay = pay;
	}

	public int getHireYear() 
	{
		return hireYear;
	}

	public void setHireYear(int hireYear) 
	{
		this.hireYear = hireYear;
	}

	public String getRefId()
	{
		return refId;
	}

	public void setRefId(String refId)
	{
		this.refId = refId;
	}
	
	public void writeOutput()
	{
		System.out.println("----------");
		super.writeOutput();
		System.out.println("Pay: " + pay + "\nHire year: " + hireYear + "\nRef ID: " + refId);
	}
	
	public boolean hasSameName(Person other)
	{
		return this.getName().equalsIgnoreCase(other.getName());
	}
	
	
	
}

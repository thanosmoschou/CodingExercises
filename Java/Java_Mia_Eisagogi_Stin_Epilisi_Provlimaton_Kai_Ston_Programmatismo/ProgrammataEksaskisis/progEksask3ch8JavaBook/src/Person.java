/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */


public class Person 
{
	private String name;
	
	public Person()
	{
		name = "No name yet";
	}
	
	public Person(String aName)
	{
		name = aName;
	}
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void writeOutput()
	{
		System.out.println("Name: " + name);
	}
	
	public boolean hasSameName(Person other)
	{
		return this.name.equalsIgnoreCase(other.name);
	}
}

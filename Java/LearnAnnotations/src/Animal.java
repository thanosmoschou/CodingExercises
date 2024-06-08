/*
 * Author: Thanos Moschou
 * Description: This is a small program that helped me to learn more about annotations in Java.
 * Last Modification Date: 15/12/2023
 */


public abstract class Animal 
{
	private String name;
	
	public Animal(String aName)
	{
		this.name = aName;
	}
	
	
	public String getName()
	{
		return this.name;
	}
}

/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package progErgasia3ch8JavaBook;

public class Patient extends Person
{
	private String id;
	
	public Patient(String aName, String anId)
	{
		super(aName);
		this.id = anId;
	}
	

	public String getId()
	{
		return id;
	}

	
	public void setId(String id) 
	{
		this.id = id;
	}
	
	
	
}

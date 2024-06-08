/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception handling exercises
 */

package ex10ch9JavaBook;

public class RoomCounter 
{
	private int person;
	
	public RoomCounter(int somePerson)
	{
		this.person = somePerson;
	}
	
	
	public void addPerson()
	{
		person++;
	}
	
	
	public void removePerson()
	{
		try
		{
			if(person - 1 < 0)
				throw new NegativeCounterException();
			else
				person--;
		}
		catch(NegativeCounterException e)
		{
			System.out.println(e.getMessage());
		}
	}


	public int getPerson()
	{
		return person;
	}
}

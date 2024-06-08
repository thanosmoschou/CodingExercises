/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Simulate the borrowing simulation of a school library
 */


public class Book 
{
	private String id;
	private boolean borrow;
	
	public Book(String anId)
	{
		id = anId;
		borrow = false;
	}
	
	
	public void borrow()
	{
		if(!borrow)
			borrow = true;
		else
			System.out.println("This book is already borrowed.");
	}
	
	
	public void printInfo()
	{
		System.out.println("ID: " + id + "\n" + "Borrowed? " + borrow);
	}
	
	
	public String getId()
	{
		return id;
	}
	
	
	public boolean getBorrow()
	{
		return borrow;
	}
	
	
	public void setBorrow(boolean aValue)
	{
		borrow = aValue;
	}
}



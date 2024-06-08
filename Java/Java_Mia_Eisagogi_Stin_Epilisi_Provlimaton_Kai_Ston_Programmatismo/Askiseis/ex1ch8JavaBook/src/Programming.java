/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Simulate the borrowing simulation of a school library
 */


public class Programming extends Scientific
{
	private String progLang;
	
	public Programming(String aTheme, String anId, String aProgLang)
	{
		super(aTheme, anId);
		progLang = aProgLang;
	}
	
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Programming Language: " + progLang);
	}
	
	
	public void borrow()
	{
		System.out.println("Those books cannot be borrowed.");
		setBorrow(false);
	}
	
	
	public String getProgrammingLanguage()
	{
		return progLang;
	}
	
	
	public boolean getBorrow()
	{
		return false;
	}
	
}

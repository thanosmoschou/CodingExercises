/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Simulate the borrowing simulation of a school library
 */


public class Scientific extends Book
{
	private String theme;
	
	public Scientific(String aTheme, String anId)
	{
		super(anId);
		theme = aTheme;
	}
	
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Theme: " + theme);
	}
	
	
	public String getTheme()
	{
		return theme;
	}
	
	
	public void setTheme(String aTheme)
	{
		theme = aTheme;
	}
	
}

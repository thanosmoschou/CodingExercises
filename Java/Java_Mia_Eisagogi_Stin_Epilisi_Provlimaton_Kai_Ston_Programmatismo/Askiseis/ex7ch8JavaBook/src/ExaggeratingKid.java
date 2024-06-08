/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Understanding inheritance
 */


public class ExaggeratingKid extends SchoolKid
{
	private final int addAge = 2;
	
	public ExaggeratingKid(String aName, int anAge, String aTeacherName, String aSalute)
	{
		super(aName, anAge, aTeacherName, aSalute);
	}
	
	
	public int getAge()
	{
		return super.getAge() + addAge;
	}
	
	
	public String getSalute()
	{
		return super.getSalute() + " I am the best";
	}
}

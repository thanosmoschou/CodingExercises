
public class Reservation 
{
	private int days;
	
	public Reservation(int someDays)
	{
		this.days = someDays;
	}
	
	
	public double calculateCost()
	{
		return 120 * days;
	}
	
	
	public int getDays()
	{
		return days;
	}
}

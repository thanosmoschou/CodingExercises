
public class AllInclusive extends Reservation
{
	private int meals;

	public AllInclusive(int someDays, int meals) 
	{
		super(someDays);
		this.meals = meals;
	}
	
	
	public double calculateCost()
	{
		return this.getDays() * (120 + meals * 30);
	}
	
	
	public int getMeals()
	{
		return meals;
	}
}

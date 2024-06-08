/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package ex11ch8JavaBook;

public class BulkDiscount extends DiscountPolicy
{
	private int minimum;
	private double percent; //range [0,1] for example 60% discount is 0.6
	
	
	public BulkDiscount(int minimum, double percent)
	{
		this.minimum = minimum;
		this.percent = percent;
	}
	
	
	public double computeDiscount(int count, double itemCost)
	{
		if(count > minimum) 
			return (count * itemCost) * percent;
		else
			System.out.println("No discount for this purchase.");
		return 0;
	}
	
	
	public int getMinimum()
	{
		return this.minimum;
	}
	
	
	public void setMinimum(int newMin)
	{
		this.minimum = newMin;
	}
	
	
	public double getPercent()
	{
		return this.percent;
	}
	
	
	public void setPercent(double newPercent)
	{
		this.percent = newPercent;
	}
}

/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: understanding abstract classes
 */


public abstract class PayCalculator
{
	private double payRate;
	
	public PayCalculator(double aRate)
	{
		payRate = aRate;
	}
	
	
	public double computePay(int hours)
	{
		return hours * payRate;
	}
	
	
	public void setPayRate(double aRate)
	{
		payRate = aRate;
	}
}

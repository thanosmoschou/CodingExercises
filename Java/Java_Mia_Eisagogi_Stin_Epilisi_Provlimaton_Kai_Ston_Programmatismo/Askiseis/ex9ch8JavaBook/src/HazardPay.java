/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: understanding abstract classes
 */


public class HazardPay extends PayCalculator
{
	public HazardPay(double aRate)
	{
		super(aRate);
	}
	
	
	public double computePay(int hours)
	{
		return super.computePay(hours) * 1.5;
	}
}

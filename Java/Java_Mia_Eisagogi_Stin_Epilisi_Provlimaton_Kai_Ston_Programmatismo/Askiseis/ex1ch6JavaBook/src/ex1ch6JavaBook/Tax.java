/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Tax computation with static methods
 */

package ex1ch6JavaBook;

public class Tax 
{

	private static double basicRate = 0.4;
	private static double luxuryRate = 0.1;
	

	public static double computeCostBasic(double aPrice)
	{
		return roundToNearestPenny(aPrice + basicRate * aPrice);
	}
	
	
	public static double computeCostLuxury(double aPrice)
	{
		return roundToNearestPenny(aPrice + luxuryRate * aPrice); 
	}
	
	
	public static void changeBasicRateTo(double newRate)
	{
		basicRate = newRate;
	}
	
	
	public static void changeLuxuryRate(double newRate)
	{
		luxuryRate = newRate;
	}
	
	
	public static double roundToNearestPenny(double aPrice)
	{
		aPrice *= 100;
		return Math.round(aPrice) / 100.0;
	}
}

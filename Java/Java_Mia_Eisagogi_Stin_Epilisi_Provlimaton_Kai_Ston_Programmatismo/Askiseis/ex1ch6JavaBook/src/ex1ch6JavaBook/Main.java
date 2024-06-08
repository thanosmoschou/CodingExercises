/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Tax computation with static methods
 */

package ex1ch6JavaBook;

public class Main 
{

	public static void main(String[] args) {
	    double myTax = 32500.534;
		
		System.out.println(Tax.computeCostBasic(myTax) + "\n" + Tax.computeCostLuxury(myTax));
		Tax.changeBasicRateTo(0.69);
		Tax.changeLuxuryRate(1.45);
		System.out.println(Tax.computeCostBasic(myTax) + "\n" + Tax.computeCostLuxury(myTax));
		
		myTax = 12.567;
		System.out.println(Tax.roundToNearestPenny(myTax));
		
	}

}

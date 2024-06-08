/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: rational numbers
 */


public class Main 
{

	public static void main(String[] args) 
	{
		Rational r1 = new Rational(100, 35);
		Rational r2 = new Rational(12, 3);
		
		System.out.println("GCD of " + r1.getNumerator() + " and " + r1.getDenominator() + " = " + r1.getGCD());
		System.out.println("GCD of " + r2.getNumerator() + " and " + r2.getDenominator() + " = " + r2.getGCD());
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(r1.getDenominator());
		System.out.println(r2.getNumerator());
		System.out.println(r1.getValue());
		System.out.println(r2.getValue());
	
	}

}

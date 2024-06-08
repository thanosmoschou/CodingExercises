/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: rational numbers
 */


public class Rational
{
	private int numerator;
	private int denominator;
	
	
	public Rational()
	{
		numerator = 0;
		denominator = 1;
	}
	
	
	public Rational(int aNumer, int aDenom)
	{
		
		simplify(aNumer, aDenom);
	}
	
	
	private void simplify(int aNumer, int aDenom)
	{
		int divisor = gcd(aNumer, aDenom);
		
		//i need the numbers at the simplest form
		numerator = aNumer / divisor;
		denominator = aDenom / divisor;
	}
	
	
	private int gcd(int num1, int num2)
	{
		//gcd(a,b) = gcd(b, a mod b) ... until a mod b = 0 so gcd is b
		//gcd(10, 3) = gcd(3, 10 mod 3) = gcd(3, 1) = gcd(1, 3 mod 1) = gcd(1,0) -> gcd=1
		
		int temp1, temp2, temp3;
		
		temp1 = num1;
		temp2 = num2;
		
		while(temp1 % temp2 != 0)
		{
			temp3 = temp1;
			temp1 = temp2;
			temp2 = temp3 % temp1;
		}
		
		System.out.println("GCD of " + num1 + " and " + num2 + " = " + temp2);
		
		return temp2;
	}
	
	
	public int getGCD()
	{
		return gcd(numerator, denominator);
	}
	
	
	public double getValue()
	{
		return (double) numerator / denominator;
	}
	
	
	public int getNumerator()
	{
		return numerator;
	}
	
	
	public int getDenominator()
	{
		return denominator;
	}
	
	
	public String toString()
	{
		return numerator + "/" + denominator;
	}
}

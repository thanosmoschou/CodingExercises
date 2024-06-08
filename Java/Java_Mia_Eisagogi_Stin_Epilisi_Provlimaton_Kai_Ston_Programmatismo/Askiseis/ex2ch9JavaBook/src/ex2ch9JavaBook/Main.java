/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions
 */

package ex2ch9JavaBook;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args) 
	{
		int divident;
		int divisor;
		Scanner in = new Scanner(System.in);
		String decision;
		
		while(true)
		{
			try 
			{
				System.out.println("Please enter the divident: ");
				divident = in.nextInt();
				
				System.out.println("Please enter the divisor: ");
				divisor = in.nextInt();
				
				if(divisor == 0)
					throw new DivisionByZeroException();
				
				if(divident < 0 || divisor < 0) //i checked already if divisor == 0
					throw new NegativeNumberException();
				
				System.out.println("The modulo of division " + divident + "/" + divisor + "=" + (divident % divisor));
				
			}
			catch(DivisionByZeroException e)
			{
				System.out.println(e.getMessage());
			}
			catch(NegativeNumberException e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				in.nextLine(); //to clean the input stream from remained characters
				System.out.println("Continue Y/N? ");
				decision = in.nextLine();
				
				if(decision.equalsIgnoreCase("N"))
					break;	
			}
		}

	}

}

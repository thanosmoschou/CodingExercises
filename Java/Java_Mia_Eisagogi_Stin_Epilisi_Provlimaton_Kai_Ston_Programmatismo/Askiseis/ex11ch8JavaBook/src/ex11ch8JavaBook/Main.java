/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package ex11ch8JavaBook;

public class Main 
{
	public static void main(String[] args)
	{
		BulkDiscount prod1 = new BulkDiscount(3, 0.30);
		
		System.out.println("Total Discount for products: " + prod1.computeDiscount(4, 3.40));
		System.out.println("Discount percent: " + prod1.getPercent());
		System.out.println("Minimum amount for percent: " + prod1.getMinimum());
		
		prod1.setMinimum(4);
		prod1.setPercent(0.205);
		
		System.out.println("Total Discount for products: " + prod1.computeDiscount(3, 3.40));
		System.out.println("Discount percent: " + prod1.getPercent());
		System.out.println("Minimum amount for percent: " + prod1.getMinimum());
		
		System.out.println("Total Discount for products: " + prod1.computeDiscount(10, 3.40));

		
	}
}

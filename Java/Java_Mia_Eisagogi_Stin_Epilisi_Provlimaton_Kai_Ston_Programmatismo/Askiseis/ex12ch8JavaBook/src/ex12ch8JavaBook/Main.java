/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 * 
 */


package ex12ch8JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		BuyNItemsGetOneFree prod = new BuyNItemsGetOneFree(10);
		
		System.out.println("Total discount for 5 products: " + prod.computeDiscount(5, 5));
		System.out.println("Total discount for 15 products: " + prod.computeDiscount(15, 8));

		System.out.println("Discount counts every " + prod.getAmount() + " products");
		prod.setAmount(8);
		
		System.out.println("Total discount for 16 products: " + prod.computeDiscount(16, 8));

	}

}

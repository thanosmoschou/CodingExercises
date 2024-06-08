/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 * 
 */

package ex12ch8JavaBook;

public class BuyNItemsGetOneFree extends DiscountPolicy
{
	private int amount;
	
	public BuyNItemsGetOneFree(int n)
	{
		this.amount = n;
	}
	
	
	public double computeDiscount(int count, double itemCost)
	{
		double disc = 0;
		
		for(int i = 1; i <= count; i++)
		{
			if(i % amount == 0 && i > 0)
				disc += itemCost; //every amount products i get 1 for free so i add its value to the total discount
		}
		
		return disc;
	}
	
	
	public void setAmount(int anAmount)
	{
		this.amount = anAmount;
	}
	
	
	public int getAmount()
	{
		return amount;
	}
}

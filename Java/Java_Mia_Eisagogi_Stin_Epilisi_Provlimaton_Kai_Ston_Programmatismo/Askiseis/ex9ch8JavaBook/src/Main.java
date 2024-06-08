/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: understanding abstract classes
 */


public class Main 
{

	public static void main(String[] args) 
	{
		RegularPay rp1 = new RegularPay(0.45);
		HazardPay hp1 = new HazardPay(0.56);
		
		System.out.println("Pay for 40 hours of work: " + rp1.computePay(40));
		rp1.setPayRate(0.37);
		System.out.println("Pay for 40 hours of work with the new rate: " + rp1.computePay(40));

		System.out.println("===========");
		
		System.out.println("Pay for 40 hours of work: " + hp1.computePay(40));
		hp1.setPayRate(0.67);
		System.out.println("Pay for 40 hours of work with the new rate: " + hp1.computePay(40));

	}

}

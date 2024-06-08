/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Simple simulation of a credit card
 * */

package ex1ch5JavaBook;

public class Main
{

	public static void main(String[] args) 
	{
		CreditCard myCreditCard = new CreditCard("1234 5678 9000 1344", "09/2026", "567");
		
		myCreditCard.printCardInfo();
		myCreditCard.addMoney();
		myCreditCard.subtractMoney();
		myCreditCard.viewTransactionHistory();
		myCreditCard.printCardInfo();
		
	}

}

/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Simple simulation of a credit card
 * */

package ex1ch5JavaBook;

import java.util.ArrayList;
import java.util.Scanner;

public class CreditCard 
{
	private String cardNumber;
	private String expireDate;
	private String cvc;
	private double amount;
	private ArrayList<String> transactionHistory = new ArrayList<String>();
	
	
	public CreditCard(String aCardNumber, String anExpireDate, String aCvc)
	{
		this.cardNumber = aCardNumber;
		this.expireDate = anExpireDate;
		this.cvc = aCvc;
		amount = 0;
	}
	
	
	public void addMoney()
	{
		double money;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter the amount of money you want to add to your card: ");
		money = keyboard.nextDouble();

		if(money > 0)
		{
			amount += money;
			
			String trans = "Add: " + money + " Total amount: " + amount; //update the transaction history
			transactionHistory.add(trans);
		}
		else
			System.out.println("Do not insert negative or zero values...\nTransaction declined");
				
		printCardInfo();
	}
	
	
	public void subtractMoney()
	{
		double money;
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter the amount of money you want to deposit from your card: ");
		money = keyboard.nextDouble();
		
		if(amount - money >= 0)
		{
			amount -= money;
			
			String trans = "Deposit: " + money + " Total amount: " + amount;
			transactionHistory.add(trans);
			
			printCardInfo();
		}
		else
		{
			System.out.println("Not enough amount...\nTransaction declined...");
		}
	}
	
	
	public void printCardInfo()
	{
		System.out.println("------------------");
		System.out.println("CARD NUMBER: " + cardNumber + "\n" + "EXPIDE DATE: " + expireDate +
				"\n" + "CVC: " + cvc + "\n" + "Total amount: " + amount + "\n");
		
		viewTransactionHistory();
		
	}
	
	
	public void viewTransactionHistory()
	{
		if(transactionHistory.size() > 0)
		{
			System.out.println("TRANSACTION HISTORY: ");
			for(String tr: transactionHistory)
			{
				System.out.println("--------------");
				System.out.println(tr);
			}
			System.out.println("");
		}
	}
}

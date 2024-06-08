/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: Simple bank account system exercise for java revision
 */

package rev3;

public class BankAccount 
{
	private double balance;
	

	public BankAccount(double amount) 
	{
		this.balance = amount;
	}
	
	
	public BankAccount() 
	{
		this.balance = 0;
	}

	
	public void printInfo()
	{
		System.out.println("Account balance: " + balance);
	}
	
	public void deposit(double anAmount)
	{
		balance += anAmount;
		System.out.println("Successful deposit to account.");
	}
	
	
	public void withdraw(double anAmount)
	{
		if(balance - anAmount >= 0)
		{
			balance -= anAmount;
			System.out.println("Successful withdraw with amount " + anAmount);
			System.out.println("Available amount left: " + balance);
		}
		else
			System.out.println("Not enough amount available in order to withdraw.");
	}
	
	
	public double getBalance() 
	{
		return balance;
	}
	
	
	
}

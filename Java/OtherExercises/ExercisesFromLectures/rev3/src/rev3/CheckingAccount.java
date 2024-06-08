/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: Simple bank account system exercise for java revision
 */

package rev3;

public class CheckingAccount extends BankAccount
{
	private int counterOfTransactions;
	private final int transactionsLimitWithoutFee = 3;
	private double totalFees;
	private final double feePrice = 2; 
	
	public CheckingAccount(double anAmount)
	{
		super(anAmount);
		this.counterOfTransactions = 0;
		this.totalFees = 0;
	}
	
	
	public CheckingAccount()
	{
		super();
		this.counterOfTransactions = 0;
		this.totalFees = 0;
	}
	
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Number of transactions before any fees: " + counterOfTransactions);
		System.out.println("Total fees until deduction: " + totalFees);
		System.out.println("-----");
	}
	
	
	private void isTheTransactionWithoutFee()
	{
		if(counterOfTransactions > transactionsLimitWithoutFee)
		{
			System.out.println("More than " + transactionsLimitWithoutFee + ".Fees now are " + feePrice + " per transaction.");
			totalFees += feePrice;
		}
		else
			System.out.println("There are not any fees yet in your transactions");
	}
	
	
	public void withdraw(double anAmount, boolean feeDeduc)
	{
		isTheTransactionWithoutFee();
		
		if(!feeDeduc)
		{
			super.withdraw(anAmount);
			counterOfTransactions++;
		}
		else
		{
			if(this.getBalance() < anAmount && this.getBalance() > 0)
				super.withdraw(this.getBalance()); //withdraw all the remain money
		}	
	}
	
	
	public void deposit(double anAmount)
	{
		isTheTransactionWithoutFee();
		
		super.deposit(anAmount);
		counterOfTransactions++;
	}
	
	
	public void feesDeduction()
	{
		//first reset the counter so the deduction is without any other fees
		counterOfTransactions = 0;
		
		//if there are not enough money we just take the remain money from the account
		this.withdraw(totalFees, true);
		totalFees = 0;
		
	}
	
}

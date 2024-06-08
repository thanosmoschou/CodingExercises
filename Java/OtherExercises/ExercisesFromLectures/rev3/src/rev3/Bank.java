/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: Simple bank account system exercise for java revision
 */

package rev3;

import java.util.ArrayList;

public class Bank 
{
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public void addAccount(BankAccount anAccount)
	{
		accounts.add(anAccount);
		System.out.println("Account added successfully");
	}
	
	
	public void printAllAccountsInfo()
	{
		for(BankAccount b : accounts)
			b.printInfo();
	}
}

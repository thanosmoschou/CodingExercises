/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: Simple bank account system exercise for java revision
 */

package rev3;

public class TesterAccount 
{
	public static void main(String[] args)
	{
		SavingsAccount s1 = new SavingsAccount(0.5);
		CheckingAccount c1 = new CheckingAccount(100);
		Bank b = new Bank();
		
		s1.deposit(10000);
		s1.transfer(c1, 2000);
		c1.withdraw(1500);
		c1.withdraw(80);
		s1.transfer(c1, 1000);
		c1.withdraw(400);
		s1.anatokismos();
		c1.feesDeduction();
		
		b.addAccount(s1);
		b.addAccount(c1);
		b.printAllAccountsInfo();
	}
}

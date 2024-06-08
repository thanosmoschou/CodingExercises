/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: Simple bank account system exercise for java revision
 */

package rev3;

public class SavingsAccount extends BankAccount
{
	private double epitokio;
	
	public SavingsAccount(double anAmount, double enaEpitokio)
	{
		super(anAmount);
		this.epitokio = enaEpitokio;
	}
	
	
	public SavingsAccount(double enaEpitokio)
	{
		super();
		this.epitokio = enaEpitokio;
	}
	
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Epitokio: " + epitokio);
		System.out.println("-----");
	}
	
	
	public void transfer(BankAccount anAccount, double anAmount)
	{
		//transfer money means that i can call the deposit method for the anAccount method inside the transfer method
		anAccount.deposit(anAmount);
		System.out.println("Successful transfer.");
	}
	
	
	public void anatokismos()
	{
		double tokos = this.getBalance() * epitokio / 100;
		
		this.withdraw(tokos);
		
		System.out.println("Tokos: " + tokos);
		System.out.println("Epitixis anatokismos");
	}


	public double getEpitokio() 
	{
		return epitokio;
	}
	
	
}

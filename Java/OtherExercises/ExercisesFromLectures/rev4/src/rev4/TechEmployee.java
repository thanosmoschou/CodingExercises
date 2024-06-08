/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: simple inheritance exercise for revision
 */

package rev4;

public class TechEmployee extends Employee
{
	private double bonus;

	public TechEmployee(String name, double salaryWithoutDeduction, double bonus, double kratiseis) 
	{
		super(name, salaryWithoutDeduction, kratiseis);
		this.bonus = bonus;
	}
	
	
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Salary with deduction bonus included: " + (this.getSalaryWithDeduction() + this.bonus));
		System.out.println("-----");
	}
	
	
	public double getBonus()
	{
		return this.bonus;
	}
}

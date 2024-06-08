/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: simple inheritance exercise for revision
 */

package rev4;

public class Employee 
{
	private String name;
	private double kratiseis;
	private double salaryWithoutDeduction;
	private double salaryWithDeduction;
	
	public Employee(String name, double salaryWithoutDeduction, double kratiseis) 
	{
		this.name = name;
		this.kratiseis = kratiseis;
		this.salaryWithoutDeduction = salaryWithoutDeduction;
		this.salaryWithDeduction = (1 - this.kratiseis) * this.salaryWithoutDeduction;
	}
	
	
	public void printInfo()
	{
		System.out.println("Name: " + name);
		System.out.println("Salary without deduction: " + salaryWithoutDeduction);
		System.out.println("Salary with deduction: " + salaryWithDeduction);
		System.out.println("-----");
	}


	public String getName() 
	{
		return name;
	}


	public double getSalaryWithoutDeduction()
	{
		return salaryWithoutDeduction;
	}


	public double getSalaryWithDeduction() 
	{
		return salaryWithDeduction;
	}
	
	
	
}

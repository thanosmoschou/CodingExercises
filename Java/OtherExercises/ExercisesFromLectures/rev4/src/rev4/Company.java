/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: simple inheritance exercise for revision
 */

package rev4;

import java.util.ArrayList;
import java.util.Scanner;

public class Company 
{
	private String name; 
	private ArrayList<Employee> employees = new ArrayList<>();
	
	public Company(String aName)
	{
		this.name = aName;
	}
	
	
	public void addEmployee()
	{
		int type;
		String name;
		Scanner in = new Scanner(System.in);
		double salaryWithoutDed;
		Employee createdEmployee = null;
		
		System.out.println("Enter 1 for a simple employee or 2 for a tech employee");
		type = in.nextInt();
		in.nextLine();
		
		System.out.println("Please enter a name: ");
		name = in.nextLine();
		
		System.out.println("Please enter the full salary without deduction fees: ");
		salaryWithoutDed = in.nextDouble();
		
		
		if(type == 1)
		{
			createdEmployee = new Employee(name, salaryWithoutDed, 0.2);
		}
		else
		{
			double bonus; 
			
			System.out.println("Please enter bonus: ");
			bonus = in.nextDouble();
			
			createdEmployee = new TechEmployee(name, salaryWithoutDed, bonus, 0.3);
		}
		
		employees.add(createdEmployee);
		System.out.println("Employee created and added successfully to the company.");
	}
	
	
	public void printAllEmployees()
	{
		for(Employee e : employees)
			e.printInfo();
	}
	
	
	public void ektiposiMisthodosias()
	{
		double total = 0;
		
		for(Employee e : employees)
		{
			if(e instanceof TechEmployee)
			{
				TechEmployee e1 = (TechEmployee) e;
				total += (e1.getSalaryWithDeduction() + e1.getBonus());	
			}
			else
				total += e.getSalaryWithDeduction();
		}
		
		System.out.println("Sinoliki misthodosia: " + total);
	}
}

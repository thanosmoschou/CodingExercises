/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */


public class Main
{

	public static void main(String[] args)
	{
		Employee emp1 = new Employee("Kostas", 670.90, 2022, "abc2434");
		Employee emp2 = new Employee("Alex", 640.90, 2019, "ade2434");
		Person per1 = new Person("Alex");
		
		per1.writeOutput();
		per1.setName("John");
		System.out.println("Person\'s name: " + per1.getName());
		per1.writeOutput();
		
		emp1.writeOutput();
		emp2.writeOutput();
		
		emp1.setHireYear(2020);
		System.out.println("Employee 1 hire year: " + emp1.getHireYear());
		
		emp2.setName("Kostas");
		emp2.writeOutput();
		
		emp1.setPay(710.19);
		System.out.println("Employee 1 pay: " + emp1.getPay());
		System.out.println("Employee 2 ref id: " + emp2.getRefId());
		
		System.out.println("Has employee 1 the same name as employee 2? " + emp1.hasSameName(emp2));

	}

}

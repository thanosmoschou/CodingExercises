/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

public class Main 
{

	public static void main(String[] args)
	{
		Person per1 = new Person("Alex");
		Person per2 = new Person("John");
		
		Vehicle v1 = new Vehicle("Ford", 16, per1);
		Truck t1 = new Truck("Man", 48, per2, 16000, 6000);
		
		System.out.println("Have the truck and the vehicle the same owner? " + t1.equals(v1));
		t1.setOwner(per1);
		
		System.out.println("Have the truck and the vehicle the same owner? " + t1.equals(v1));
		
		

	}

}

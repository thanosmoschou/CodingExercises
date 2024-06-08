/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Simulate the borrowing simulation of a school library
 */


public class Main 
{
	public static void main(String[] args)
	{
		Book b1 = new Book("ds123");
		Scientific s1 = new Scientific("Physics", "sd244");
		Programming p1 = new Programming("Programming", "fd120", "Java");
		
		//initial value of borrow is false which means that it is not borrowed yet 
		//so it would return false which corrupts the sense of the sentence
		//warning because programming books cannot be borrowed
		System.out.println("Can b1 be borrowed? " + !b1.getBorrow()); 
		System.out.println("B1 ID: " + b1.getId());
		b1.borrow();
		b1.printInfo();
		b1.setBorrow(false);
		System.out.println("Can b1 be borrowed? " + !b1.getBorrow()); 

		System.out.println("=============");
		
		s1.printInfo();
		System.out.println("S1 ID: " + s1.getId());
		s1.borrow();
		s1.printInfo();
		
		System.out.println("=============");
		
		p1.printInfo();
		p1.borrow();
		System.out.println("P1 ID: " + p1.getId() + " Borrowed? " + p1.getBorrow());
		
	}
}

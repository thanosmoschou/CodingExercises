/*
 * Author: Thanos Moschou
 * Description: This is a small program that helped me to learn more about annotations in Java.
 * Last Modification Date: 15/12/2023
 */


public class Dog extends Animal
{
	private String sound;
	
	public Dog(String aName)
	{
		super(aName);
		this.sound = "Woof";
	}

	
	@RunImmediately(repeat = 4)
	public void makeSound() 
	{
		System.out.println(this.sound);
	}
	
	
}

/*
 * Author: Thanos Moschou
 * Description: This is a small program that helped me to learn more about annotations in Java.
 * Last Modification Date: 15/12/2023
 */


@VeryImportant //or @VeryImportant(times = 3) or any number you want
public class Cat extends Animal
{
	private String sound;
	
	public Cat(String aName)
	{
		super(aName);
		this.sound = "Meow";
	}

	//You cannot annotate a method with @VeryImportant() because this annotation is only for Classes
	public void makeSound() 
	{
		System.out.println(this.sound);
	}
	
	
}

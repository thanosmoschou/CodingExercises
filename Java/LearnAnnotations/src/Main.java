/*
 * Author: Thanos Moschou
 * Description: This is a small program that helped me to learn more about annotations in Java.
 * Last Modification Date: 15/12/2023
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main 
{

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		Animal cat = new Cat("mia");
		Animal dog = new Dog("max");
		
		/* From the official Java documentation:
		 * public final class Class<T> 
		 * extends Object 
		 * implements Serializable, GenericDeclaration, Type, AnnotatedElement
		 * 
		 * Type Parameters:
		 * T - the type of the class modeled by this Class object. For example, the type of String.class is Class<String>. Use Class<?> if the class being modeled is unknown.
		 * 
		 * Instances of the class Class represent classes and interfaces in a running Java application. 
		 * An enum is a kind of class and an annotation is a kind of interface. 
		 * Every array also belongs to a class that is reflected as a Class object that is shared by all arrays with the same element type and number of dimensions. 
		 * The primitive Java types (boolean, byte, char, short, int, long, float, and double), and the keyword void are also represented as Class objects.
		 * 
		 * Class has no public constructor. Instead Class objects are constructed automatically by the Java Virtual Machine as classes are loaded and by calls to the defineClass method in the class loader.
		 * 
		 * The following example uses a Class object to print the class name of an object:
		 * 
		 * void printClassName(Object obj) 
		 * {
		 *     System.out.println("The class of " + obj +
		 *     " is " + obj.getClass().getName());
		 * }
		 * 
		 * It is also possible to get the Class object for a named type (or for void) using a class literal. See Section 15.8.2 of The Java™ Language Specification. For example:
		 * 
		 * System.out.println("The name of class Foo is: " + Foo.class.getName());
		 */
		
		//check if Cat has the VeryImportant annotation
		if(cat.getClass().isAnnotationPresent(VeryImportant.class))
			System.out.println("This is very important");
		else
			System.out.println("This is not very important");
		
		//check if Dog has the VeryImportant annotation
		if(dog.getClass().isAnnotationPresent(VeryImportant.class))
			System.out.println("This is very important");
		else
			System.out.println("This is not very important");
		
		
		//Now let's get the declared methods from Dog class and see if 
		//a method has RunImmediately annotation. If yes then we will invoke it.
		//To get Dog class declared methods I will use dog object I just created before.
		//getClass() will return an instance of class Class that represents the class of dog object.
		//Check Java documentation for more information about getClass method
		//I use Java Reflection
		for(Method method : dog.getClass().getDeclaredMethods())
			if(method.isAnnotationPresent(RunImmediately.class))
			{
				//get the annotation
				RunImmediately annotation = method.getAnnotation(RunImmediately.class);
				
				//now let's call the method
				for(int i = 0; i < annotation.repeat(); i++)
					method.invoke(dog);
			}

	}

}

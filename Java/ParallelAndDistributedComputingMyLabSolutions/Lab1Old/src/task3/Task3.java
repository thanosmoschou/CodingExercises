/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

/*
Anonymous Classes in Java

Anonymous classes in Java are a special type of inner class that are defined and instantiated in a single statement.
They are typically used when you need to create an instance of a class with slight modifications or to implement an interface
on the fly, without the need to create a separate named class.

Key Characteristics of Anonymous Classes:

No Name: As the name implies, anonymous classes do not have a name. This makes them ideal for short-term use where the
class definition does not need to be reused.

Defined Inline: An anonymous class is defined directly at the point where it is used, often within a method or as an
argument to a method. This makes the code concise but can also reduce readability if overused.

Can Extend a Class or Implement an Interface: Anonymous classes are usually created by extending an existing class or
implementing an interface. You can override methods of the superclass or provide implementations for the methods of the
interface within the anonymous class.

Single Use: Since the class is anonymous and typically used for a single, specific purpose, it cannot be reused elsewhere
in the codebase.

Limited to One Instance: Anonymous classes are generally used when you need only one instance of a class.
The class cannot be instantiated more than once in the same way, unless defined again elsewhere.

Cannot Have a Constructor: Unlike normal classes, you cannot define a constructor for an anonymous class because it has no name.
However, you can use an initializer block to perform any necessary setup.

Example of an Anonymous Class Implementing an Interface:
interface Greeting {
    void sayHello();
}

public class Main {
    public static void main(String[] args) {
        // Creating an anonymous class that implements the Greeting interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };

        // Using the anonymous class
        greeting.sayHello();
    }
}

Example of an Anonymous Class Extending a Class:
public class Main {
    public static void main(String[] args) {
        // Creating an anonymous class that extends the Thread class
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("This is an anonymous thread!");
            }
        };

        // Starting the thread
        thread.start();
    }
}


Advantages of Anonymous Classes:
Conciseness: They allow you to define and use a class on the spot, making your code more compact.
Simplicity: Ideal for simple, short-lived tasks such as event handling or callbacks.
Localized Use: They keep the class definition close to the point of use, which can make the code easier to
understand in certain contexts.

Limitations of Anonymous Classes:
Readability: The use of anonymous classes can sometimes make the code harder to read, especially for those not
familiar with the concept.
No Reuse: Since they have no name, you cannot reuse the class definition elsewhere in your program.
Complexity for Larger Classes: If the logic required is complex or extensive, anonymous classes can lead to messy code.
In such cases, a named class might be more appropriate.
Anonymous classes are a powerful tool in Java, especially for quick and simple implementations,
but they should be used judiciously to maintain code clarity and readability.

Some other notes:

You can call a method that is declared inside an anonymous class, but you can only do this from within that anonymous
class itself or through certain workarounds, depending on the scope and how the method is defined.

Calling the Method from Within the Anonymous Class
Inside the anonymous class, you can call any methods that you've defined within that class. This is straightforward, as shown in the example below:
public class Main {
    public static void main(String[] args) {
        // Creating an anonymous class that extends the Thread class
        Thread thread = new Thread() {
            // Method defined inside the anonymous class
            void customMethod() {
                System.out.println("Custom method inside the anonymous class.");
            }

            @Override
            public void run() {
                // Calling the custom method from within the anonymous class
                customMethod();
            }
        };

        // Starting the thread, which will call the run() method
        thread.start();
    }
}

Calling the Method from Outside the Anonymous Class
If you want to call the method from outside the anonymous class, it becomes more challenging because the method is not
accessible directly (since the anonymous class has no name and the method is not part of a known interface or superclass).

Summary
Inside the Anonymous Class: You can freely call any methods declared within the anonymous class from other methods in that same class.
Outside the Anonymous Class: To call a method from outside the anonymous class, you typically need to use reflection or ensure that the
method is part of an interface or superclass that the anonymous class implements or extends.
Using an interface is usually the best approach for cases where you need to call methods from outside, as it provides a clear and type-safe way to interact with the anonymous class.

A few more things about anonymous classes...

Anonymous Class: Here, you're creating a new instance of the Thread class
using an anonymous class. This is done with the new Thread() { ... } declaration,
where you provide the implementation of the run() method inside the curly braces {}.

Overriding the run() Method: Inside the anonymous class, you override the run()
method, which contains the code you want to execute when the thread starts.

Starting the Thread: You use the start() method to start the thread.
This method will call the run() method of the anonymous class.

If you need to pass data or perform some initialization in the anonymous class,
you can use an initializer block.

Initializer Block: The initializer block is used to initialize the value variable
when the anonymous class is created.

run() Method: The run() method uses this initialized value when the thread is
executed.

Using an anonymous class that extends Thread is useful when you want to
quickly create and use a thread without needing to write a full, separate class.
 */

package task3;

public class Task3
{
    public static void main(String[] args) {
        int size = 10;
        MyThread1[] th1Arr = new MyThread1[size];
        Thread[] th2Arr = new Thread[size];

        for (int i = 0; i < size; i++)
        {
            th1Arr[i] = new MyThread1(); //inner class...

            //Here I create a class that extends Thread class
            th2Arr[i] = new Thread() { //anonymous class...
                private int myId;

                //Initializer block
                {
                    myId = (int) (Math.random() * 100);
                }

                @Override
                public void run()
                {
                    System.out.println("Hello from: " + Thread.currentThread().getName() + " with id: " + this.myId);
                }
            };

            th1Arr[i].start();
            th2Arr[i].start();
        }

        /*
        Keep in mind that the print order of threads is random...
         */

        for (int i = 0; i < size; i++)
        {
            try
            {
                th1Arr[i].join();
                th2Arr[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("All threads are done...");
    }

    //Inner class
    public static class MyThread1 extends Thread
    {
        private int myId;

        public MyThread1()
        {
            this.myId = (int) (Math.random() * 100);
        }

        @Override
        public void run()
        {
            System.out.println("Hello from: " + Thread.currentThread().getName() + " with id: " + this.myId);
        }
    }
}
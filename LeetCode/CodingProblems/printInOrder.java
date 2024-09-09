/*
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

 

Example 1:

Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 

Constraints:

nums is a permutation of [1, 2, 3].
*/

class Foo 
{
    private int ctr;

    public Foo() 
    {
        ctr = 1;
    }

    public synchronized void first(Runnable printFirst) //throws InterruptedException 
    {
        try {
            while (ctr != 1)
                wait();
            
            printFirst.run();
            ctr = 2;
            
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // printFirst.run() outputs "first". Do not change or remove this line.        
    }

    public synchronized void second(Runnable printSecond) //throws InterruptedException 
    {
         try {  
            while (ctr != 2)
                wait();
            
            printSecond.run();
            ctr = 3;
            
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void third(Runnable printThird) //throws InterruptedException 
    {
         try {     
            while (ctr != 3)
                wait();

            printThird.run();
            ctr = 1;

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*I proigoumeni lisi einai lisi me monitor class. Epeidi einai monitor ths java den evala condition variables kai ola ta threads tha perimenoun sto wait set tou epopti.
 * Omos auto tha exei polles epipleon afipniseis opote paratheto kai mia lisi me condition variables kai locks...i parakato lisi einai pio grigori.
 */

 class Foo 
{
    private int ctr;
    private Lock lock;
    private Condition cond1;
    private Condition cond2;
    private Condition cond3;

    public Foo() 
    {
        ctr = 1;
        lock = new ReentrantLock();
        cond1 = lock.newCondition();
        cond2 = lock.newCondition();
        cond3 = lock.newCondition();
    }

    public void first(Runnable printFirst) //throws InterruptedException 
    {
        try {
            lock.lock();

            while (ctr != 1)
                cond1.await();
            
            printFirst.run();
            ctr = 2;
            
            cond2.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) //throws InterruptedException 
    {
         try {
            lock.lock();

            while (ctr != 2)
                cond2.await();
            
            printSecond.run();
            ctr = 3;
            
            cond3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) //throws InterruptedException 
    {
         try {    
            lock.lock();

            while (ctr != 3)
                cond3.await();
            
            printThird.run();
            ctr = 1;
            
            cond1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

//Mporeis na to liseis kai me semaphores...
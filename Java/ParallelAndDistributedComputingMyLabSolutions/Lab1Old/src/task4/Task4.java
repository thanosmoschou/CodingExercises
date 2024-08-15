/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task4;

public class Task4
{
    public static void main(String[] args)
    {
        MyThread th1 = new MyThread();
        th1.start();

        try
        {
            th1.join(); //main thread waits for th1 to finish in order to continue...
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println("All threads are done...");
    }
}
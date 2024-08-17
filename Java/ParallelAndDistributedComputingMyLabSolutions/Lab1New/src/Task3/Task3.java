/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package Task3;

public class Task3
{
    public static void main(String[] args)
    {
        int size = 10;
        Thread[] threads = new Thread[size];

        for (int i = 0; i < size; i++)
        {
            threads[i] = new Thread(new MyRunnable(i));
            threads[i].start();
        }

        for (int i = 0; i < size; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads are done...");
    }
}
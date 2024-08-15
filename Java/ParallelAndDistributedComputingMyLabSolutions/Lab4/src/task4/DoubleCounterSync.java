/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab solutions...
 */

package task4;

public class DoubleCounterSync
{
    public static void main(String[] args)
    {
        int totalThreads = Runtime.getRuntime().availableProcessors();
        MyThread[] threads = new MyThread[totalThreads];

        DoubleCounter counter = new DoubleCounter();

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new MyThread(counter);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e) {}
        }

        System.out.println("Counter 1: " + counter.getFirstCounter() + " Counter 2: " + counter.getSecondCounter());
    }
}

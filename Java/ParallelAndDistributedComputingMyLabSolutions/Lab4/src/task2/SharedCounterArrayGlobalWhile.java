/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab solutions...
 */

package task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//I need locks...I will fix it to the next tasks...
public class SharedCounterArrayGlobalWhile
{
    public static void main(String[] args)
	{
		int numThreads = 4;
		CounterThread[] threads = new CounterThread[numThreads];

		int end = 10000; //orisma timis
		Shared shared = new Shared(end); //orisma anaforas

		for (int i = 0; i < numThreads; i++)
		{
			threads[i] = new CounterThread(shared);
			threads[i].start();
		}
	
		for (int i = 0; i < numThreads; i++)
		{
			try
			{
				threads[i].join();
			}
			catch (InterruptedException e) {}
		}

        shared.check_array();
    }

	static class Shared
	{
		private int counter;
		private int[] array;
		private int end;
		private Lock lock;


		public Shared(int anEnd)
		{
			lock = new ReentrantLock();
			counter = 0;
			end = anEnd;
			array = new int[end];
		}

		public void inc()
		{
			while (true)
			{
				//problematic...a lot of locks unlocks...we will learn how to fix this later on...
				//keep in mind that you need to protect comparisons also just like I am doing here...
				//maybe a thread will sleep before it will compare the values inside the if, and
				//another thread will modify the values...when the other thread will wake up, it
				//will not get the new values and it will compare the old ones...
				lock.lock();
				try
				{
					if (counter >= end)
						break;
					array[counter]++;
					counter++;
				}
				finally
				{
					lock.unlock();
				}
			}
		}

		public void check_array()
		{
			int i, errors = 0;

			System.out.println ("Checking...");

			for (i = 0; i < end; i++)
			{
				if (array[i] != 1)
				{
					errors++;
					System.out.printf("%d: %d should be 1\n", i, array[i]);
				}
			}

			System.out.println (errors+" errors.");
		}

	}

    static class CounterThread extends Thread
	{
		private Shared myShared;

		public CounterThread(Shared aShared)
		{
			myShared = aShared;
		}

		public void run()
		{
			myShared.inc();
		}            	
    }
}
  

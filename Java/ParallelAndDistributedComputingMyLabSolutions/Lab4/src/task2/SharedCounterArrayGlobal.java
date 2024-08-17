/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab solutions...
 */

package task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounterArrayGlobal
{
    public static void main(String[] args)
	{
		int numThreads = 4; //pernaei os orisma timis...
		CounterThread[] threads = new CounterThread[numThreads];

		int end = 1000; //pernaei os orisma timis...
		Shared shared = new Shared(numThreads, end); //pernaei sta nimata os orisma anaforas...

		for (int i = 0; i < numThreads; i++)
		{
			threads[i] = new CounterThread(shared);
			threads[i].start();
		}

		for (int i = 0; i < numThreads; i++)
		{
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

		shared.check_array();
    }

	static class Shared
	{
		private int numThreads;
		private int end;
		private int[] array;
		private Lock lock;

		public Shared(int someThreads, int anEnd)
		{
			lock = new ReentrantLock();
			numThreads = someThreads;
			end = anEnd;
			array = new int[end];
		}

		public void inc()
		{
			//Still problematic, but we will learn how to fix this to the next labs...
			//I should not put lock unlock inside a for loop because it will be doing a lot of
			//lock unlock stuff and as a result it will be slow...
			//Also it is wrong to put lock unlock and inside a for loop...it causes a sequential
			//execution which I do not want...
			for (int i = 0; i < end; i++)
			{
				for (int j = 0; j < i; j++)
				{
					lock.lock();
					try {
						array[i]++;
					} finally {
						lock.unlock();
					}
				}
			}
		}

		public void check_array ()
		{
			int i, errors = 0;

			System.out.println ("Checking...");

			for (i = 0; i < end; i++)
			{
				if (array[i] != numThreads*i)
				{
					errors++;
					System.out.printf("%d: %d should be %d\n", i, array[i], numThreads*i);
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
		   this.myShared = aShared;
		}

		public void run()
		{
		   myShared.inc();
		}            	
    }
}
  

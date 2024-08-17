/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab solutions...
 */

package task3;

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
		private Object lockObject;

		public Shared(int someThreads, int anEnd)
		{
			lockObject = new Object();
			numThreads = someThreads;
			end = anEnd;
			array = new int[end];
		}

		public void inc()
		{
			for (int i = 0; i < end; i++)
			{
				for (int j = 0; j < i; j++)
				{
					synchronized (lockObject)
					{
						array[i]++;
					}
				}
			}
		}

		public void check_array()
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
  

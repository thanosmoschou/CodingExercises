/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab solutions...
 */

package task3;

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
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

        shared.check_array();
    }

	static class Shared
	{
		private int counter;
		private int[] array;
		private int end;

		public Shared(int anEnd)
		{
			counter = 0;
			end = anEnd;
			array = new int[end];
		}

		//still a lot of locks unlocks from the threads...we will use local variables
		//inside our threads in the next labs...
		public synchronized void inc()
		{
			while (true)
			{
				if (counter >= end)
					break;
				array[counter]++;
				counter++;
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
  

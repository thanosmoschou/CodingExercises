/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.task2_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Tha kanoume dinamiki katanomi...
Paromoia taxitita me to sequential gia mikra noumera...gia na valo megalitera noumera na do ti ginetai...

int totalTasks = 1000000000;

number of primes 50847534
time in ms = 14121

number of primes 50847534
time in ms = 13565 (parallel)

vlepeis einai ligo pio grigori...
an otan svino ta multiples den valo locks tote pairno auto:
number of primes 50847534
time in ms = 8619

gia na kleidono kathe thesi ksexorista na do...den mporo otan exo poli megala noumera...den ftanei to heap...

 */

class SieveOfEratosthenes
{
	/*static int totalThreads;
	static boolean[] prime;
	static int totalTasks;
	static int tasksAssigned = -1;
	static Lock myLock = new ReentrantLock();*/

	public static void main(String[] args)
	{
		/*
		if (args.length != 1) {
			System.out.println("Usage: java SieveOfEratosthenes <size>");
			System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
    		System.exit(1);
		}
		if (size <= 0) {
				System.out.println("size should be positive integer");
	    		System.exit(1);
		}
		*/

		int totalTasks = 1000000000;
		int limit = (int) Math.sqrt(totalTasks) + 1;
		Buffer buffer = new Buffer(totalTasks, limit);
		//boolean[] primes = buffer.getBuffer();

		// get current time
		long startTime = System.currentTimeMillis();

		int totalThreads = 10;
		Thread[] threads = new Thread[totalThreads];

		for (int i = 0; i < totalThreads; i++)
		{
			//threads[i] = new MyThread(i, limit, totalThreads, shared, size);
			//threads[i] = new Thread(new Worker(i, limit, totalThreads, prime, size));
			//threads[i] = new Thread(new Worker(i, buffer, totalTasks, limit, primes));
			threads[i] = new Thread(new Worker(i, buffer, totalTasks, limit));
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

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-startTime;

		int count = buffer.getPrimes();

		//System.out.println("number of primes " + shared.findPrimes());
		System.out.println("number of primes " + count);
		System.out.println("time in ms = "+ elapsedTimeMillis);
	}


}

/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.task2_1;

//In this algorithm, static map allocation is not the ideal choice because the calculations do not have
//the same weight...

//Slower than sequential

/*
java SieveOfEratosthenes 1000000
number of primes 78498
time in ms = 9

With 3 threads...
number of primes 78498
time in ms = 41

I will try another approach...I will pass a shared array for all threads and see...
I will return to my shared object approach but I will not lock the whole array, but each position independently...
I know that it is inefficient but it offers better parallelization...let's see

The reduce process is taking extra time making our program slower than sequential...Let's try and apply only an
allocation procedure...So as a result I will pass some arrays from main to my threads...the shared object for some
reason didn't work properly here...

Without the copy of local array the program has almost the same speed as the sequential...let's see with the cyclic allocation
in task2_2
 */

class SieveOfEratosthenes
{
	public static void main(String[] args)
	{
		int size = 100000000;

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

		boolean[] prime = new boolean[size + 1];
		for (int i = 2; i <= size; i++)
			prime[i] = true;

		//Shared shared = new Shared(size);

		// get current time 
		long startTime = System.currentTimeMillis();

		int totalThreads = 10;
		MyThread[] threads = new MyThread[totalThreads];

		int limit = (int) Math.sqrt(size) + 1;
		for (int i = 0; i < totalThreads; i++)
		{
			//threads[i] = new MyThread(i, limit, totalThreads, shared, size);
			threads[i] = new MyThread(i, limit, totalThreads, prime, size);
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

		int count = 0;
		for(int i = 2; i <= size; i++)
			if (prime[i])
			{
				//System.out.println(i);
				count++;
			}

		//System.out.println("number of primes " + shared.findPrimes());
		System.out.println("number of primes " + count);
		System.out.println("time in ms = "+ elapsedTimeMillis);
	}

}

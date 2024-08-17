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

The reduce process is taking extra time making our program slower than sequential...Let's try and apply only an
allocation procedure...So as a result I will pass some arrays from main to my threads...the shared object for some
reason didn't work properly here...not enough heap space...so as a result apply only allocations without reduce for
this lab...

Without the copy of local array the program has almost the same speed as the sequential...let's see with the cyclic allocation
in task2_2

But I wanted to be as correct as possible with the patterns so I use local array in each thread for the map process
and then I pass it to the shared object for the reduce process no matter that is slower...Also for some reason
when I increase the number of threads when the size is small, the total prime number is not correct...maybe this
happens because some threads have wrong block allocations...but for example with size = 300000 and 3 threads I get a correct
result...with 10 threads I get slightly less primes...I guess with small limit and big number of threads, the
int result of limit/totalThreads is 0 (because the float result was less than 1 and bigger than 0 so truncation
leaved only the int part of the result which is 0)
so the start = id * block stays the same (id * 0)...
But with small number of threads it works just fine...
 */

class SieveOfEratosthenes
{
	public static void main(String[] args)
	{
		int size = 9000000;

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

		Shared shared = new Shared(size);

		// get current time 
		long startTime = System.currentTimeMillis();

		int totalThreads = 3;
		MyThread[] threads = new MyThread[totalThreads];

		int limit = (int) Math.sqrt(size) + 1;
		for (int i = 0; i < totalThreads; i++)
		{
			threads[i] = new MyThread(i, limit, totalThreads, shared, size);
			threads[i].start();
		}

		for (int i = 0; i < totalThreads; i++)
		{
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}
               
		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-startTime;

		System.out.println("number of primes " + shared.findPrimes());
		System.out.println("time in ms = "+ elapsedTimeMillis);
	}

}

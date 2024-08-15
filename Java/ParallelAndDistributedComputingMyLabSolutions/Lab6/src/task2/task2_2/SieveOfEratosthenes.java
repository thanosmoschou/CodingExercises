/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.task2_2;

/*
Me tin kikliki katanomi einai grigorotero apo to sequential...ostoso thelei megala noumera gia na fanei...
Na ipenthimiso oti kanonika otan pernas moirazomenous pinakes sta nimata prepei na parexeis prostasia kai
amoivaio apokleismo...kanonika leme me topiki metavliti kanoume apeikonisi (me opoion tropo epileksoume)
kai sto telos kano tin anagogi (eite me moirazomenous pinakes, eite me shared variables kai locks, eite me
shared object opos theleis)...edo einai periptosi kai den kaname anagogi sto telos alla kano entos tis for...
epishs gia kapoio logo (epeidi antigrafame olokliri domi dedomenon) i anagogi sto telos ekane to programma argo...
anyway...esi na thimasai ta vasika patterns...


results:
java SieveOfEratosthenes 1000000000
number of primes 50847534
time in ms = 13511

number of primes 50847534
time in ms = 9353 (parallel)
 */

class SieveOfEratosthenes
{
	public static void main(String[] args)
	{
		int size = 1000000000;

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

/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.task2_2;

/*
Me tin kikliki katanomi einai grigorotero apo to sequential...ostoso thelei megala noumera gia na fanei...
Einai pio grigoro an den kaneis reduce me sosto tropo (dil na to kaneis sto
telos me xrisi amoivaiou apokleismou) kai vazeis kateuthian ta apotelesmata sto shared pinaka, alla an
exeis apeikonisi me topikes metavlites kai sto telos kaneis reduce me amoivaio apokleismo einai kapos
pio argo kai einai logiko gt antigrafeis domes kai i ektelesi einai akolouthiaki kathos to kathe nima
prepei na parei to kleidoma gia na grapsei...ego protimo na eimai sostos me ta patterns kai as einai ligo
pio argo...

results (without correct reduce):
java SieveOfEratosthenes 1000000000
number of primes 50847534
time in ms = 13511

number of primes 50847534
time in ms = 9353 (parallel)

With reduce and 3 threads for the parallel:
java SieveOfEratosthenes 300000000
number of primes 16252325
time in ms = 4193

number of primes 16252325
time in ms = 7066

me megalitera noumera gia threads pali kati den paei kala kai xanei noumera...ostoso gia mikra noumera nimaton einai
komple...

*/

class SieveOfEratosthenes
{
	public static void main(String[] args)
	{
		int size = 300000000;

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

		int totalThreads = 5;
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

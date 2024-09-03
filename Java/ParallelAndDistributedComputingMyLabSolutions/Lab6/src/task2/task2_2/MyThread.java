package task2.task2_2;

public class MyThread extends Thread
{
    private int myId;
    //private Shared shared;
    //private boolean[] localPrimes;
    private boolean[] primes;
    private int size;
    private int limit;
    private int totalThreads;

    /*
    public MyThread(int i, int limit, int totalThreads, Shared sh, int size)
    {
        myId = i;
        this.limit = limit;
        this.totalThreads = totalThreads;
        shared = sh;
        this.size = size;
        localPrimes = new boolean[size + 1];

        for (int k = 2; i <= size; i++)
            localPrimes[i] = true;
    }
    */

    public MyThread(int i, int limit, int totalThreads, int size, boolean[] pr)
    {
        myId = i;
        this.limit = limit;
        this.totalThreads = totalThreads;
        this.size = size;
        this.primes = pr;
    }

    @Override
    public void run()
    {
        for (int p = myId + 2; p <= limit; p += totalThreads) //kanonika einai apo myId alla sto sieve of eratosthenis ksekinaei apo to myId+2...kai se kikliki pas mexri < alla edo einai eksairesi...
        {
            // If prime[p] is not changed, then it is a prime
            if (primes[p])
            {
                // Update all multiples of p
                for (int i = p * p; i <= size; i += p)
                    primes[i] = false;
            }
        }

        //shared.addResult(localPrimes);
    }
}

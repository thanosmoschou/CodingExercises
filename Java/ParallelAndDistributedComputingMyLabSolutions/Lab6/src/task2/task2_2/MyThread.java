package task2.task2_2;

public class MyThread extends Thread
{
    private int myId;
    //private Shared shared;
    //private boolean[] localPrimes;
    private int size;
    private int limit;
    private int totalThreads;
    private boolean[] primes;


    /*public MyThread(int i, int limit, int totalThreads, Shared sh, int size)
    {
        myId = i;
        this.limit = limit;
        this.totalThreads = totalThreads;
        shared = sh;
        this.size = size;
        localPrimes = new boolean[size + 1];

        for (int k = 2; i <= size; i++)
            localPrimes[i] = true;
    }*/

    public MyThread(int i, int limit, int totalThreads, boolean[] primes, int size)
    {
        myId = i;
        this.limit = limit;
        this.totalThreads = totalThreads;
        this.primes = primes;
        this.size = size;
    }

    @Override
    public void run()
    {
        /*
        O pinakas sto shared arxikopoiei oles tis theseis se true...
        To idio kanei kai to nima me ton topiko pinaka tou...
        Entos tis run kathe nima epeksergazetai diaforetiko kommati tou pinaka...
        Opote vlepeis oti kapoies times tis kanei false...
        Ara den xreiazetai na antigrapso oles tis times tou topikou ston original kathos
        kapoies einai idi true kai den exei nohma...ara antigrafo mono tis false...
         */

        //System.out.println("Reached for loop...");
        for (int p = myId + 2; p <= limit; p += totalThreads) //kanonika einai apo myId alla sto sieve of eratosthenis ksekinaei apo to myId+2...
        {
            // If prime[p] is not changed, then it is a prime
            /*if (localPrimes[p])
            {
                // Update all multiples of p
                for (int i = p * p; i <= size; i += p)
                    localPrimes[i] = false;

                //System.out.println("P: " + p + " " + localPrimes[p]);
            }*/

            if (primes[p])
            {
                // Update all multiples of p
                for (int i = p * p; i <= size; i += p)
                    primes[i] = false;

                //System.out.println("P: " + p + " " + localPrimes[p]);
            }
        }

        //shared.addResult(localPrimes);
    }
}

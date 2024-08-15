package task2.task2_1;

public class MyThread extends Thread
{
    private int myId;
    //private Shared shared;
    private int start;
    private int stop;
    //private boolean[] localPrimes;
    private int size;
    private boolean[] primes;


    /*
    public MyThread(int i, int limit, int totalThreads, Shared sh, int size)
    {
        myId = i;
        int block = limit / totalThreads;

        if (myId == 0)
            start = 2;
        else
            start = myId * block + 2;

        stop = start + block;
        if (myId == totalThreads - 1)
            stop = limit;

        shared = sh;
        this.size = size;
        localPrimes = new boolean[size + 1];

        for (int k = 2; i <= size; i++)
            localPrimes[i] = true;
    }
    */

    public MyThread(int i, int limit, int totalThreads, boolean[] pr, int size)
    {
        myId = i;
        int block = limit / totalThreads;

        if (myId == 0)
            start = 2;
        else
            start = myId * block + 2;

        stop = start + block;
        if (myId == totalThreads - 1)
            stop = limit;

        primes = pr;
        this.size = size;

        /*localPrimes = new boolean[size + 1];

        for (int k = 2; i <= size; i++)
            localPrimes[i] = true;*/
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
        I statiki katanomi den einai i kaliteri lisi gia auto to provlima kathos oi ipologismoi den exoun
        tin idia varitita...
         */

        for (int p = start; p <= stop; p++)
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
                //Mporei tin ora pou ena nima na allazei mia timi, ena allo na paei na tin diavasei kai na
                //kopei ara edo exo anagnosi eggrafi ara kanonika thelei prostasia...
                for (int i = p * p; i <= size; i += p)
                    primes[i] = false; //this array is shared to all threads...normally it needs mutual exclusion...

                //System.out.println("P: " + p + " " + localPrimes[p]);
            }

        }

        //Apply map only...not reduce and see the results...
        /*for (int i = 2; i <= size; i++)
            shared.addResult(localPrimes, i);*/

        /*for (int i = 2; i <= size; i++)
            if (!localPrimes[i])
                primes[i] = localPrimes[i];*/
    }
}

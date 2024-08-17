package task2.task2_1;

public class MyThread extends Thread
{
    private int myId;
    private Shared shared;
    private int start;
    private int stop;
    private boolean[] localPrimes;
    private int size;

    public MyThread(int i, int limit, int totalThreads, Shared sh, int size)
    {
        myId = i;
        int block = limit / totalThreads;

        this.start = myId * block + 2;
        this.stop = this.start + block;
        if (myId == totalThreads - 1)
            this.stop = limit;

        shared = sh;
        this.size = size;

        localPrimes = new boolean[size + 1];
        for (int k = 2; i <= size; i++)
            localPrimes[i] = true;
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

        for (int p = start; p < stop; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if (localPrimes[p])
            {
                // Update all multiples of p
                for (int i = p * p; i <= size; i += p)
                    localPrimes[i] = false;
            }
        }

        shared.addResult(localPrimes);
    }
}

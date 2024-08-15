package task2.task2_3;

public class Worker implements Runnable
{
    private int myId;
    private Buffer buffer;
    private int totalTasks;
    private int limit;
    private int totalThreads;
    //private boolean[] primes;


    /*public Worker(int i, int limit, int totalThreads, Shared sh, int size)
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

    /*public Worker(int i, Buffer buff, int totalTasks, int limit, boolean[] primes)
    {
        myId = i;
        this.buffer = buff;
        this.totalTasks = totalTasks;
        this.limit = limit;
        //this.primes = primes;
    }*/

    public Worker(int i, Buffer buff, int totalTasks, int limit)
    {
        myId = i;
        this.buffer = buff;
        this.totalTasks = totalTasks;
        this.limit = limit;
    }

    @Override
    public void run()
    {
        int element;
        while ((element = buffer.getTask()) > -1)
        {
            calculateTask(element);
        }

    }

    private void calculateTask(int index)
    {
        if (buffer.isPrime(index))
            buffer.deleteMultiplesOf(index);
    }

}

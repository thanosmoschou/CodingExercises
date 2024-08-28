package task2.task2_3;

public class Worker implements Runnable
{
    private int myId;
    private Buffer buffer;
    //private boolean[] localPrimes;
    private boolean[] primes;
    private int size;

    /*
    public Worker(int i, Buffer buff, int limit, int size)
    {
        myId = i;
        this.buffer = buff;
        this.limit = limit;
        this.size = size;
        localPrimes = new boolean[size + 1];

        for (int k = 2; i <= size; i++)
            localPrimes[i] = true;
    }
    */

    public Worker(int i, Buffer buff, int size, boolean[] pr)
    {
        myId = i;
        this.buffer = buff;
        this.size = size;
        primes = pr;
    }

    @Override
    public void run()
    {
        int element;
        while ((element = buffer.getTask()) > -1)
        {
            calculateTask(element);
        }

        //buffer.addLocalResult(localPrimes);
    }

    private void calculateTask(int index)
    {
        if (primes[index])
        {
            for (int i = index * index; i <= size; i += index)
                primes[i] = false;
        }
    }

}

package task2.task2_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Did't work properly for the task2_1
public class Shared
{
    private boolean[] prime;
    private Lock[] locks; //offers more parallelization rather than lock the whole array but it is more inefficient...
    private int size;


    public Shared(int size)
    {
        this.size = size;

        this.locks = new ReentrantLock[size + 1];
        for (int i = 2; i <= size; i++)
            locks[i] = new ReentrantLock();

        prime = new boolean[size + 1];
        for (int i = 2; i <= size; i++)
            prime[i] = true;
    }

    public void addResult(boolean[] local, int index)
    {
        synchronized (locks[index])
        {
            if (!local[index])
                prime[index] = local[index];
        }
    }

    public int findPrimes()
    {
        int count = 0;
        for(int i = 2; i <= size; i++)
            if (prime[i])
            {
                //System.out.println(i);
                count++;
            }

        return count;
    }
}

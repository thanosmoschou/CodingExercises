package task2.task2_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shared
{
    private boolean[] prime;
    private int size;

    public Shared(int size)
    {
        this.size = size;

        prime = new boolean[size + 1];
        for (int i = 2; i <= size; i++)
            prime[i] = true;
    }

    public void addResult(boolean[] local)
    {
        synchronized (this)
        {
            for (int i = 2; i <= size; i++)
                prime[i] = prime[i] && local[i]; //true & false = false so it changed correctly...false & false = false so it stayed as it is...
        }
    }

    public int findPrimes()
    {
        int count = 0;
        for(int i = 2; i <= size; i++)
            if (prime[i])
            {
                count++;
                //System.out.println(i);
            }

        return count;
    }
}

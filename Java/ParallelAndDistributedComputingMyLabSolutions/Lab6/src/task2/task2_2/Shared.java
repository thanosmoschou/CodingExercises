package task2.task2_2;

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

    public synchronized void addResult(boolean[] local)
    {
        for (int i = 2; i <= size; i++)
            prime[i] = prime[i] && local[i];
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

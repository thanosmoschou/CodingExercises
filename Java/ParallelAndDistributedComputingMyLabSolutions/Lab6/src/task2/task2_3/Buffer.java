package task2.task2_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer
{
    private boolean[] prime;
    private int totalTasks;
    private int tasksAssigned;
    //private Lock[] locks;
    private Lock myLock;
    private int limit;

    public Buffer(int totalTasks, int limit)
    {
        this.totalTasks = totalTasks;
        this.tasksAssigned = 1; //thelo na paei sto 2 gia auto ksekinao apo to 1
        prime = new boolean[totalTasks + 1];
        for (int i = 2; i <= totalTasks; i++)
            prime[i] = true;

        this.myLock = new ReentrantLock();

        /*locks = new ReentrantLock[totalTasks + 1];
        for (int i = 2; i <= totalTasks; i++)
            locks[i] = new ReentrantLock();*/

        this.limit = limit;

    }

    public boolean isPrime(int index)
    {

        //return prime[index];

        try
        {
            myLock.lock();
            return prime[index];
        }
        finally
        {
            myLock.unlock();
        }

        /*try
        {
            locks[index].lock();
            return prime[index];
        }
        finally
        {
            locks[index].unlock();
        }*/
    }

    public void deleteMultiplesOf(int index)
    {
        //I do not know if I need locks here...i am not sure if threads are reading and writing
        //from a place simultaneously...in general i need locks...

        for (int i = index * index; i <= totalTasks; i += index)
            prime[i] = false;

        /*for (int i = index * index; i <= totalTasks; i += index)
        {
            try
            {
                locks[i].lock();
                prime[i] = false;
            }
            finally
            {
                locks[i].unlock();
            }
        }*/

        /*for (int i = index * index; i <= totalTasks; i += index)
            prime[i] = false;*/

        /*try
        {
            //sequential reduce...
            myLock.lock();
            for (int i = index * index; i <= totalTasks; i += index)
                prime[i] = false;
        }
        finally
        {
            myLock.unlock();
        }*/
    }

    public int getTask()
    {
        try
        {
            myLock.lock();
            if (++tasksAssigned < limit)
                return tasksAssigned;
            else
                return -1;
        }
        finally
        {
            myLock.unlock();
        }
    }

    public int getPrimes()
    {
        int count = 0;
        for(int i = 2; i <= totalTasks; i++)
            if (prime[i])
            {
                //System.out.println(i);
                count++;
            }

        return count;
    }
}

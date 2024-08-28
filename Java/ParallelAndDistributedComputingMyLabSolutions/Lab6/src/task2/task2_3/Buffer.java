package task2.task2_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer
{
    //private Object primeLockObj;
    //private boolean[] prime;
    //private int totalTasks;
    private Object tasksAssignedLockObj;
    private int tasksAssigned;
    private int limit;

    public Buffer(int limit)
    {
        //this.totalTasks = totalTasks;
        this.tasksAssigned = 1; //thelo na paei sto 2 gia auto ksekinao apo to 1
        //prime = new boolean[totalTasks + 1];
        //for (int i = 2; i <= totalTasks; i++)
        //    prime[i] = true;

        this.limit = limit;
        //this.primeLockObj = new Object();
        this.tasksAssignedLockObj = new Object();

    }

    /*
    public void addLocalResult(boolean[] local)
    {
        synchronized (primeLockObj)
        {
            for (int i = 2; i <= totalTasks; i++)
                prime[i] = prime[i] && local[i];
        }
    }
    */

    public int getTask()
    {
        synchronized (tasksAssignedLockObj)
        {
            if (++tasksAssigned < limit)
                return tasksAssigned;
            else
                return -1;
        }
    }

    /*
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
    */
}

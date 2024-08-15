package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CyclicBarrierWithConditionVariablesAndLocks extends MyBarrier
{
    private int arrived;
    private int totalThreads;
    private boolean allWaiting;
    private boolean allLeaving;
    private Lock arrivedLock;
    private Condition waitingCondition;
    private Condition leavingCondition;

    public CyclicBarrierWithConditionVariablesAndLocks(int totalThreads)
    {
        arrived = 0;
        this.totalThreads = totalThreads;
        allWaiting = false;
        allLeaving = true;
        arrivedLock = new ReentrantLock();
        waitingCondition = arrivedLock.newCondition();
        leavingCondition = arrivedLock.newCondition();
    }

    @Override
    public void barrier()
    {
        try
        {
            arrivedLock.lock();
            arrived++;
            if (arrived == totalThreads)
            {
                allWaiting = true;
                allLeaving = false;
            }

            while (!allWaiting)
                waitingCondition.await();

            waitingCondition.signalAll();
            arrivedLock.unlock();

            arrivedLock.lock();
            arrived--;
            if (arrived == 0)
            {
                allLeaving = true;
                allWaiting = false;
            }

            while (!allLeaving)
                leavingCondition.await();

            leavingCondition.signalAll();
            arrivedLock.unlock();
        }
        catch (InterruptedException e) {}
    }
}

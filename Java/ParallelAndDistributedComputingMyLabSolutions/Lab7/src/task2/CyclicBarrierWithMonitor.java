package task2;

public class CyclicBarrierWithMonitor extends MyBarrier
{
    private int arrived;
    private Object arrivedLockObj;
    private int totalThreads;
    private boolean allWaiting;
    private boolean allLeaving;

    public CyclicBarrierWithMonitor(int totalThreads)
    {
        this.arrived = 0;
        this.totalThreads = totalThreads;
        allWaiting = false;
        allLeaving = true;
        arrivedLockObj = new Object();
    }

    @Override
    public synchronized void barrier()
    {
        wait_barrier();
        leave_barrier();
    }

    public void wait_barrier()
    {
        arrived++;
        if (arrived == totalThreads)
        {
            allWaiting = true;
            allLeaving = false;
        }

        while (!allWaiting)
        {
            try
            {
                wait(); //edo paratane to kleidoma kai kapoio allo nima to pairnei...
            }
            catch (InterruptedException e) {}
        }

        notifyAll();
    }

    public void leave_barrier()
    {
        arrived--;
        if (arrived == 0)
        {
            allLeaving = true;
            allWaiting = false;
        }

        while (!allLeaving)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e) {}
        }

        notifyAll();
    }
}

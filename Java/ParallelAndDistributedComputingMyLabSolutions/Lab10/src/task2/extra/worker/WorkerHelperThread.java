package task2.extra.worker;

public class WorkerHelperThread extends Thread
{
    /*private int myId;
    private long start;
    private long stop;*/
    private long from;
    private long to;
    private double localSum;
    private double step;
    private WorkerShared workerShared;

    /*public WorkerHelperThread(int i, long numSteps, int totalThreads, double step, WorkerShared w)
    {
        myId = i;
        long block = numSteps / totalThreads;
        start = myId * block;
        stop = start + block;
        if (myId == totalThreads - 1)
            stop = numSteps;
        localSum = 0.0;
        this.workerShared = w;
    }*/

    public WorkerHelperThread(long from, long to, double step, WorkerShared w)
    {
        this.from = from;
        this.to = to;
        this.step = step;
        localSum = 0.0;
        this.workerShared = w;
    }

    @Override
    public void run()
    {
        //System.out.println("Id: " + myId + " Start: " + start + " Stop: " + stop);

        for (long i = from; i < to; i++)
        {
            double x = ((double) i + 0.5) * step;
            localSum += 4.0 / (1.0 + x * x);
        }

        workerShared.addLocalSum(localSum);
    }
}

package task2.part_b.server;

public class PIThread extends Thread
{
    private int myId;
    private long start;
    private long stop;
    private double localSum;
    private Shared myShared;
    private double step;

    public PIThread(int i, long numSteps, int totalThreads, double step, Shared s)
    {
        myId = i;
        long block = numSteps / totalThreads;
        start = myId * block;
        stop = start + block;
        if (myId == totalThreads - 1)
            stop = numSteps;
        this.step = step;
        this.myShared = s;
    }

    @Override
    public void run()
    {
        for (long i = start; i < stop; i++)
        {
            double x = ((double) i + 0.5) * step;
            localSum += 4.0 / (1.0 + x * x);
        }

        myShared.addLocalSum(localSum);
    }
}

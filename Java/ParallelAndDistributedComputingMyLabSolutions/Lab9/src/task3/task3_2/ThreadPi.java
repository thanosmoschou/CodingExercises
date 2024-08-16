package task3.task3_2;

public class ThreadPi extends Thread
{
    private int myId;
    private Shared myShared;
    private long start;
    private long stop;
    private double step;
    private double localSum;

    public ThreadPi(int i, long numSteps, int totalThreads, double step, Shared sh)
    {
        this.myId = i;
        long blockSize = numSteps / totalThreads;
        this.start = myId * blockSize;
        this.stop = this.start + blockSize;
        if (myId == totalThreads - 1)
            this.stop = numSteps;
        this.myShared = sh;
        this.localSum = 0.0;
    }

    @Override
    public void run()
    {
        for (long i = start; i < stop; i++)
        {
            double x = ((double) i * 0.5) + step;
            localSum += 4.0 / (1.0 + x * x);
        }

        myShared.addLocalSum(localSum);
    }
}

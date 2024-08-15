package task4;

public class Thread1 extends Thread
{
    private int id;
    private Shared myShared;
    private long start;
    private long stop;
    //private double localSum;
    private double step;

    public Thread1(int i, Shared shared, int totalThreads, long numSteps, double step)
    {
        //localSum = 0;
        this.id = i;
        this.myShared = shared;
        long blockSize = numSteps / totalThreads;
        this.start = id * blockSize;
        this.stop = this.start + blockSize;
        if (id == totalThreads - 1)
            this.stop = numSteps;
        this.step = step;
    }

    @Override
    public void run()
    {
        for (long i = start; i < stop; i++)
        {
            double x = ((double) i + 0.5) * step;
            //localSum += 4.0 / (1.0 + x * x);
            myShared.addLocalSum(4.0 / (1.0 + x * x)); //WRONG USE...IT IS ONLY FOR TASK 4 IN ORDER TO SEE THE SIDE EFFECTS OF A WRONG USE OF LOCKS...
        }

        //den thelo locks gt kathe nima grafei se ksexoristi thesi...anagogi stin main...
        //myShared.addLocalSum(localSum);
    }
}

package task2.extra.worker;

public class WorkerShared
{
    private double sum;

    public WorkerShared()
    {
        sum = 0.0;
    }

    public synchronized void addLocalSum(double local)
    {
        sum += local;
    }

    public synchronized double getSum()
    {
        return sum;
    }
}

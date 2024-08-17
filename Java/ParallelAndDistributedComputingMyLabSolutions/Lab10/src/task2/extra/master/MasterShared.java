package task2.extra.master;

public class MasterShared
{
    private double pi;
    private double step;
    private double sum;

    public MasterShared(double step)
    {
        sum = 0.0;
        this.step = step;
        pi = 0.0;
    }

    public synchronized void addLocalSum(double localSum)
    {
        this.sum += localSum;
    }

    public synchronized double getPi()
    {
        pi = sum * step;
        return pi;
    }
}

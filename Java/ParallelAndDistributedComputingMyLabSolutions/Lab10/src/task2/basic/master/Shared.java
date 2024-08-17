package task2.basic.master;

public class Shared
{
    private double pi;
    private double step;
    private double sum;

    public Shared(double step)
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

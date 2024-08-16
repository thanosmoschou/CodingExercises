package task3.task3_2;

public class Shared
{
    private double pi;
    private double sum;
    private double step;

    public Shared(double step)
    {
        this.pi = 0.0;
        this.sum = 0.0;
        this.step = step;
    }

    public synchronized void addLocalSum(double localSum)
    {
        sum += localSum;
    }

    public synchronized double getPi()
    {
        return sum * step;
    }
}

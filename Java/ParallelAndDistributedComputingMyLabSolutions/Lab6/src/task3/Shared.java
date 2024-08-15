package task3;

public class Shared
{
    private double pi;
    private double sum;
    private double step;
    private Object lockObj;

    public Shared(double step)
    {
        this.pi = 0.0;
        this.sum = 0.0;
        this.step = step;
        this.lockObj = new Object();
    }

    public void addLocalSum(double local)
    {
        synchronized (lockObj)
        {
            sum += local;
        }
    }

    public double getPi()
    {
        synchronized (lockObj)
        {
            return sum * step;
        }
    }
}

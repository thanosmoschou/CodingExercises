package task2.part_b.server;

public class Shared
{
    private double step;
    private double sum;
    private double pi;

    public Shared(double step)
    {
        this.step = step;
        this.sum = 0.0;
        this.pi = 0.0;
    }

    public synchronized void addLocalSum(double local)
    {
        sum += local;
    }

    public synchronized double getPI()
    {
        pi = sum * step;
        return pi;
    }
}

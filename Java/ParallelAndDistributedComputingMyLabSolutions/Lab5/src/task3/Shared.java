package task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shared
{
    private double step;
    private double sum;
    private double pi;
    private Object lockObject;

    public Shared(double step)
    {
        this.step = step;
        this.sum = 0.0;
        this.pi = 0.0;
        this.lockObject = new Object();
    }

    public void addLocalSum(double localSum)
    {
        synchronized (lockObject)
        {
            this.sum += localSum;
        }
    }

    public void calculatePi()
    {
        synchronized (lockObject)
        {
            this.pi = this.sum * this.step;
        }
    }

    public double getPi()
    {
        synchronized (lockObject)
        {
            return this.pi;
        }
    }
}

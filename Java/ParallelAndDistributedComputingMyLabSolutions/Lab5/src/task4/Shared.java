package task4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shared
{
    private double step;
    private double sum;
    private double pi;
    private Lock lock;

    public Shared(double step)
    {
        this.step = step;
        this.sum = 0.0;
        this.pi = 0.0;
        this.lock = new ReentrantLock();
    }

    public void addLocalSum(double localSum)
    {
        try {
            lock.lock();
            this.sum += localSum;
        } finally {
            lock.unlock();
        }
    }

    public void calculatePi()
    {
        try {
            lock.lock();
            pi = sum * step;
        } finally {
            lock.unlock();
        }
    }

    public double getPi()
    {
        try {
            lock.lock();
            return this.pi;
        } finally {
            lock.unlock();
        }
    }
}

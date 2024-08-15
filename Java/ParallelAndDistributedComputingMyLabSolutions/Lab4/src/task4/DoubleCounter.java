package task4;

public class DoubleCounter
{
    private int n1;
    private int n2;
    private Object lockObj1;
    private Object lockObj2;

    public DoubleCounter()
    {
        n1 = 0;
        n2 = 0;
        lockObj1 = new Object();
        lockObj2 = new Object();
    }

    public void incFirstCounter()
    {
        synchronized (lockObj1)
        {
            n1++;
        }
    }

    public void incSecondCounter()
    {
        synchronized (lockObj2)
        {
            n2++;
        }
    }

    public int getFirstCounter()
    {
        synchronized (lockObj1)
        {
            return n1;
        }
    }

    public int getSecondCounter()
    {
        synchronized (lockObj2)
        {
            return n2;
        }
    }
}

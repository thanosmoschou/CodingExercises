package task4;

public class MyThread extends Thread
{
    private DoubleCounter counter;

    public MyThread(DoubleCounter aCounter)
    {
        counter = aCounter;
    }

    @Override
    public void run()
    {
        //increase a counter with random order...
        for (int i = 0; i < 1000; i++)
        {
            if (i % 2 == 0)
                counter.incFirstCounter();
            else
                counter.incSecondCounter();
        }
    }
}

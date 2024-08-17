package task2;

public class MyThread extends Thread
{
    private int myId;
    private MyBarrier myBarrier;

    public MyThread(int id, MyBarrier aBarrier)
    {
        myId = id;
        myBarrier = aBarrier;
    }

    @Override
    public void run()
    {
        for (;;)
        {
            System.out.println("Thread"+ myId+ " started");
            myBarrier.barrier();
            try {
                sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {}

            System.out.println("Thread"+ myId+ " reached barrier");
            myBarrier.barrier();
            System.out.println("Thread"+ myId+ " passed barrier");
            myBarrier.barrier();
        }
    }
}

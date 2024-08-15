package task4;

public class MyThread extends Thread
{
    private static int TOTAL_THREADS_CREATED_COUNTER = 0;
    private static int LIMIT = 10000; //katofli apokopis...
    private int myId;

    public MyThread()
    {
        this.myId = TOTAL_THREADS_CREATED_COUNTER;
    }

    @Override
    public void run()
    {
        System.out.println("Hello...I am thread " + myId + " starting...");

        if (TOTAL_THREADS_CREATED_COUNTER + 2 <= LIMIT) //I always create a pair of threads so I need to check if I can create two threads each time instead of only 1...
        {
            MyThread th1 = new MyThread();
            MyThread th2 = new MyThread();

            TOTAL_THREADS_CREATED_COUNTER += 2;

            th1.start();
            th2.start();

            try
            {
                th1.join();
                th2.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        else
            System.out.println("Thread limit reached...");

        System.out.println("Hello...I am thread " + myId + " stopping...");
    }
}

package task1;

public class MyThread1 extends Thread
{
    private int myId;

    public MyThread1()
    {
        this.myId = (int) (Math.random() * 100);
    }

    @Override
    public void run()
    {
        System.out.println("Hello from: " + Thread.currentThread().getName() + " with id: " + this.myId);
    }
}

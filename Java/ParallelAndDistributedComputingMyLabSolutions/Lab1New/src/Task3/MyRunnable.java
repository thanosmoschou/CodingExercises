package Task3;

public class MyRunnable implements Runnable
{
    private int id;

    public MyRunnable(int i)
    {
        id = i + 1;
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 10; i++)
            System.out.println(i + " * " + id + " = " + (i * id));
    }
}

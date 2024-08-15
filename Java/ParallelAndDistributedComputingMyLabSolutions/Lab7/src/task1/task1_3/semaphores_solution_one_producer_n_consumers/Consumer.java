package task1.task1_3.semaphores_solution_one_producer_n_consumers;

public class Consumer extends Thread
{
    private Buffer buff;

    public Consumer(Buffer b)
    {
        buff = b;
    }

    @Override
    public void run()
    {
        int item;

        while (true)
        {
            item = buff.get();
            //System.out.println("Consumed value: " + item);

            try
            {
                sleep((long) (Math.random() * 100)); //delay for demonstration purposes...
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

package task1.task1_3.condition_variables_and_locks_solution_n_producers_1_consumer;

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

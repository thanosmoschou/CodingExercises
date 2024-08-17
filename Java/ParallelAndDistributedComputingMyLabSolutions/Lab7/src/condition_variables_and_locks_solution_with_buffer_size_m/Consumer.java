package condition_variables_and_locks_solution_with_buffer_size_m;

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

            try {
                sleep((long) (Math.random() * 100)); //delay for demonstration purposes...
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

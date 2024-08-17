package task1.task1_1.condition_variables_and_locks_solution_with_buffer_size_1;

public class Producer extends Thread
{
    private Buffer buff;
    private int totalItems;

    public Producer(Buffer buf, int items)
    {
        buff = buf;
        totalItems = items;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < totalItems; i++)
        {
            int value = (int) (Math.random() * 100);
            buff.put(value);
            //System.out.println("Produced value: " + value);

            try {
                sleep((long) (Math.random() * 100)); //delay for demonstration purposes...
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

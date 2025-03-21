package task1.task1_2.monitor_solution_one_producer_one_consumer;

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

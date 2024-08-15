package task1.task1_1.semaphores_solution_with_buffer_size_1;

import java.util.concurrent.Semaphore;

public class Buffer
{
    //private int[] contents;
    private int value;
    //private int size;
    private int counter;
    //private int front;
    //private int back;
    //private Semaphore buffMutex;
    private Semaphore itemsToPut;
    private Semaphore itemsToGet;

    /*
    public Buffer(int size)
    {
        counter = 0;

        this.size = size;
        contents = new int[size];
        for (int i = 0; i < size; i++)
            contents[i] = i;
        front = 0;
        back = size - 1;

        buffMutex = new Semaphore(1);
        itemsToPut = new Semaphore(size);
        itemsToGet = new Semaphore(0);
    }
    */

    public Buffer()
    {
        value = 0;
        counter = 0;
        itemsToPut = new Semaphore(1);
        itemsToGet = new Semaphore(0);
    }

    public void put(int item)
    {
        try
        {
            itemsToPut.acquire();

            //Add item
            value = item;
            counter++;

            System.out.println("Thread no: " + Thread.currentThread().getName() + " added value: " + value);
            //System.out.println("Front: " + front + " Back: " + back);

            if (counter == 1)
                System.out.println("The buffer is full...");
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            itemsToGet.release();
        }
    }

    public int get()
    {
        int item;

        try
        {
            itemsToGet.acquire();

            item = value;
            counter--;

            System.out.println("Thread no: " + Thread.currentThread().getName() + " consumed value: " + item);
            //System.out.println("Front: " + front + " Back: " + back);

            if (counter == 0)
                System.out.println("The buffer is empty...");
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            itemsToPut.release();
        }

        //otan ftasei sto return tote sigoura tha exei na epistrepsei item kathos an
        //ftasei sta acquire kai den epitrepetai na mpei tote tha anastallei...ara de tha kanei return...
        //meta kapoia stigmi tha ksipnisei gt kapoio allo nima tha to exei ksipnisei apo thn oura
        //ara tha mpei sto krisimo tmima...thimisou oti alles ilopoihseis tou semaphore
        //sto release apla vlepoun an stin oura uparxei nima pou koimatai kai tote to afipnizoun kai mpainei
        //sto krisimo tmima, allios an den iparxei auksanoun tin timi tou semaphore kata 1...

        return item;
    }
}

package task1.task1_3.semaphores_solution_n_producers_one_consumer;

import java.util.concurrent.Semaphore;

/*
Producer Consumer lisi me semaphores...
 */

public class Buffer
{
    private int[] contents;
    private int size;
    private int counter;
    private int front;
    private int back;
    private Semaphore buffMutex;
    private Semaphore itemsToPut;
    private Semaphore itemsToGet;

    public Buffer(int size)
    {
        counter = 0;

        this.size = size;
        contents = new int[size];
        for (int i = 0; i < size; i++)
            contents[i] = 0;
        front = 0;
        back = size - 1;

        buffMutex = new Semaphore(1);
        itemsToPut = new Semaphore(size);
        itemsToGet = new Semaphore(0);
    }

    public void put(int item)
    {
        try
        {
            //P(itemsToPut) & P(bufferMutex)
            itemsToPut.acquire();
            buffMutex.acquire();

            //Add item
            back = (back + 1) % size;
            contents[back] = item;
            counter++;

            System.out.println("Thread no: " + Thread.currentThread().getName() + " added value: " + contents[back]);
            System.out.println("Front: " + front + " Back: " + back);

            if (counter == size)
                System.out.println("The buffer is full...");
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            //V(bufferMutex) & V(itemsToGet)
            buffMutex.release();
            itemsToGet.release();
        }
    }

    public int get()
    {
        int item;

        try
        {
            //P(itemsToGet) & P(buffMutex)
            itemsToGet.acquire();
            buffMutex.acquire();

            item = contents[front];
            front = (front + 1) % size;
            counter--;

            System.out.println("Thread no: " + Thread.currentThread().getName() + " consumed value: " + item);
            System.out.println("Front: " + front + " Back: " + back);

            if (counter == 0)
                System.out.println("The buffer is empty...");
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            //V(buffMutex) & V(itemsToPut)
            buffMutex.release();
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

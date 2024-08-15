package task1.task1_1.condition_variables_and_locks_solution_with_buffer_size_max;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
Producer Consumer lisi me condition variables and locks...
 */

public class Buffer
{
    private int[] contents;
    private int size;
    private int counter;
    private int front;
    private int back;
    private Lock buffLock;
    private Condition bufferFullCondition;
    private Condition bufferEmptyCondition;

    public Buffer(int size)
    {
        counter = 0;

        this.size = size;
        contents = new int[size];

        //genika kai sta alla exo valei initialization...den einai oti xreiazetai kiolas gt oi producers
        //vazoun stoixeia...alla kalou kakou ena initialization to kano...na min gkriniazei o compiler...
        for (int i = 0; i < size; i++)
            contents[i] = 0;
        front = 0;
        back = 0; //den kano % opote ksenina to kateutheian apo to 0 kai tha auksanetai...

        buffLock = new ReentrantLock();
        bufferFullCondition = buffLock.newCondition();
        bufferEmptyCondition = buffLock.newCondition();
    }

    public void put(int item)
    {
        /*
        Des to pattern:

        lock
        while (someCondition)
            await
        edit critical section
        edit condition
        signal
        unlock
         */

        try
        {
            buffLock.lock();

            //Add item
            back = back + 1;
            contents[back] = item;
            counter++;

            System.out.println("Thread no: " + Thread.currentThread().getName() + " added value: " + contents[back]);
            System.out.println("Front: " + front + " Back: " + back);

            if (counter == 1) //an exei ena item na diavaseis ksipna autous pou eixan koimithei logo empty buffer...
                bufferEmptyCondition.signalAll();
        }
        finally
        {
            buffLock.unlock();
        }
    }

    public int get()
    {
        int item;

        try
        {
            buffLock.lock();

            while (counter == 0)
            {
                System.out.println("The buffer is empty...");
                try
                {
                    bufferEmptyCondition.await();
                }
                catch (InterruptedException e) {}

            }

            item = contents[front];
            front = front + 1;
            counter--;

            System.out.println("Thread no: " + Thread.currentThread().getName() + " consumed value: " + item);
            System.out.println("Front: " + front + " Back: " + back);

            if (counter == size - 1) //an exei xoro na grapseis ksipna autous pou eixan koimithei logo full buffer...
                bufferFullCondition.signalAll();
        }
        finally
        {
            buffLock.unlock();
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

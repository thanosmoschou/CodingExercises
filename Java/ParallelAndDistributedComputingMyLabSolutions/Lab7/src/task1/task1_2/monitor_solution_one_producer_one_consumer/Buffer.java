package task1.task1_2.monitor_solution_one_producer_one_consumer;

/*
Tora sto monitor den thelo condition variables oute locks...
ta locks ta petixaino me synchronized kai den thelo condition variables
kathos o monitor exei mia oura anamonis...
 */

public class Buffer
{
    private int[] contents;
    private int size;
    private int counter;
    private int front;
    private int back;

    public Buffer(int size)
    {
        counter = 0;

        this.size = size;
        contents = new int[size];
        for (int i = 0; i < size; i++)
            contents[i] = 0;
        front = 0;
        back = size - 1;
    }

    public synchronized void put(int item)
    {
        /*
        Des to pattern:

        synchronized (ara lock)
        while (someCondition)
            wait
        edit critical section
        edit condition
        notifyAll
        (den thelei unlock kathos molis teleiosei i synchronized methodos tote ginetai automata unlock...)
         */

        while (counter == size)
        {
            System.out.println("The buffer is full...");
            try
            {
                wait();
            }
            catch (InterruptedException e) {}
        }

        //Add item
        back = (back + 1) % size;
        contents[back] = item;
        counter++;

        System.out.println("Thread no: " + Thread.currentThread().getName() + " added value: " + contents[back]);
        System.out.println("Front: " + front + " Back: " + back);

        if (counter == 1) //an exei ena item na diavaseis ksipna autous pou eixan koimithei logo empty buffer...
            notifyAll();
    }

    public synchronized int get()
    {
        int item;

        while (counter == 0)
        {
            System.out.println("The buffer is empty...");
            try
            {
                wait();
            }
            catch (InterruptedException e) {}

        }

        item = contents[front];
        front = (front + 1) % size;
        counter--;

        System.out.println("Thread no: " + Thread.currentThread().getName() + " consumed value: " + item);
        System.out.println("Front: " + front + " Back: " + back);

        if (counter == size - 1) //an exei xoro na grapseis ksipna autous pou eixan koimithei logo full buffer...
            notifyAll();

        //otan ftasei sto return tote sigoura tha exei na epistrepsei item kathos an
        //ftasei sta acquire kai den epitrepetai na mpei tote tha anastallei...ara de tha kanei return...
        //meta kapoia stigmi tha ksipnisei gt kapoio allo nima tha to exei ksipnisei apo thn oura
        //ara tha mpei sto krisimo tmima...thimisou oti alles ilopoihseis tou semaphore
        //sto release apla vlepoun an stin oura uparxei nima pou koimatai kai tote to afipnizoun kai mpainei
        //sto krisimo tmima, allios an den iparxei auksanoun tin timi tou semaphore kata 1...

        return item;
    }
}

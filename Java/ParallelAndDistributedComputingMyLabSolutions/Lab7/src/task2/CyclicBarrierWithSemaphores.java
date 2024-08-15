package task2;

import java.util.concurrent.Semaphore;

//Let's remind Inheritance a little bit...

public class CyclicBarrierWithSemaphores extends MyBarrier
{
    private int arrived;
    private Semaphore mutex;
    private Semaphore waiting;
    private Semaphore leaving;
    private int totalThreads;

    public CyclicBarrierWithSemaphores(int totalThreads)
    {
        arrived = 0;
        this.totalThreads = totalThreads;
        mutex = new Semaphore(1); //gia tin prostasia tou arrived
        waiting = new Semaphore(0); //ksekinaei sto 0 gia na kollisoun ola edo arxika...
        leaving = new Semaphore(1); //to ksekinao sto 1 gt ola tha kollisoun prota sto waiting...to teleutaio tha meiosei tin timi leaving kai ola tha kollisoun...mexri to teleutaio na ta ksekolisei...
    }


    @Override
    public void barrier()
    {
        try
        {
            //an to nima den einai to teleutaio aplos tha parei to semaphore tou mutex
            //tha auksisei tin timi tou arrived kai meta tha kanei mutex release kai tha paei
            //kato sto acquire tou waiting opou kai tha kollisei...
            mutex.acquire();
            arrived++;
            if (arrived == totalThreads)
            {
                waiting.release(); //to last thread eleftheronei ta ipoloipa...
                leaving.acquire(); //pairno to leaving oste ola na kleidosoun ekei...
            }
            mutex.release();
            waiting.acquire();
            waiting.release();

            mutex.acquire();
            arrived--;
            if (arrived == 0)
            {
                leaving.release(); //to teleutaio ta afinei na figoun apo to leaving eno parallila kleidonei to waiting oste na min afisei kapoio grigoro nima na mpei protou figoun ola...an kapoio einai pio grigogo tha kollisei sto waiting...
                waiting.acquire();
            }
            mutex.release();
            leaving.acquire();
            leaving.release();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}

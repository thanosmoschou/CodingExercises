/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2;

/*
Paratirise me to kikliko fragma oti petixaino sigxronismo ton nimaton...eno sto aplo eixa thematakia...
 */

public class Main
{
    public static void main(String[] args)
    {

        int numThreads = 10;

        //With inheritance, I can change the object without having to change the type of the variable...

        //MyBarrier testBarrier = new CyclicBarrierWithSemaphores(numThreads);
        //MyBarrier testBarrier = new CyclicBarrierWithConditionVariablesAndLocks(numThreads);
        MyBarrier testBarrier = new CyclicBarrierWithMonitor(numThreads);

        MyThread[] testThreads = new MyThread[numThreads];
        for (int i = 0; i < numThreads; i++)
        {
            testThreads[i] = new MyThread(i, testBarrier);
            testThreads[i].start();
        }
    }
}

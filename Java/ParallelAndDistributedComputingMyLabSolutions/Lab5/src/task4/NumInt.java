/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task4;

/*
Reduction from main...each thread stores its local sum to a different place of a partial sum array and
then main adds all the values together and calculates pi (this was from task 1 which did not need mutual exclusion)

sequential program results with 100000000 steps
computed pi = 3,14159265359042640000
difference between estimated pi and Math.PI = 0,00000000000063327121
time to compute = 0,416000 seconds

concurrent program results with 100000000 steps
computed pi = 3,14159265358982730000
difference between estimated pi and Math.PI = 0,00000000000003419487
time to compute = 0,184000 seconds

---------------------------

sequential program results with 1000000000 steps
computed pi = 3,14159265358997080000
difference between estimated pi and Math.PI = 0,00000000000017763568
time to compute = 4,152000 seconds

concurrent program results with 1000000000 steps
computed pi = 3,14159265358985930000
difference between estimated pi and Math.PI = 0,00000000000006616929
time to compute = 1,332000 seconds

-----------------------------
Reduction with a shared object...each thread calculates a local sum, and then it calls a method of a
shared object in order to add its local sum to the total sum of the shared object...Inside the method uses a lock
to provide mutual exclusion between the threads...

concurrent program results with 1000000000 steps
computed pi = 3,14159265358985930000
difference between estimated pi and Math.PI = 0,00000000000006616929
time to compute = 1,158000 seconds
---------------------------------

KEEP IN MIND THAT IN TASK 4 WE USE LOCKS WITH A WRONG WAY JUST TO SEE THE TIME DIFFERENCES
BETWEEN THE CORRECT USE OF LOCKS AND THE WRONG ONE...

concurrent program results with 1000000000 steps
computed pi = 3,14159265359033400000
difference between estimated pi and Math.PI = 0,00000000000054090066
time to compute = 18,176000 seconds

As you can understand, a wrong use of locks can harm your program and make it really slow...
So avoid using locks inside a thread's for loop...inside the for loop just use a local variable in order
to calculate a partial result, and at the end of the loop call only once the method of the shared object
that adds the local thread's sum to the total one...
 */

public class NumInt
{
    public static void main(String[] args)
    {
        long numSteps = 1000000000;
        double step = 1.0 / (double) numSteps;

        Shared myShared = new Shared(step);

        int totalThreads = Runtime.getRuntime().availableProcessors();
        Thread1[] threads = new Thread1[totalThreads];

        /* start timing */
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new Thread1(i, myShared, totalThreads, numSteps, step);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }

        myShared.calculatePi();

        double pi = myShared.getPi();

        /* end timing and print result */
        long endTime = System.currentTimeMillis();

        System.out.printf("concurrent program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);

    }
}

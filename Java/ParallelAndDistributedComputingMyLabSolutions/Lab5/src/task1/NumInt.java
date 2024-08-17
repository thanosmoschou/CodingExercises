/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1;

/*
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
 */

public class NumInt
{
    public static void main(String[] args)
    {
        long numSteps = 1000000000;
        double step = 1.0 / (double) numSteps;
        double sum = 0.0;

        int totalThreads = Runtime.getRuntime().availableProcessors();
        double[] partialSumArray = new double[totalThreads];
        Thread1[] threads = new Thread1[totalThreads];

        /* start timing */
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new Thread1(i, partialSumArray, totalThreads, numSteps, step);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }

        for (int i = 0; i < totalThreads; i++)
            sum += partialSumArray[i];

        double pi = sum * step;

        /* end timing and print result */
        long endTime = System.currentTimeMillis();

        System.out.printf("concurrent program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);

    }
}

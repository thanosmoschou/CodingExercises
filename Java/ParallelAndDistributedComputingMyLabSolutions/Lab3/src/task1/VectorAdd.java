/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1;

public class VectorAdd
{
    public static void main(String[] args)
    {
        int arrSize = 1000;
        double[] a = new double[arrSize];
        double[] b = new double[arrSize];
        double[] c = new double[arrSize];

        for (int i = 0; i < arrSize; i++)
        {
            a[i] = 0.1;
            b[i] = 0.3;
            c[i] = 0;
        }

        //PRINTING ONLY UNTIL HERE...

        //When you want to calculate the total computation time, make sure you will not contain
        //printing commands inside your calculations because they will need some extra time
        //and finally you will not calculate the computation time...
        //Also avoid having printing commands inside your thread's run method...
        //So you can have printing before and after the time calculation...
        //The following commands do not contain printing...
        long startTime = System.currentTimeMillis();

        int totalThreads = Runtime.getRuntime().availableProcessors();
        MyThread[] threads = new MyThread[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new MyThread(i, totalThreads, arrSize, a, b, c);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }

        long totalTime = System.currentTimeMillis() - startTime;

        //From now on you can print whatever you want...
        for (int i = 0; i < arrSize; i++)
            System.out.println("a[" + i + "] + b[" + i + "] = " + c[i]);

        System.out.println("Let's print the computation range of each thread...");
        for (int i = 0; i < totalThreads; i++)
            threads[i].printComputationRange();

        System.out.println("Total computation time: " + totalTime + "ms");
    }


}

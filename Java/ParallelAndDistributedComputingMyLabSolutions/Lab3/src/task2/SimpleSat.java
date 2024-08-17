/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2;

//Sequential time: 10 sec...
//Parallel time: 2 sec...

public class SimpleSat
{
    public static void main(String[] args)
    {
        // Circuit input size (number of bits)
        int circuitInputSize = 28;
        // Number of possible inputs (bit combinations)
        int iterations = (int) Math.pow(2, circuitInputSize);

        // Start timing
        long start = System.currentTimeMillis();

        int totalThreads = Runtime.getRuntime().availableProcessors();
        SatThread[] threads = new SatThread[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new SatThread(i, circuitInputSize, iterations, totalThreads);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }

        // Stop timing
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        System.out.println("All done\n");
        System.out.println("time in ms = " + elapsedTimeMillis);

    }

}

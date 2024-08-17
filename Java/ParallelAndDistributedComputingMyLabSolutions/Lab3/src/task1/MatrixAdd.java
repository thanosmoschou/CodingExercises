/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1;

public class MatrixAdd
{
    public static void main(String[] args)
    {
        int rows = 100;
        int columns = 100;
        double[][] a = new double[rows][columns];
        double[][] b = new double[rows][columns];
        double[][] c = new double[rows][columns];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                a[i][j] = 0.1;
                b[i][j] = 0.3;
                c[i][j] = 0;
            }
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
        MyThread2[] threads = new MyThread2[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new MyThread2(i, totalThreads, rows, columns, a, b, c);
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
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                System.out.println("a[" + i + "][" + j + "]" + " + b[" + i + "][" + j + "] = " + c[i][j]);

        System.out.println("Let's print the computation range of each thread...");
        for (int i = 0; i < totalThreads; i++)
            threads[i].printComputationRange();

        System.out.println("Total computation time: " + totalTime + "ms");
    }
}

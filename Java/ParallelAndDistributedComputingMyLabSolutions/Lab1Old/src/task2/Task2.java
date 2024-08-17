/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2;

public class Task2
{
    public static void main(String[] args) {
        int size = 10;
        MyThread1[] th1Arr = new MyThread1[size];
        MyThread2[] th2Arr = new MyThread2[size];

        for (int i = 0; i < size; i++)
        {
            th1Arr[i] = new MyThread1();
            th2Arr[i] = new MyThread2();
            th1Arr[i].start();
            th2Arr[i].start();
        }

        /*
        Keep in mind that the print order of threads is random...
         */

        for (int i = 0; i < size; i++)
        {
            try {
                th1Arr[i].join();
                th2Arr[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads are done...");
    }
}
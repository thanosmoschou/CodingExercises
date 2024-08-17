/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1;

public class Task1
{
    public static void main(String[] args)
    {
        MyThread1 th1 = new MyThread1();
        MyThread2 th2 = new MyThread2();

        /*
        Keep in mind that if you place join after the start of a thread then main must
        wait for the thread to finish in order to continue its execution...as a result
        I have a sequential execution of my threads but I want concurrent execution...

        For example: This will lead to sequential execution of my threads...

        th1.start();
        th1.join();
        th2.start();
        th2.join();

        If I want concurrent execution then I have to put join() after all threads are finally created...just like
        I do here...

        If you remove join() completely then main thread does not wait for the threads to finish and might finish first
         */

        th1.start();
        th2.start();

        try {
            th1.join(); //main thread waits for th1 to finish in order to continue...
            th2.join(); //if you do not put join then the main thread does not wait for the other threads to finish and it may finish before them...
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All threads are done...");
    }
}
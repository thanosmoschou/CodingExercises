package task2.part_a.server;

import task2.part_a.interfaces.PI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PIImpl extends UnicastRemoteObject implements PI
{

    public PIImpl() throws RemoteException {}

    @Override
    public double calculatePI(long numSteps) throws RemoteException
    {
        double step = 1.0 / (double) numSteps;
        Shared shared = new Shared(step);

        int totalThreads = 10;
        PIThread[] threads = new PIThread[totalThreads];
        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new PIThread(i, numSteps, totalThreads, step, shared);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
            try {
                threads[i].join();
            } catch (InterruptedException e) {}

        double pi = shared.getPI();
        return pi;
    }
}

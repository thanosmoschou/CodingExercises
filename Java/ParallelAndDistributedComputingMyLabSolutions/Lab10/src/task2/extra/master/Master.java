package task2.extra.master;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Master
{
    private static final int PORT = 9090;
    private static final int numOfWorkers = 4;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);

        long numSteps = 10000000;
        double step = 1.0 / (double) numSteps;
        MasterShared shared = new MasterShared(step);

        MasterThread[] masterThreads = new MasterThread[numOfWorkers];
        for (int i = 0; i < numOfWorkers; i++)
        {
            Socket connSocket = serverSocket.accept();
            masterThreads[i] = new MasterThread(connSocket, numSteps, i, step, shared);
            masterThreads[i].start();
        }

        for (int i = 0; i < numOfWorkers; i++)
        {
            try {
                masterThreads[i].join();
            } catch (InterruptedException e) {}
        }

        System.out.println("PI: " + shared.getPi());

    }
}

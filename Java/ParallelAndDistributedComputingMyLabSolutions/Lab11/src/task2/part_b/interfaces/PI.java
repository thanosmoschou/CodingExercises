package task2.part_b.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PI extends Remote
{
    public double calculatePI(long numSteps) throws RemoteException;
}


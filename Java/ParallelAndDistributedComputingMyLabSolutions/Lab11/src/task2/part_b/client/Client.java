/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.part_b.client;

import task2.part_b.interfaces.PI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
    private static final String HOST = "localhost";
    private static final int PORT = Registry.REGISTRY_PORT; //1099

    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry(HOST, PORT);

        String objName = "MyPI";
        PI pi = (PI) registry.lookup(objName);

        long numSteps = 100000003;
        System.out.println("PI for steps: " + numSteps + " is: " + pi.calculatePI(numSteps));
    }
}

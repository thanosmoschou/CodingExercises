/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.part_a.server;

import task2.part_a.interfaces.PI;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
    private static final String HOST = "localhost";
    private static final int PORT = Registry.REGISTRY_PORT; //1099

    public static void main(String[] args) throws IOException, AlreadyBoundException, RemoteException
    {
        System.setProperty("java.rmi.server.hostname", HOST);

        Registry registry = LocateRegistry.createRegistry(PORT);

        PI pi = new PIImpl();
        String objName = "MyPI";

        registry.bind(objName, pi);

        // Server is running until we press a key
        System.out.println("Press <Enter> for exit.");
        System.in.read();
    }
}

/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.part_b.server;

import task2.part_b.interfaces.PI;

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
        BufferPI bufferPI = new BufferPI();

        PI pi = new PIImpl(bufferPI);
        String objName = "MyPI";

        registry.bind(objName, pi);

        // Server is running until we press a key
        System.out.println("Press <Enter> for exit.");
        System.in.read();
    }
}

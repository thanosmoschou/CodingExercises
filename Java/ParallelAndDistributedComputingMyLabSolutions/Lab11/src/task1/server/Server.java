/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1.server;

import task1.interfaces.Calculator;

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

        Calculator calc = new CalculatorImpl();
        String objName = "MyCalc";

        registry.bind(objName, calc);

        // Server is running until we press a key
        System.out.println("Press <Enter> for exit.");
        System.in.read();
    }
}

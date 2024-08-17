/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1.client;

import task1.interfaces.Calculator;

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

        String objName = "MyCalc";
        Calculator calc = (Calculator) registry.lookup(objName);

        System.out.println("Addition 4 + 3 = " + calc.add(4, 3));
        System.out.println("Subtraction 4 - 3 = " + calc.sub(4, 3));
        System.out.println("Multiplication 4 * 3 = " + calc.mul(4, 3));
        System.out.println("Divition 4 / 3 = " + calc.div(4, 3));
    }
}

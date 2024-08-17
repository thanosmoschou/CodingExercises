/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);

        //iterative server...in next labs I will make a multithreading one...
        while (true)
        {
            Socket connectionSocket = serverSocket.accept();
            System.out.println("New connection from: " + connectionSocket.getInetAddress());
            
            ServerThread serverThread = new ServerThread(connectionSocket);
            serverThread.start();
        }
    }
}

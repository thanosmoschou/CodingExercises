/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task3.task3_1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true)
        {
            Socket connectionSocket = serverSocket.accept();
            System.out.println("New connection from: " + connectionSocket.getInetAddress());
            
            ServerThread serverThread = new ServerThread(connectionSocket);
            serverThread.start();
        }
    }
}

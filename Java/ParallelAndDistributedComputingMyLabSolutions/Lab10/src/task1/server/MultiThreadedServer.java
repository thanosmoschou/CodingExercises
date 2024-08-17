package task1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer
{
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        ConnectionDetailsBuffer connectionsBuffer = new ConnectionDetailsBuffer();
        int connectionId = 0;

        System.out.println("Server is running on port: " + PORT);

        while (true)
        {
            Socket connectionSocket = serverSocket.accept();
            connectionsBuffer.addConnection(connectionSocket);
            connectionId = connectionsBuffer.getConnectionsNumber() - 1; //The first needs id 0 and not 1 so I subtract 1 each time...

            System.out.println("New connection from: " + connectionSocket.getInetAddress());
            System.out.println("Total live connections: " + (connectionId + 1));

            ServerThread serverThread = new ServerThread(connectionsBuffer, connectionId);
            serverThread.start();

        }

    }
}

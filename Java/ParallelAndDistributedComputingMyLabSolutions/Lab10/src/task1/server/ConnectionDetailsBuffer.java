package task1.server;

import java.net.Socket;
import java.util.ArrayList;

public class ConnectionDetailsBuffer
{
    private ArrayList<Socket> connections;

    public ConnectionDetailsBuffer()
    {
        connections = new ArrayList<>();
    }


    /*
    I do not want a thread to add a new connection while another thread
    tries to get the arraylist of connections...
     */
    public synchronized void addConnection(Socket connSocket)
    {
        connections.add(connSocket);
    }

    public synchronized void deleteConnection(int index)
    {
        connections.remove(index);
    }

    public synchronized Socket getSocket(int index)
    {
        return connections.get(index);
    }

    public synchronized ArrayList<Socket> getConnections()
    {
        return connections;
    }

    public synchronized int getConnectionsNumber()
    {
        return connections.size();
    }
}

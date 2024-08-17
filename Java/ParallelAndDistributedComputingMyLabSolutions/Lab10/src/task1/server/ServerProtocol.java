package task1.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerProtocol
{
    private ConnectionDetailsBuffer buffer;

    public ServerProtocol(ConnectionDetailsBuffer buff)
    {
        this.buffer = buff;
    }

    public void sendToAll(String inp, int id) throws IOException
    {
        ArrayList<Socket> connections = buffer.getConnections();
        PrintWriter[] writers = new PrintWriter[connections.size()];

        for (int i = 0; i < writers.length; i++)
            writers[i] = new PrintWriter(connections.get(i).getOutputStream(), true);

        for (int i = 0; i < connections.size(); i++)
            if (i != id)
                writers[i].println("From User " + id + " Message: " + inp);
    }
}

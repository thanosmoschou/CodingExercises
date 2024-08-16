package task2;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
    private Socket connectionSocket;

    private ObjectInputStream in;
    private ObjectOutputStream out;


    public ServerThread(Socket socket) throws IOException
    {
        this.connectionSocket = socket;

        out = new ObjectOutputStream(connectionSocket.getOutputStream());
        in = new ObjectInputStream(connectionSocket.getInputStream());
    }

    @Override
    public void run()
    {
        Request req;
        Reply rep;

        ServerProtocolCalculator app = new ServerProtocolCalculator();

        try
        {
            req = (Request) in.readObject();
        }
        catch (ClassNotFoundException | IOException e)
        {
            throw new RuntimeException(e);
        }


        while (!(req.getOpCode() == '!'))
        {
            rep = app.getRequestAndReturnReply(req);
            try
            {
                out.writeObject(rep);
                req = (Request) in.readObject();
            }
            catch (ClassNotFoundException | IOException e)
            {
                throw new RuntimeException(e);
            }
        }

        try
        {
            connectionSocket.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

package task1;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
    private Socket connectionSocket;

    private InputStream is;
    private BufferedReader in;

    private OutputStream os;
    private PrintWriter out;


    public ServerThread(Socket socket) throws IOException
    {
        this.connectionSocket = socket;

        is = connectionSocket.getInputStream();
        in = new BufferedReader(new InputStreamReader(is));

        os = connectionSocket.getOutputStream();
        out = new PrintWriter(os, true);
    }

    @Override
    public void run()
    {
        String inpMsg, outMsg;

        ServerProtocolCalculator app = new ServerProtocolCalculator();

        try
        {
            inpMsg = in.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        while (!inpMsg.equals("!"))
        {
            outMsg = app.getRequestAndReturnReply(inpMsg);
            out.println(outMsg);
            try
            {
                inpMsg = in.readLine();
            }
            catch (IOException e)
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

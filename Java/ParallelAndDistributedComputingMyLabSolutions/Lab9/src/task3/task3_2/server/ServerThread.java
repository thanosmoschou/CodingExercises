package task3.task3_2.server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
    private Socket connectionSocket;
    private BufferPI bufferPI;

    private InputStream is;
    private BufferedReader in;

    private OutputStream os;
    private PrintWriter out;


    public ServerThread(Socket socket, BufferPI buff) throws IOException
    {
        this.connectionSocket = socket;
        this.bufferPI = buff;

        is = connectionSocket.getInputStream();
        in = new BufferedReader(new InputStreamReader(is));

        os = connectionSocket.getOutputStream();
        out = new PrintWriter(os, true);
    }

    @Override
    public void run()
    {
        String inpMsg, outMsg;

        ServerProtocolCalculator app = new ServerProtocolCalculator(bufferPI);

        try {
            inpMsg = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (!inpMsg.equals("-1"))
        {
            outMsg = app.getRequestAndReturnReply(inpMsg);
            out.println(outMsg);
            try {
                inpMsg = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            connectionSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

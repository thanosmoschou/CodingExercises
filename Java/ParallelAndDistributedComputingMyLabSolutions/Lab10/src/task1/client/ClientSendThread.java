package task1.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSendThread extends Thread
{
    private Socket connectionSocket;
    private OutputStream os;
    private PrintWriter out;

    public ClientSendThread(Socket socket) throws IOException
    {
        this.connectionSocket = socket;
        this.os = this.connectionSocket.getOutputStream();
        this.out = new PrintWriter(this.os, true);
    }

    @Override
    public void run()
    {
        ClientProtocol app = new ClientProtocol();
        String outp;

        outp = app.prepareOutput();
        while (!outp.equals("EXIT"))
        {
            out.println(outp);
            outp = app.prepareOutput();
        }

        out.println(outp);

        try {
            connectionSocket.close();
        } catch (IOException e) {}
    }
}

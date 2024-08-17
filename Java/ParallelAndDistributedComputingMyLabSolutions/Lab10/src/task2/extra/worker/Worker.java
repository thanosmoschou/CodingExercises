package task2.extra.worker;

import java.io.*;
import java.net.Socket;

public class Worker extends Thread
{
    private static final String HOST = "localhost";
    private static final int PORT = 9090;
    private static final int numOfWorkers = 4;

    public static void main(String[] args) throws IOException
    {
        Socket connSocket = new Socket(HOST, PORT);

        InputStream is = connSocket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        OutputStream os = connSocket.getOutputStream();
        PrintWriter out = new PrintWriter(os, true);

        WorkerProtocol app = new WorkerProtocol(numOfWorkers);

        String inp, outp;

        inp = in.readLine();
        outp = app.compute(inp);
        out.println(outp);
        connSocket.close();
    }
}

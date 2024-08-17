package task2.basic.master;

import java.io.*;
import java.net.Socket;

public class MasterThread extends Thread
{
    //auta thelei to master thread
    private Socket connSocket;
    private InputStream is;
    private BufferedReader in;
    private OutputStream os;
    private PrintWriter out;

    //ta parakato den ta thelei to masterthread alla to master protocol...
    private Shared shared;
    private int workerId;
    private double step;
    private long numSteps;

    public MasterThread(Socket socket, long numSteps, int id, double step, Shared sh) throws IOException
    {
        connSocket = socket;
        is = connSocket.getInputStream();
        in = new BufferedReader(new InputStreamReader(is));
        os = connSocket.getOutputStream();
        out = new PrintWriter(os, true);
        this.numSteps = numSteps;
        this.workerId = id;
        this.step = step;
        this.shared = sh;
    }

    @Override
    public void run()
    {
        MasterProtocol app = new MasterProtocol(numSteps, workerId, step, shared);

        String inp, outp;

        outp = app.prepareRequest();
        out.println(outp);

        try {
            inp = in.readLine();
            app.handleResult(inp);
            connSocket.close();
        } catch (IOException e) {}
    }
}

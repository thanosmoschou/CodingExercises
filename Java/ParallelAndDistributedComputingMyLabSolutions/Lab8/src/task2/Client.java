/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2;

import java.io.*;
import java.net.Socket;

public class Client
{
    private static final String HOST = "localhost";
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        Socket connectionSocket = new Socket(HOST, PORT);

        //InputStream, InputStreamReader, BufferedReader
        InputStream inputStream = connectionSocket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        //OutputStream, PrintWriter
        OutputStream outputStream = connectionSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);

        ClientProtocolCalculator app = new ClientProtocolCalculator();

        String inMsg, outMsg;

        outMsg = app.prepareRequest();
        while (!outMsg.equals("!"))
        {
            out.println(outMsg);
            inMsg = in.readLine();
            app.processReply(inMsg);
            outMsg = app.prepareRequest();
        }

        out.println(outMsg);
        connectionSocket.close();
    }
}
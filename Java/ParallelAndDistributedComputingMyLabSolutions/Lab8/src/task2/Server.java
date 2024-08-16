/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);

        //iterative server...in next labs I will make a multithreading one...
        while (true)
        {
            Socket connectionSocket = serverSocket.accept();

            InputStream is = connectionSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));

            OutputStream os = connectionSocket.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);

            String inpMsg, outMsg;

            ServerProtocolCalculator app = new ServerProtocolCalculator();

            inpMsg = in.readLine();
            while (!inpMsg.equals("!"))
            {
                outMsg = app.getRequestAndReturnReply(inpMsg);
                out.println(outMsg);
                inpMsg = in.readLine();
            }

            connectionSocket.close();
        }
    }
}

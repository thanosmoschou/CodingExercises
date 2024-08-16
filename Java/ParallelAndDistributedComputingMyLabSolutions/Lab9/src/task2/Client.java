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

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Socket connectionSocket = new Socket(HOST, PORT);

        ObjectOutputStream out = new ObjectOutputStream(connectionSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(connectionSocket.getInputStream());

        ClientProtocolCalculator app = new ClientProtocolCalculator();

        Request req;
        Reply rep;

        req = app.prepareRequest();
        while (!(req.getOpCode() == '!'))
        {
            out.writeObject(req);
            rep = (Reply) in.readObject();
            app.processReply(rep);
            req = app.prepareRequest();
        }

        out.writeObject(req);
        connectionSocket.close();
    }
}

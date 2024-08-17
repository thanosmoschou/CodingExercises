/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
This is a simple chatroom that is built in Java with Sockets...
I enjoyed the development of it because I have never made something like this and it needed some time
for thinking...
 */

package task1.client;

import java.io.IOException;
import java.net.Socket;

public class Client
{
    private static final String HOST = "localhost";
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        Socket connSocket = new Socket(HOST, PORT);

        ClientSendThread sendThread = new ClientSendThread(connSocket);
        ClientReceiveThread receiveThread = new ClientReceiveThread(connSocket);

        sendThread.start();
        receiveThread.start();
    }
}

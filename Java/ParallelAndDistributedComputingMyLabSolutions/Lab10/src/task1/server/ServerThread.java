package task1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread
{
    private int myId;
    private Socket mySocket;
    private ConnectionDetailsBuffer connectionBuffer;
    private InputStream is;
    private BufferedReader in;

    public ServerThread(ConnectionDetailsBuffer connBuff, int id) throws IOException
    {
        this.myId = id;
        this.connectionBuffer = connBuff;
        this.mySocket = this.connectionBuffer.getSocket(myId);
        this.is = mySocket.getInputStream();

        in = new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public void run()
    {
        ServerProtocol app = new ServerProtocol(connectionBuffer);
        String inpMsg, outMsg;

        try {
            inpMsg = in.readLine();
            while (!inpMsg.equals("EXIT"))
            {
                app.sendToAll(inpMsg, myId);
                inpMsg = in.readLine();
            }

            connectionBuffer.deleteConnection(myId);
            mySocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

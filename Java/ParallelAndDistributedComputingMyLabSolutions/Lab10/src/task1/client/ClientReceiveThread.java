package task1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveThread extends Thread
{
    private Socket connectionSocket;
    private InputStream is;
    private BufferedReader in;

    public ClientReceiveThread(Socket socket) throws IOException
    {
        this.connectionSocket = socket;
        this.is = this.connectionSocket.getInputStream();
        this.in = new BufferedReader(new InputStreamReader(this.is));
    }

    @Override
    public void run()
    {
        ClientProtocol app = new ClientProtocol();
        String inp;

        try {
            inp = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (inp != null)
        {
            app.readInput(inp);

            try {
                inp = in.readLine();
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

/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task3.task3_2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Prospathisa na sindiaso toso ton katanemimeno ipologismo pou kanoume edo oso kai ton parallilo
Exo multithreading server pou dexetai multiple connections apo clients...
Gia kathe connection ftiaxnei ena ServerThread gia na einai ipeuthino gia tin epikoinonia...
Ta serverthreads auta exoun mia moirazomeni domi pou prota koitane ekei an exei idi ipoligistei
i timi tou PI oste na tin epistrepsoun amesos kai na min tin ipologisoun ksana...
Mesa to bufferPI pou moirazontai exei mixanismo amoivaiou apokleismou...
Episis epeidi den ithela to kathe serverthread na ilopoiei ton ipologismo tou PI akolouthiaka
gt kataligei na einai argo gia megales eisodous, spao tin douleia se alla nimata oste na ginei i douleia ekei...
Se auta kano statiki katanomi...mesa tous exoun ena shared antikeimeno prokeimenou na sozoun ta local sum tous...
Sto telos to server thread kalei tin getPi oste na parei tin timi tou PI...kai to shared exei mixanismo
amoivaiou apokleismou kathos moirazetai se polla nimata ta opoia prosthetoun to meriko athroisma tous
ara eprepe na prosekso me tin prosvasi...

Opote ti efarmosa:
Katanemimeno ipologismo me multithreaded server...
Shared bufferPi metaksi twn serverThreads kai amoivaio apokleismo tis domis...

Spasimo tis douleias tou kathe serverthread se alla nimata
me statiki katanomi kai xrisi shared object gia na sozo to localSum
tou kathe nimatos sto telos (anagogi) ...to kathe nima mesa exei topiki metavliti
stin opoia efarmozetai i apeikonisi... opote exo thn statiki katanomi mou, local variable gia apeikonisi, kai sto telos
anagogi apo to kathe nima me xrisi amoivaiou apokleismou...ara ta efarmosa ola...

Kapoia stigmi tha kano to idio me master worker...
 */

public class Server
{
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        BufferPI bufferPI = new BufferPI();

        //iterative server...in next labs I will make a multithreading one...
        while (true)
        {
            Socket connectionSocket = serverSocket.accept();
            System.out.println("New connection from: " + connectionSocket.getInetAddress());
            
            ServerThread serverThread = new ServerThread(connectionSocket, bufferPI);
            serverThread.start();
        }
    }
}

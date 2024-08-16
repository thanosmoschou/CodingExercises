package task3.task3_2;

public class ServerProtocolCalculator
{
    private BufferPI bufferPI;

    public ServerProtocolCalculator(BufferPI b)
    {
        this.bufferPI = b;
    }

    public String getRequestAndReturnReply(String input)
    {
        double searched = bufferPI.searchValue(input);

        if (searched != -1) //was already calculated so I return it...
            return Double.toString(searched);
        else
        {
            /*
            Pleon to kathe serverthread kathe fora pou tha tou zitaei kati enas client
            kai tha prepei na ipologisei to PI, tha spaei thn douleia se alla threads...
             */

            long numSteps = Long.parseLong(input);
            double step = 1.0 / (double) numSteps;

            Shared shared = new Shared(step); //auto xreiazetai mono gia ena client request...tha upologiso to PI kai tha to soso stin domi mou (bufferPI)...meta den mou xreiazetai...
                                              //an dexto ki allo request tote tha ftiakso allo tetoio antikeimeno...ta nimata to exoun gia anagogi sto telos tous...eno na toniso oti kanoun
                                              //apeikonisi me local variables opos exo pei...episis exo epileksei statiki katanomi gt oloi oi ipologismoi einai idias varititas...

            int totalThreads = 10;
            ThreadPi[] threads = new ThreadPi[totalThreads];

            for (int i = 0; i < totalThreads; i++)
            {
                threads[i] = new ThreadPi(i, numSteps, totalThreads, step, shared);
                threads[i].start();
            }

            for (int i = 0; i < totalThreads; i++)
            {
                try
                {
                    threads[i].join();
                }
                catch (InterruptedException e) {}
            }

            double pi = shared.getPi();
            bufferPI.storeValue(Long.toString(numSteps), pi);

            return Double.toString(pi);
        }

    }


}

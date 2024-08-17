/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package monitor_solution_with_buffer_size_m;

/*
Auti tin lisi den tin zitaei...aplos tin kano ego gia na matho kalitera to montelo producer consumer...
Ostoso ola ta alla pou zitaei sta tasks einai eidikes periptosis tis lisis autis...
Esi kalo tha itan na thimasai tin geniki lisi opos parousiazetai edo kai meta pratteis analoga...
Iparxoun 3 vasikes proseggiseis gia producer consumer opos vlepeis...exo lisi me semaphores, lisi
me condition variables kai locks, kai telos exo lisi me epopti...
 */

public class Main
{
    public static void main(String[] args)
    {
        /*
        Genika na thimasai oti prepei na oriseis poso megethos tha exei o buffer,
        posoi katanalotes kai paragogoi tha iparxoun kai posa items tha valeis mesa (posa tha paraksei o kathe paragogos
        diladi)...
        Ta items pou tha mpoun sinolika mesa den einai anagki na einai idia se arithmo
        me to megethos tou buffer...kai auto simvainei gt o buffer exei ena megethos, oi
        producers vazoun stoixeia kai otan iparxoun stoixeia pros anagnosi oi consumers ta
        afairoun...opote katalavaineis oti sinolika mporeis na valeis polla stoixeia...apla
        tha mpainoun tmimatika...
         */

        int bufferSize = 5;
        int totalItems = 20;
        int nOfProducers = 3;
        int nOfConsumers = 4;

        Producer[] producers = new Producer[nOfProducers];
        Consumer[] consumers = new Consumer[nOfConsumers];

        Buffer buffer = new Buffer(bufferSize);

        for (int i = 0; i < nOfProducers; i++)
        {
            producers[i] = new Producer(buffer, totalItems);
            producers[i].start();
        }

        for (int i = 0; i < nOfConsumers; i++)
        {
            consumers[i] = new Consumer(buffer);
            consumers[i].start();
        }

    }
}

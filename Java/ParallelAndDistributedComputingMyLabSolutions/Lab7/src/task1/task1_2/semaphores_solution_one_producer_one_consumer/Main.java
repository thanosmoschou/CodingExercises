/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1.task1_2.semaphores_solution_one_producer_one_consumer;


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
        int nOfProducers = 1;
        int nOfConsumers = 1;

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

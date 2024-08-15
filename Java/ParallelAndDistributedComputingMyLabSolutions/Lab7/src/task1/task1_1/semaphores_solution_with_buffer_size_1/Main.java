/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1.task1_1.semaphores_solution_with_buffer_size_1;

/*
Tora prepei o buffer na exei mono mia thesi...ara exo mono mia metavliti...ara den xreiazetai idiaitero
amoivaio apokleismo...mporo mono me sigxronismo se sinthiki na kano pragmata kathos mono enas paragogos
h enas katanalotis mporei na exei prosvasi kathe fora...
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

        //int bufferSize = 5;
        int totalItems = 20;
        int nOfProducers = 3;
        int nOfConsumers = 4;

        Producer[] producers = new Producer[nOfProducers];
        Consumer[] consumers = new Consumer[nOfConsumers];

        //Buffer buffer = new Buffer(bufferSize);
        Buffer buffer = new Buffer();

        for (int i = 0; i < nOfProducers; i++) {
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

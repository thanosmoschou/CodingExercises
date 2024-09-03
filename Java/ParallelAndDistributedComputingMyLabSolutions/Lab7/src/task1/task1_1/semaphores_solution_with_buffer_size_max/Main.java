/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1.task1_1.semaphores_solution_with_buffer_size_max;

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

        /*
        Buffer `απείρων` θέσεων, size = ΜΑΧ
        (α) Δεν απαιτείται έλεγχος counter == size
        (β) Δεν απαιτείται %size στις πράξεις front, back
         */

        int bufferSize = 50000000; //I wanted to put Integer.MAX_VALUE; but is too much...
        int totalItems = 200000;
        int nOfProducers = 30;
        int nOfConsumers = 40;

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

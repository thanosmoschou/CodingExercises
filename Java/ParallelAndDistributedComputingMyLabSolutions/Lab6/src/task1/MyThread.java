package task1;

import java.util.concurrent.locks.Lock;

public class MyThread extends Thread
{
    private int myId;
    private int matchLength;
    private int totalThreads;
    //private int start;
    //private int stop;
    private char[] pattern; //erxetai os orisma anaforas ara einai moirazomenos sta nimata...to idio kai o text...ostoso mono diavazo apo autous ara den thelo locks...
    private char[] text;
    private char[] match;
    //private Lock lock;
    private int patternLength;
    //private char[] localMatch;
    //private int localMatchCtr;
    //private Shared shared;

    /*public MyThread(int i, int totalThreads, int matchSearchLength, int patternLength, char[] patternArr, char[] textArr, Shared sh)
    {
        this.myId = i;
        int block = matchSearchLength / totalThreads;
        this.start = this.myId * block;
        this.stop = this.start + block;
        if (this.myId == totalThreads - 1)
            this.stop = matchSearchLength;
        this.patternLength = patternLength;
        this.pattern = patternArr;
        this.text = textArr;
        this.localMatch = new char[matchSearchLength + 1];
        this.localMatchCtr = 0;
        this.shared = sh;

        for (int k = 0; k < matchSearchLength; k++)
            localMatch[k] = '0';
    }*/

    /*public MyThread(int i, int totalThreads, int matchSearchLength, int patternLength, char[] patternArr, char[] textArr, char[] matchArr)
    {
        this.myId = i;
        int block = matchSearchLength / totalThreads + patternLength; //specific situation here...that's why I added this patternLength

        this.start = this.myId * block;
        this.stop = this.start + block;
        if (this.myId == totalThreads - 1)
            this.stop = matchSearchLength;
        this.patternLength = patternLength;
        this.pattern = patternArr;
        this.text = textArr;
        this.match = matchArr;

        *//*this.localMatch = new char[matchSearchLength + 1];
        for (int k = 0; k < matchSearchLength; k++)
        localMatch[k] = '0';*//*

    }*/

    public MyThread(int i, int totalThreads, int matchSearchLength, int patternLength, char[] patternArr, char[] textArr, char[] matchArr)
    {
        this.myId = i;
        this.totalThreads = totalThreads;
        this.matchLength = matchSearchLength;
        this.patternLength = patternLength;
        this.pattern = patternArr;
        this.text = textArr;
        this.match = matchArr;
        //this.lock = lock;

        /*this.localMatch = new char[matchSearchLength + 1];
        for (int k = 0; k < matchSearchLength; k++)
            localMatch[k] = '0';*/

    }

    /*
    public MyThread(int i, int totalThreads, int matchSearchLength, int patternLength, char[] patternArr, char[] textArr)
    {
        this.myId = i;

        int block = matchSearchLength / totalThreads + patternLength; //specific situation here...that's why I added this patternLength
        this.start = this.myId * block;
        this.stop = this.start + block;
        if (this.myId == totalThreads - 1)
            this.stop = matchSearchLength;

        this.patternLength = patternLength;
        this.pattern = patternArr;
        this.text = textArr;

        this.localMatchCtr = 0;
        this.localMatch = new char[matchSearchLength + 1];
        for (int k = 0; k < matchSearchLength; k++)
            localMatch[k] = '0';

    }
    */

    @Override
    public void run()
    {
        //fast for big files!
        for (int i = myId; i <= matchLength; i += totalThreads)
        {
            int j;
            for (j = 0; j < patternLength && pattern[j] == text[j + i]; j++); //null statement...but works for us

            //katafera na saroso olo to pattern stin esoteriki for ara exo vrei ena match pou ksekinaei apo to i
            //tis eksoterikis for kai paei mexri i+patternLength (sto keimeno mou)
            if (j >= patternLength)
            {
                //de nomizo na thelei lock gt opos to vlepo isos ta nimata den grafoun tautoxrona se mia thesi logo tis katanomis poy epeleksa...
                match[i] = '1'; //a little bit faster than static variables...but still slower than sequential...
            }
        }

        /*for (int i = start; i < stop; i++)
        {
            int j;
            for (j = 0; j < patternLength && pattern[j] == text[j + i]; j++); //null statement...but works for us

            //katafera na saroso olo to pattern stin esoteriki for ara exo vrei ena match pou ksekinaei apo to i
            //tis eksoterikis for kai paei mexri i+patternLength (sto keimeno mou)
            if (j >= patternLength)
            {
                //SLOW
                //localMatch[i] = '1'; //prosoxi edo thes i kai oxi j gt metras sto original keimeno (kai oxi sto pattern) apo pou kseninaei to match...
                //localMatchCtr++;

                //polla lock unlock...
                //shared.addLocalMatchArrAndIncreaseMatchCtr(i);
                //shared.increaseMatchCtr();

                //-------------------
                //also slow (this is combined with the copy of the local match array to the shared one down below...
                //localMatch[i] = '1';
                //---------------------

                //ALSO SLOW WITH SHARED ARRAYS PASSED FROM MAIN...but paizei na ftaiei i katanomi
                //match[i] = '1';

                *//*localMatch[i] = '1';
                localMatchCtr++;*//*

                //BruteForceStringMatchParallelized.match[i] = '1';
                match[i] = '1'; //a little bit faster than static variables...but still slower than sequential...
            }
        }*/

        /*
        In this method I used a local array to find the matches of each thread (just like we
        learned in the class...for the map procedure use local variables to find the partial result of each thread)
        and then I will copy the values of my local variables to the static variables (only one lock unlock
        at the end of the thread just for the reduce method, where I add the local values to the static ones)...
        The lock unlock outside of a for loop can cause sequential execution of the reduce procedure
        but I didn't use locks inside my threads for loop that calculated the matches and
        I also want the reduce to be sequential...If I had lock unlock inside the following for loop
        I would have extra delays...
         */

        /*try
        {
            BruteForceStringMatchParallelized.myLock.lock();
            for (int i = start; i < stop; i++)
                BruteForceStringMatchParallelized.match[i] = localMatch[i];
            BruteForceStringMatchParallelized.matchCount += localMatchCtr;
        }
        finally
        {
            BruteForceStringMatchParallelized.myLock.unlock();
        }*/

        //still slower than sequential execution...


        /* SLOW
        for (int i = start; i < stop; i++)
            match[i] = localMatch[i];
         */

        //SLOW
        //shared.addLocalMatchCtr(localMatchCtr);
        //shared.addLocalMatchArr(localMatch, start, stop);
    }
}

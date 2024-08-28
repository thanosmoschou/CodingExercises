package task1;

public class MyThread extends Thread
{
    private int myId;
    private int matchLength;
    private int totalThreads;
    private int patternLength;
    private char[] pattern; //erxetai os orisma anaforas ara einai moirazomenos sta nimata...to idio kai o text...ostoso mono diavazo apo autous ara den thelo locks...
    private char[] text;
    private int localMatchCtr;
    private Shared shared;
    private boolean[] match;


    public MyThread(int i, int totalThreads, int matchSearchLength, int patternLength, char[] patternArr, char[] textArr, boolean[] match, Shared sh)
    {
        this.myId = i;
        this.totalThreads = totalThreads;
        this.matchLength = matchSearchLength;
        this.patternLength = patternLength;
        this.pattern = patternArr;
        this.text = textArr;
        this.match = match;
        this.shared = sh;
    }

    @Override
    public void run()
    {
        for (int i = myId; i <= matchLength; i += totalThreads)
        {
            int j;
            for (j = 0; j < patternLength && pattern[j] == text[j + i]; j++); //null statement...but works for us

            //katafera na saroso olo to pattern stin esoteriki for ara exo vrei ena match pou ksekinaei apo to i
            //tis eksoterikis for kai paei mexri i+patternLength (sto keimeno mou)
            if (j >= patternLength)
            {
                match[i] = true;
                localMatchCtr++;
            }
        }

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

        shared.addLocalMatchCtr(localMatchCtr);
        //shared.addLocalMatchArr(localMatch);
    }
}

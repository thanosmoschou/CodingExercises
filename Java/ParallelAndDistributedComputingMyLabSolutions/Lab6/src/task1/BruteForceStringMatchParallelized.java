/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Now let's parallelize the code and see the results...for some reason is slower than sequential...
I tried static variables, I tried main arguments that are passed by reference to each thread, I tried a shared object...
I do not know what is wrong...

Thanos from future: The reduce it taking too long because you copy the whole array...
If you pass a shared array and add directly the values there without having to copy the local array (but using
locks) to the shared array (periptosara einai...esi leo na thimasai oti emathes peri topikotitas gia apeikonisi, kai epeita anagogi
me locks sto telos opos ksereis...)

isos me alli katanomi na itan pio grigoro...tha to dokimaso...
me kikliki einai ligo pio grigoro apo tin statiki alla pali pio argo apo tin akolouthiaki ektelesi...

i kikliki gia megala noumera einai grigoroteri apo to akolouthiako programma...ekana to E.coli 16 fores megalitero


Total matches 16
Total execution time: 236ms

Total matches 16
Total execution time: 80ms
 */

public class BruteForceStringMatchParallelized
{
    //public static char[] match;
    //public static int matchCount = 0;
    //public static Lock myLock = new ReentrantLock();

    public static void main(String[] args) throws IOException
    {
        //String filename = "E.coli"; //root folder is the intellij's project folder...
        String filename = "sixteentimes.txt";

        //String fileString = new String(Files.readAllBytes(Paths.get(args[0])));//, StandardCharsets.UTF_8);
        String fileString = new String(Files.readAllBytes(Paths.get(filename)));
        char[] text = new char[fileString.length()];
        int textLength = fileString.length();
        for (int i = 0; i < textLength; i++)
            text[i] = fileString.charAt(i);


        //String patternString = "cagccggggttcccgctggcgcaattga";
        String patternString = "accgccggtaatgaaaaaggcgaactggtggtgcttggacgcaacg";
        char[] pattern = new char[patternString.length()];
        int patternLength = patternString.length();
        for (int i = 0; i < patternLength; i++)
            pattern[i] = patternString.charAt(i);

        int matchLength = textLength - patternLength;
        char[] match = new char[matchLength + 1];
        for (int i = 0; i < matchLength; i++)
            match[i] = '0';

        //o pinakas match deixnei se poion xaraktira tou keimenou mou ksekinaei to pattern...gia auto vlepeis exei mikos n-m
        //px an exo keimeno 100 xaraktiron kai to pattern einai 10 xaraktires, tote tha pao na sigkrino mexri tin thesi 90 (n-m)
        //oste saronontas olo to pattern, an vro match auto na ginei isa isa mexri tin thesi 100 dhl thn teleutaia thesi...
        //an pigaina mexri telos px mexri tin 100 kai ksekinousa na sigkrino xaraktires me to pattern mou, tha evgaina out of bounds...
        //oppte an px vrethei ena match ston xaraktira 10 (kai paei mexri ton 20 afou to pattern einai 10) tote tha pame stin thesi 10
        //tou match kai tha valoume tin timi 1 oste na ksero se poio simeio tou keimenou ksekinaei to pattern...

        //Shared shared = new Shared(matchLength); me shared kai locks den vgazei kala apotelesmata gia kapoio logo...
        //dokimazo me moirazomenous pinakes mono...tous perasa sto thread kai pali einai argo...
        //dokimazo tora me static pinakes...logika pali argo tha einai...isos ftaiei to oti kleidonoume tin domi...

        long start = System.currentTimeMillis();

        int totalThreads = 5; //Runtime.getRuntime().availableProcessors();
        MyThread[] threads = new MyThread[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            //threads[i] = new MyThread(i, totalThreads, matchLength, patternLength, pattern, text, shared);
            threads[i] = new MyThread(i, totalThreads, matchLength, patternLength, pattern, text, match);
            //threads[i] = new MyThread(i, totalThreads, matchLength, patternLength, pattern, text);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e) {e.printStackTrace();}
        }

        long end = System.currentTimeMillis() - start;

        int matchCount = 0;
        for (int i = 0; i < matchLength; i++)
            if (match[i] == '1')
            {
                System.out.print(i+" ");
                matchCount++;
            }

        System.out.println();
        System.out.println("Total matches " + matchCount);
        System.out.println("Total execution time: " + end + "ms");

        /*
        shared.printMatches();

        System.out.println();
        System.out.println("Total matches " + shared.getMatchCtr());
        System.out.println("Total execution time: " + end + "ms");
         */

    }
}

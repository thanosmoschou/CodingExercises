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

isos me alli katanomi na itan pio grigoro...tha to dokimaso...
me kikliki einai ligo pio grigoro apo tin statiki alla pali pio argo apo tin akolouthiaki ektelesi...

i kikliki gia megala noumera einai grigoroteri apo to akolouthiako programma...ekana to E.coli 16 fores megalitero...ostoso etsi einai xoris reduce...
An valeis reduce ginetai pio argo kathos antigrafeis mia topiki domi se ena shared object...


Total matches 16
Total execution time: 236ms

Total matches 16
Total execution time: 80ms

Me reduce:
Total matches 16
Total execution time: 2326ms
 */

public class BruteForceStringMatchParallelized
{
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
        Shared shared = new Shared(matchLength);

        long start = System.currentTimeMillis();

        int totalThreads = 10; //Runtime.getRuntime().availableProcessors();
        MyThread[] threads = new MyThread[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new MyThread(i, totalThreads, matchLength, patternLength, pattern, text, shared);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {e.printStackTrace();}
        }

        long end = System.currentTimeMillis() - start;

        shared.printMatches();

        System.out.println();
        System.out.println("Total matches " + shared.getMatchCtr());
        System.out.println("Total execution time: " + end + "ms");


    }
}

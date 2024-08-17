/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
This code is given...
In this code the execution is sequential. We need to put time calculation commands in order to see the execution time...
Then we will try to parallelize (using everything we have learned so far...use correct methods only...) it and see how faster it can be...
 */

public class BruteForceStringMatchSequential
{

    public static void main(String[] args) throws IOException
    {

        /*
        if (args.length != 2)
        {
            System.out.println("BruteForceStringMatch  <file name> <pattern>");
            System.exit(1);
        }
        */

        //String filename = "E.coli";
        String filename = "sixteentimes.txt";
        //String filename = "fourtimes.txt"; //root folder is the intellij's project folder...
        //String patternInput = "cagccggggttcccgctggcgcaattga";

        //String fileString = new String(Files.readAllBytes(Paths.get(args[0])));//, StandardCharsets.UTF_8);
        String fileString = new String(Files.readAllBytes(Paths.get(filename)));
        char[] text = new char[fileString.length()];
        int n = fileString.length();
        for (int i = 0; i < n; i++)
            text[i] = fileString.charAt(i);


        //String patternString = new String(args[1]);
        //String patternString = "cagccggggttcccgctggcgcaattga";
        String patternString = "accgccggtaatgaaaaaggcgaactggtggtgcttggacgcaacg";
        char[] pattern = new char[patternString.length()];
        int m = patternString.length();
        for (int i = 0; i < m; i++)
            pattern[i] = patternString.charAt(i);


        //o pinakas match deixnei se poion xaraktira tou keimenou mou ksekinaei to pattern...gia auto vlepeis exei mikos n-m
        //px an exo keimeno 100 xaraktiron kai to pattern einai 10 xaraktires, tote tha pao na sigkrino mexri tin thesi 90 (n-m)
        //oste saronontas olo to pattern, an vro match auto na ginei isa isa mexri tin thesi 100 dhl thn teleutaia thesi...
        //an pigaina mexri telos px mexri tin 100 kai ksekinousa na sigkrino xaraktires me to pattern mou, tha evgaina out of bounds...
        //oppte an px vrethei ena match ston xaraktira 10 (kai paei mexri ton 20 afou to pattern einai 10) tote tha pame stin thesi 10
        //tou match kai tha valoume tin timi 1 oste na ksero se poio simeio tou keimenou ksekinaei to pattern...
        int matchLength = n - m;
        int[] match = new int[matchLength+1]; //the original was char[] but I changed it...int type seems better to me for the parallelized version...
        for (int i = 0; i <= matchLength; i++)
            match[i] = 0;

        //The code above contains some initializations, so I skip it from the time calculation process...

        long startTime = System.currentTimeMillis();

        /*ArrayList<Integer> match = new ArrayList<Integer>(); */
        int matchCount = 0;
        for (int j = 0; j < matchLength; j++)
        {
            int i;
            for (i = 0; i < m && pattern[i] == text[i + j]; i++); //Null statement...but it works for us...
            if (i >= m)
            {
                match[j] = 1; //vlepeis kai stin eksoteriki for oti paei mexri matchLength...
                matchCount++;
            }
        }


        long endTime = System.currentTimeMillis() - startTime;

        for (int i = 0; i < matchLength; i++)
            if (match[i] == 1)
                System.out.print(i+" ");

        System.out.println();
        System.out.println("Total matches " + matchCount);
        System.out.println("Total execution time: " + endTime + "ms");

    }
}





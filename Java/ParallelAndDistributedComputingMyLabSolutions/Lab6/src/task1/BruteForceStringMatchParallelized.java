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

isos me alli katanomi na itan pio grigoro...tha to dokimaso...
me kikliki einai ligo pio grigoro apo tin statiki alla pali pio argo apo tin akolouthiaki ektelesi...

Thanos from future: The reduce it taking too long because you copy the whole array...

i kikliki gia megala noumera einai grigoroteri apo to akolouthiako programma...ekana to E.coli 16 fores megalitero...
ostoso etsi einai xoris reduce me ton tropo pou mathame mexri tora alla kateutheian anagogi ston moirazomeno xoris locks....
An valeis reduce ginetai pio argo kathos antigrafeis mia topiki domi se ena shared object...

Total matches 16
Total execution time: 236ms

Total matches 16
Total execution time: 80ms

Me reduce me lock ston moirazomeno pinaka:
Total matches 16
Total execution time: 2326ms

Me reduce xoris lock ston moirazomeno alla me lock mono gia ton metriti kai kikliki katanomi:
Total matches 16
Total execution time: 127ms

Thanos from future (28/8/2024):
ΣΤΟ STRING MATCH ΜΕ ΣΤΑΤΙΚΗ ΚΑΤΑΝΟΜΉ ΕΧΕΙΣ ΕΝΑΝ ΠΊΝΑΚΑ MATCHES ΠΟΥ ΔΕΊΧΝΕΙ ΣΕ ΠΟΙΑ ΘΕΣΗ ΤΟΥ ΚΕΙΜΈΝΟΥ
ΞΕΚΙΝΑΕΙ Η ΑΝΤΙΣΤΟΙΧΊΑ. ΕΠΙΣΗΣ ΕΧΕΙΣ ΕΝΑΝ ΜΕΤΡΗΤΉ ΠΟΥ ΔΕΊΧΝΕΙ ΠΟΣΕΣ ΑΝΤΙΣΤΟΙΧΊΕΣ ΕΧΕΙ ΤΕΛΙΚΑ ... ΚΑΙ ΕΔΩ ΙΣΩΣ
ΘΕΣ ΚΛΕΙΔΩΜΑ ΜΟΝΟ ΣΤΟΝ ΜΕΤΡΗΤΉ ΚΑΘΏΣ ΚΑΘΕ ΝΗΜΑ ΘΑ ΓΡΑΦΕΙ ΣΕ ΞΕΧΩΡΙΣΤΉ ΘΈΣΗ ΤΟΥ ΠΊΝΑΚΑ...
ΤΟ ΙΔΙΟ ΙΣΧΥΕΙ ΚΑΙ ΓΙΑ ΤΙΣ ΑΛΛΕΣ ΚΑΤΑΝΟΜΈΣ...ΓΕΝΙΚΑ ΕΔΩ ΕΙΝΑΙ ΠΕΡΊΠΤΩΣΗ...

ΝΑ ΘΥΜΑΣΑΙ ΤΗΝ ΓΕΝΙΚΉ ΔΟΜΗ ΠΟΥ ΜΑΘΑΜΕ ΔΗΛ ΤΟΠΙΚΌΤΗΤΑ ΣΤΟΝ ΥΠΟΛΟΓΙΣΜΌ ΚΑΙ ΑΝΑΓΩΓΉ ΣΤΟ ΤΈΛΟΣ...ΕΔΩ ΗΤΑΝ ΣΥΓΚΕΚΡΙΜΕΝΟ
ΠΑΡΑΔΕΙΓΜΑ ΚΑΙ ΔΕΝ ΧΡΕΙΑΖΟΤΑΝ...ΚΑΛΟ ΘΑ ΕΙΝΑΙ ΝΑ ΚΑΤΑΛΑΒΑΙΝΕΙΣ ΠΟΤΕ ΧΡΕΙΑΖΕΤΑΙ ΚΑΙ ΠΟΤΕ ΟΧΙ ΚΑΘΩΣ ΕΠΙΣΗΣ ΚΑΙ ΝΑ ΘΥΜΑΣΑΙ
ΤΑ ΓΕΝΙΚΑ ΠΡΟΤΥΠΑ ΟΠΩΣ ΛΕΩ ΠΑΝΩ...
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
        boolean[] match = new boolean[matchLength];
        for (int i = 0; i < matchLength; i++)
            match[i] = false;

        Shared shared = new Shared(matchLength);

        long start = System.currentTimeMillis();

        int totalThreads = 10; //Runtime.getRuntime().availableProcessors();
        MyThread[] threads = new MyThread[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            //threads[i] = new MyThread(i, totalThreads, matchLength, patternLength, pattern, text, shared);
            threads[i] = new MyThread(i, totalThreads, matchLength, patternLength, pattern, text, match, shared);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {e.printStackTrace();}
        }

        long end = System.currentTimeMillis() - start;

        //shared.printMatches();

        for (int i = 0; i < matchLength; i++)
            if (match[i])
                System.out.print(i+" ");

        System.out.println();
        System.out.println("Total matches " + shared.getMatchCtr());
        System.out.println("Total execution time: " + end + "ms");


    }
}

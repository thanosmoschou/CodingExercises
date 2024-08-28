/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2.task2_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Tha kanoume dinamiki katanomi...
Paromoia taxitita me to sequential gia mikra noumera (an den kaneis pali anagogi sosta...ego
omos thelo na eimai sostos kai telika ekana apeikonisi topika kai anagogi sto telos)...gia na valo megalitera noumera na do ti ginetai...

int arrSize = 1000000000;

number of primes 50847534
time in ms = 14121

number of primes 50847534
time in ms = 13565 (parallel)

vlepeis einai ligo pio grigori...
an otan svino ta multiples den valo locks tote pairno auto:
number of primes 50847534
time in ms = 8619

gia na kleidono kathe thesi ksexorista na do...den mporo otan exo poli megala noumera...den ftanei to heap...

Telika kano anagogi sto telos eno prin exo kanei topika tin apeikonisi mou...

Thanos from future (28/8/2024):
Tha prospathiso ston buffer na exo mono thn metavliti taskAssigned & thn totalTasks kai mono mia methodo
getTask...stin main tha exo ton pinaka primes kai tha ton pernao sto nima mazi me ton buffer...kathe
nima tha kanei getTask kai tha ektelei pano ston pinaka tin douleia...gia na do kai etsi ti ginetai...

Me 3 threads kai reduce kateutheian ston shared object (eno ston buffer exo mono thn getTask):
arrSize = 1000000000 kai 3 threads
number of primes 50847534
time in ms = 12113

ΣΤΟ ΚΌΣΚΙΝΟ ΤΟΥ ΕΡΑΤΟΣΘΈΝΗ ΙΣΩΣ ΘΕΣ ΑΜΟΙΒΑΊΟ ΑΠΟΚΛΕΙΣΜΌ ΑΛΛΑ ΙΣΩΣ ΚΑΙ ΌΧΙ...
ΓΙΑ ΝΑ ΔΟΥΜΕ: ΔΕ ΣΕ ΕΓΓΥΑΤΑΙ ΚΑΝΕΝΑΣ ΌΤΙ 2 ΝΗΜΑΤΑ ΔΕ ΘΑ ΓΡΆΨΟΥΝ ΣΕ ΙΔΙΑ ΘΕΣΗ .. ΠΧ ΓΙΑ ΤΟ 2 4 6
ΜΠΟΡΕΙ ΝΑ ΞΕΚΙΝΗΣΕΙ ΈΝΑ ΝΗΜΑ ΝΑ ΚΆΝΕΙ ΔΟΥΛΕΙΆ ΚΑΙ ΈΝΑ ΑΛΛΟ ΝΑ ΚΆΝΕΙ ΓΙΑ 3 6 9 ΚΑΙ ΝΑ ΕΙΝΑΙ ΠΙΟ ΓΡΉΓΟΡΟ
ΑΡΑ ΘΑ ΠΈΣΟΥΝ ΣΤΗΝ ΙΔΙΑ ΘΈΣΗ (6)...ΝΑΙ ΜΕΝ ΘΑ ΤΟ ΚΆΝΟΥΝ ΚΑΙ ΟΙ 2 FALSE AT THE END OF THE DAY ΑΛΛΑ ΟΚ...
ΔΕΝ ΕΧΩ ΠΡΌΣΘΕΣΗ ΠΧ ΠΟΥ ΔΕ ΘΑ ΗΞΕΡΑ ΠΟΙΑ ΘΑ ΉΤΑΝ Η ΠΑΛΙΆ ΤΙΜΗ ΚΑΙ ΘΑ ΕΊΧΑ ΕΣΦΑΛΜΕΝΑ ΑΠΟΤΈΛΕΣΜΑΤΑ...
ΟΠΟΤΕ ΤΕΛΙΚΑ ΙΣΩΣ ΚΑΙ ΝΑ ΜΗΝ ΘΈΛΕΙ Ο ΠΊΝΑΚΑΣ ΚΛΕΙΔΩΜΑ...

ΝΑ ΘΥΜΑΣΑΙ ΤΗΝ ΓΕΝΙΚΉ ΔΟΜΗ ΠΟΥ ΜΑΘΑΜΕ ΔΗΛ ΤΟΠΙΚΌΤΗΤΑ ΣΤΟΝ ΥΠΟΛΟΓΙΣΜΌ ΚΑΙ ΑΝΑΓΩΓΉ ΣΤΟ ΤΈΛΟΣ...ΕΔΩ ΗΤΑΝ ΣΥΓΚΕΚΡΙΜΕΝΟ
ΠΑΡΑΔΕΙΓΜΑ ΚΑΙ ΔΕΝ ΧΡΕΙΑΖΟΤΑΝ...ΚΑΛΟ ΘΑ ΕΙΝΑΙ ΝΑ ΚΑΤΑΛΑΒΑΙΝΕΙΣ ΠΟΤΕ ΧΡΕΙΑΖΕΤΑΙ ΚΑΙ ΠΟΤΕ ΟΧΙ ΚΑΘΩΣ ΕΠΙΣΗΣ ΚΑΙ ΝΑ ΘΥΜΑΣΑΙ
ΤΑ ΓΕΝΙΚΑ ΠΡΟΤΥΠΑ ΟΠΩΣ ΛΕΩ ΠΑΝΩ...

 */

class SieveOfEratosthenes
{
	public static void main(String[] args)
	{
		/*
		if (args.length != 1) {
			System.out.println("Usage: java SieveOfEratosthenes <size>");
			System.exit(1);
		}

		try {
			size = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nfe) {
	   		System.out.println("Integer argument expected");
    		System.exit(1);
		}
		if (size <= 0) {
				System.out.println("size should be positive integer");
	    		System.exit(1);
		}
		*/

		int arrSize = 1000000000;
		int limit = (int) Math.sqrt(arrSize) + 1;
		Buffer buffer = new Buffer(limit);

		// get current time
		long startTime = System.currentTimeMillis();

		boolean[] prime = new boolean[arrSize + 1];
		for (int i = 2; i <= arrSize; i++)
			prime[i] = true;

		int totalThreads = 3;
		Thread[] threads = new Thread[totalThreads];

		for (int i = 0; i < totalThreads; i++)
		{
			//threads[i] = new Thread(new Worker(i, buffer, limit, totalTasks));
			threads[i] = new Thread(new Worker(i, buffer, arrSize, prime));
			threads[i].start();
		}

		for (int i = 0; i < totalThreads; i++)
		{
			try {
				threads[i].join();
			} catch (InterruptedException e) {}
		}

		// get current time and calculate elapsed time
		long elapsedTimeMillis = System.currentTimeMillis()-startTime;

		//int count = buffer.getPrimes();

		int count = 0;
		for(int i = 2; i <= arrSize; i++)
			if (prime[i])
			{
				count++;
				//System.out.println(i);
			}
		System.out.println("number of primes " + count);

		//System.out.println("number of primes " + count);
		System.out.println("time in ms = "+ elapsedTimeMillis);
	}


}

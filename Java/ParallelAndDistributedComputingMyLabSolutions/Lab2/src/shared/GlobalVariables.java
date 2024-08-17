package shared;

//Prospatho na po gia kathe metavliti ti einai kai ton tropo pou diamoirazetai...
public class GlobalVariables {

	//metavliti klasis...
	//moirazetai os katholiki metavliti
    static int n = 5;

	//metavliti klasis...
	//moirazetai os katholiki metavliti...
	static int[] a;

    public static void main(String[] args) {

		//topiki stin main metavliti...den moirazetai pouthena
        int numThreads = 10;
	    a = new int[numThreads];
	    
	    for (int i = 0; i < numThreads; i++) //to i topiki metavliti stin main...den perna pouthena
			a[i] = 0; 

		//topikos pinakas tis main...den perna pouthena...
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) { //to i topiki metavliti tis main...moirazetai os orisma timis omos kathe nima exei alli timi...
		    counterThreads[i] = new CounterThread(i);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) { //to i topiki metavliti tis main...den pernaei pouthena
            try {
				counterThreads[i].join();
				n = n + counterThreads[i].threadN;
            } catch (InterruptedException e) {}
		} 
        for (int i = 0; i < numThreads; i++) //to idio gia to i kai edo
			System.out.println("a["+i+"] = "+a[i]);
			
		System.out.println("n = "+n); 
    }

	static class CounterThread extends Thread {

		//instance variable...de moirazetai
	    int threadID;

		//instance variable...de moirazetai
		int threadN;
	    
	    public CounterThread(int tid) {
	        this.threadID = tid;
	        this.threadN = n;
	    }
	  	
	    public void run() {
	        threadN = threadN + threadID; //to topiko n metavaletai...ola ta alla n menoun analloiota...
            a[threadID] = a[threadID] + threadN; //to a einai moirazomeno ara metavalontai oi times gia olous...
            System.out.println("Thread "+threadID+ " my n = "+threadN+ " my a = "+a[threadID]);  
	    }
	}
}	


/*
Pithanes ektiposeis...

Logika to static n menei idio prin prolavoume na pame sta join kathos exo poli liga nimata...

Thread 0 my n = 5 my a = 5
Thread 2 my n = 7 my a = 7
Thread 1 my n = 6 my a = 6
...
a[0] = 5
a[1] = 6
a[2] = 7
...
 */
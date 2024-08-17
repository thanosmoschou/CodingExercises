package shared_lab2;

public class Lab2 {

    public static void main(String[] args) {

        //topiki tis main...den moirazetai
        int numThreads = 4;

        //topiki tis main...moirazetai os orisma timis kai ola ta nimata pairnoun tin idia timi
		int n = 0;
        //topiki tis main...moirazetai os orisma anaforas...
	    int[] a = new int[numThreads];
	    for (int i = 0; i < numThreads; i++) //to i topiki tis main...den moirazetai
			a[i] = 0; 

        //topiki tis main...den moirazetai...
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) { //to i topiki tis main...moirazetai os orisma timis...
		    counterThreads[i] = new CounterThread(i, n, a);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) { //to i topiki tis main kai den moirazetai...
            try {
				counterThreads[i].join();
            } catch (InterruptedException e) {}
		}
		
		System.out.println("n = "+n);
		
		for (int i = 0; i < numThreads; i++) //to i topiki tis main kai den moirazetai...
			System.out.println("a["+i+"] = "+a[i]); 	
    }

}

class CounterThread extends Thread {

    //instance variable
    int threadID;
    //instance variable
    int n;
    //instance variable
    int[] a;
    
    public CounterThread(int tid, int n, int[] a) { //parameters...value, value, reference...
        this.threadID = tid;
        this.n = n;
        this.a = a;
    }
  	
    public void run() {
        
        n = n + threadID ;
        a[threadID] = a[threadID] + n ;
        System.out.println("Thread "+threadID+ " my a = "+a[threadID]);
    }
}

/*
Pithani ektiposi...

Thread 0 my a = 0
Thread 2 my a = 2
Thread 1 my a = 1
Thread 3 my a = 3
n = 0
a[0] = 0
a[1] = 1
a[2] = 2
a[3] = 3
 */

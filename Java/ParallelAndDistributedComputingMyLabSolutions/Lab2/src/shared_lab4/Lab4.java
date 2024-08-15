package shared_lab4;

public class Lab4 {

    public static void main(String[] args) {

        //topiki sti main...den moirazetai...
        int numThreads = 4;

        //topiki tis main...moirazetai os orisma timis...kathe nima pairnei thn idia timi
	    int n = 0;
        //topiki tis main...den moirazetai
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) { //to i topiki tis main...moirazetai os orisma timis alla kathe nima pairnei alli timi(stoixisi)
		    counterThreads[i] = new CounterThread(i, n);
		    counterThreads[i].start();
		}
	
        for (int i = 0; i < numThreads; i++) { //to i topiki sti main kai den moirazetai
            try {
				counterThreads[i].join();
				n += counterThreads[i].threadN;
            }
            catch (InterruptedException e) {}
		} 
		System.out.println("Main n = "+n); 
    }

}

class CounterThread extends Thread {

    //instance variables
    int threadID;
    int threadN; 
    
    public CounterThread(int tid, int n) { //value arguments...
        this.threadID = tid;
        this.threadN = n;
    }
  	
    public void run() {
              
        threadN = threadN + 1 + threadID;
        System.out.println("Thread "+threadID+ " n = "+threadN); 
    }
}

/*
Pithani ektiposi...

Thread 1 n = 2
Thread 0 n = 1
Thread 2 n = 3
Thread 3 n = 4
Main n = 10
 */

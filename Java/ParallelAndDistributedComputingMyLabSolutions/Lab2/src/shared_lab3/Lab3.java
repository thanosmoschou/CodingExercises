package shared_lab3;

public class Lab3 {
  
    public static void main(String[] args) {

        //topiki tis main, moirazetai os orisma timis...
        int numThreads = 4;

        //topiki tis main...moirazetai os orisma anaforas...
		SharedCounter count = new SharedCounter(numThreads);

        //topiki tis main...den moirazetai
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) { //to i topiki tis main...orisma timis (stoixisi)
		    counterThreads[i] = new CounterThread(i, count);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) { //to i topiki tis main...den moirazetai
            try {
				counterThreads[i].join();
				count.n = count.n + counterThreads[i].threadN;
            }
            catch (InterruptedException e) {}
		} 
        for (int i = 0; i < numThreads; i++) //to idio kai gia auto to i
			System.out.println("a["+i+"] = "+count.a[i]);
			
		System.out.println("n = "+count.n); 
    }
}

class SharedCounter {

    //Instance variables...moirazetai olo to antikeimeno metaksi ton nimaton ara kai auta moirazontai
	int n; 
    int[] a;
    
    public SharedCounter (int numThreads) { //value parameter
		
			this.n = 0;
			this.a = new int[numThreads];
	    
			for (int i = 0; i < numThreads; i++)
				this.a[i] = 0; 
	}		

}    

class CounterThread extends Thread {

    //instance attributes
    int threadID;
    int threadN;
    SharedCounter threadCount;
    
    public CounterThread(int tid, SharedCounter c) {
        this.threadID = tid;
        this.threadCount = c;
        this.threadN = threadCount.n;
        
    }
  	
    public void run() {
  
        threadN = threadN + 1 + threadID;  
        threadCount.a[threadID] = threadCount.a[threadID] + 1 + threadID;
		System.out.println("Thread "+threadID+" n = "+ threadN +"  a["+threadID+"] ="+ threadCount.a[threadID]); 
    }
}

/*
Pithani ektiposi...

Thread 0 n = 1 a[0] = 1
Thread 2 n = 3 a[2] = 3
Thread 1 n = 2 a[1] = 2
Thread 3 n = 4 a[3] = 4
a[0] = 1
a[1] = 2
a[2] = 3
a[3] = 4
n = 10
 */


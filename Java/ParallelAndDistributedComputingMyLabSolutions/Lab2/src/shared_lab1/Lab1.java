package shared_lab1;

public class Lab1 {

	//metavliti klasis...moirazetai os katholiki...
    static int n = 0;
	//metavliti klasis...moirazetai os katholiki
    static int[] a;

    public static void main(String[] args) {

		//topiki stin main...de moirazetai
        int numThreads = 4;
		
	    a = new int[numThreads];
	    
	    for (int i = 0; i < numThreads; i++) //topiki ths main...de moirazetai
			a[i] = 0; 

		//topiki tis main...den moirazetai
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) { //topiki tis main...moirazetai os orisma timis
		    counterThreads[i] = new CounterThread(i);
		    counterThreads[i].start();
		}

        for (int i = 0; i < numThreads; i++) { //topiki tis main...den moirazetai
            try {
				counterThreads[i].join();
				n = n + counterThreads[i].threadN;
            }
            catch (InterruptedException e) {}
		} 
        for (int i = 0; i < numThreads; i++) //topiki tis main...den moirazetai
			System.out.println("a["+i+"] = "+a[i]);
			
		System.out.println("n = "+n); 
    }
 }   

class CounterThread extends Thread {

	//instance variable...i main mporei na to prospelasei afou einai public
  	int threadID;
	//to idio kai edo
	int threadN;
	    
	public CounterThread(int tid) {
	    this.threadID = tid;
	    this.threadN = Lab1.n; //ola logika to 0 prolavainoun na paroun...an eixa perissotera mporei na eftana sta join kai kapoia na etrexan akoma kai na kanane arxikopoiisi kai na epairnan kapoia nea timi tou n...
	}
	  	
	public void run() {
	  
	    threadN = threadN + 1 + threadID;  
	    Lab1.a[threadID] = Lab1.a[threadID] + 1 + threadID;
		System.out.println("Thread "+threadID+" n = "+ threadN +"  a["+threadID+"] ="+ Lab1.a[threadID]);
	}
}

/*
Thread 0 n = 1 a[0] = 1
Thread 3 n = 4 a[3] = 4
Thread 2 n = 3 a[2] = 3
Thread 1 n = 2 a[1] = 2
a[0] = 1
a[1] = 2
a[2] = 3
n = 10
 */

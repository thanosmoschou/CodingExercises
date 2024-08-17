package shared;

public class MainArguments {

    public static void main(String[] args) {
        //topiki sthn main...den pernaei pouthena...
        int numThreads = 10;  

        //topiki stin main...pernaei os orisma timis...
		int n = 5;

        //topiki stin main...pernaei os orisma anaforas
	    int[] a = new int[numThreads];
	    for (int i = 0; i < numThreads; i++) //to i topiki stin main
			a[i] = i; 
			

        //topiki stin main...den pernaei pouthena
		CounterThread counterThreads[] = new CounterThread[numThreads];
		for (int i = 0; i < numThreads; i++) { //to i topiki stin main...pernaei os orisma timis...
		    counterThreads[i] = new CounterThread(i, n, a);
		    counterThreads[i].start();
		}

        //topiki stin main...den pernaei pouthena...
        int sum = 0;
        for (int i = 0; i < numThreads; i++) { //to i einai topiki stin main...den pernaei pouthena
            try {
				counterThreads[i].join();
				sum = sum + counterThreads[i].n;
            } catch (InterruptedException e) {}
		}
		
		System.out.println("sum = "+ sum);
		for (int i = 0; i < numThreads; i++) //to i topiki stin main...den pernaei pouthena
			System.out.println("a["+i+"] = "+a[i]); 	
    }

}

class CounterThread extends Thread {

    //instance attribute...mporei na epistrepsei timi stin main afou einai public...
    int threadID;

    //instance attribute...einai public ara epistrefei timi stin main...
    int n;

    //instance attribute...auto edo omos exei perasei os orisma anaforas ara mia metavoli epireazei kai tous allous...
    int[] a;
    
    public CounterThread(int tid, int n, int[] a) {
        this.threadID = tid;
        this.n = n;
        this.a = a;
    }
  	
    public void run() {

        //arxika ola ta nimata pirane tin timi 5 kathos einai orisma timis...
        n = n + threadID; //epireazetai mono tou nimatos...
        a[threadID] = a[threadID] + n; //mias kai to a einai pinakas kai perase os orisma anaforas, epireazontai oloi
        System.out.println("Thread "+threadID+ " my n = "+n+ " my a = "+a[threadID]); 
    }
}

/*
Pithanes ektiposeis...

Thread 0 my n = 5 my a = 5
Thread 2 my n = 7 my a = 9 (eixe to 2 kai prostethike to 7)
Thread 1 my n = 6 my a = 7
...
sum = ...
a[0] = 5
a[1] = 7
a[2] = 9
...
 */

/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task3;

/*
Prepei na oriseis kalo limit gia na min spame tzampa tin douleia se perissotera nimata apo osa xreiazetai
kai xanetai perissoteros xronos stin dromologisi kai diaxeirisi ton nimaton...
Des as poume:

int limit = 200000;
long numSteps = 100000000; // = 10000;

parallel program results with 100000000 steps
computed pi = 3,14159265358979130000
difference between estimated pi and Math.PI = 0,00000000000000177636
time to compute = 0,284000 seconds

let's change the limit
int limit = 2000000;
long numSteps = 100000000; // = 10000;

parallel program results with 100000000 steps
computed pi = 3,14159265358979360000
difference between estimated pi and Math.PI = 0,00000000000000044409
time to compute = 0,186000 seconds (vlepeis einai ligo pio grigoro)

pame ligo akoma na to auksisoume...
int limit = 20000000;
long numSteps = 100000000;

parallel program results with 100000000 steps
computed pi = 3,14159265358981500000
difference between estimated pi and Math.PI = 0,00000000000002176037
time to compute = 0,196000 seconds (ligo pio argo...)

pame na meiosoume to limit:
int limit = 20000;
long numSteps = 100000000;

tha deis oti einai arketa mikro kai xanetai tzampa xronos stin dromologisi ton threads...kathe nima mporei na parei perissoteri douleia...

parallel program results with 100000000 steps
computed pi = 3,14159265358978900000
difference between estimated pi and Math.PI = 0,00000000000000399680
time to compute = 8,602000 seconds

pame tora na auksisoume ta vimata...
int limit = 20000;
long numSteps = 1000000000;

an den ginei out of memory error tote tha einai poli argo (telika out of memory error) ...logika tora tha prepei na auksiso to limit...
vlepeis genika oti oi veltioseis erxontai me trial and error....


auksano to limit:
int limit = 200000;
long numSteps = 1000000000;

parallel program results with 1000000000 steps
computed pi = 3,14159265358980330000
difference between estimated pi and Math.PI = 0,00000000000001021405
time to compute = 8,332000 seconds

vlepeis einai argo...ara xanetai tzampa xronos kathos ta nimata den exoun douleia na kanoun kai o xronos
pou xanetai stin xronodromologisi tous einai perissoteros apo ton xrono pou apasxoloun tin cpu...


int limit = 2000000;
long numSteps = 1000000000;

parallel program results with 1000000000 steps
computed pi = 3,14159265358978820000
difference between estimated pi and Math.PI = 0,00000000000000488498
time to compute = 1,031000 seconds


int limit = 20000000;
long numSteps = 1000000000;

parallel program results with 1000000000 steps
computed pi = 3,14159265358977220000
difference between estimated pi and Math.PI = 0,00000000000002087219
time to compute = 1,080000 seconds (vlepeis peripou idio einai...)

int limit = 5000000;
long numSteps = 1000000000;

parallel program results with 1000000000 steps
computed pi = 3,14159265358978470000
difference between estimated pi and Math.PI = 0,00000000000000843769
time to compute = 0,933000 seconds

 */
public class NumIntParallel
{
    public static void main(String[] args)
    {
        /* parse command line*/
        /*
        if (args.length != 1) {
            System.out.println("arguments:  number_of_steps");
            System.exit(1);
        }
        try {
            numSteps = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("argument "+ args[0] +" must be long int");
            System.exit(1);
        }
        */

        int limit = 9000000; //if the limit is too small and I cut it to half and create 2 more threads in order to manage the workload, it may cause out of memory error
        long numSteps = 1000000000; // = 10000;
        double step = 1.0 / (double) numSteps;

        Shared shared = new Shared(step);

        /* start timing */
        long startTime = System.currentTimeMillis();

        //In recursive allocation I start from one thread and calculate the workload
        //If it is too much for my thread then I create two more threads inside my thread and
        //split the work...another approach is only to create only one thread, give the half workload
        //and make the current thread to calculate the other half...
        MyThread thread = new MyThread(0, numSteps, limit, shared, step);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {e.printStackTrace();}

        /* end timing and print result */
        long endTime = System.currentTimeMillis();

        double pi = shared.getPi();

        System.out.printf("parallel program results with %d steps\n", numSteps);
        System.out.printf("computed pi = %22.20f\n" , pi);
        System.out.printf("difference between estimated pi and Math.PI = %22.20f\n", Math.abs(pi - Math.PI));
        System.out.printf("time to compute = %f seconds\n", (double) (endTime - startTime) / 1000);
    }
}

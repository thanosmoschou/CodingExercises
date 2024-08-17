package task2.extra.worker;

public class WorkerProtocol
{
    private int numOfWorkers; //o worker tha paernaei sto protocol ton arithmo ton workers gia tin katanomi mas...

    public WorkerProtocol(int workers)
    {
        this.numOfWorkers = workers;
    }

    public String compute(String msg)
    {
        //msg format: numsteps id step

        /*
        Edo ti gineta...exo enan worker pou exei idi lavei kapoia douleia apo enan master...
        Afou ipologizo to PI, o kathe worker ipologizei ena local sum kai to stelnei piso...
        Epeita o master ipologizei to PI. Tora pou kathe worker exei na ipologisei ena local sum
        mporo na spaso tin douleia se alla helper threads kai auto kano edo...gia kathe leader worker
        exo vrei to range pou tha ipologisei sum kai auto to pernao stous helpers oste na ipologisoun nea
        katanomi stin idi iparxousa..meta auta ipologizoun topika ena athroisma kai to vazoun
        sto moirazomeno topiko athroisma tou leader worker...epeita o leader pairnei to teliko localSum pou ipologistike apo tous helpers...
         */

        String[] splitted = msg.split(" ");
        long numSteps = Long.parseLong(splitted[0]);
        int leaderWorkerId = Integer.parseInt(splitted[1]);
        double step = Double.parseDouble(splitted[2]);

        //to kommati tou leader worker...
        long block = numSteps / numOfWorkers;
        long start = leaderWorkerId * block;
        long stop = start + block;
        if (leaderWorkerId == numOfWorkers -1)
            stop = numSteps;


        //edo spao tin douleia gia tous helpers...
        int helpers = 8;

        long helpersTotalSteps = stop - start;
        long helperBlock = helpersTotalSteps / helpers;
        long helperFrom = start; //the leader's start
        long helperTo = helperFrom + helperBlock;

        WorkerShared shared = new WorkerShared();
        WorkerHelperThread[] helperThreads = new WorkerHelperThread[helpers];
        for (int i = 0; i < helpers; i++)
        {
            helperThreads[i] = new WorkerHelperThread(helperFrom, helperTo, step, shared);
            helperThreads[i].start();

            helperFrom = helperTo;
            helperTo = helperTo + helperBlock;
        }

        for (int i = 0; i < helpers; i++)
            try {
                helperThreads[i].join();
            } catch (InterruptedException e) {}

        double localSum = shared.getSum();
        return Double.toString(localSum);
    }
}

package task2.basic.worker;

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

        String[] splitted = msg.split(" ");
        long numSteps = Long.parseLong(splitted[0]);
        int workerId = Integer.parseInt(splitted[1]);
        double step = Double.parseDouble(splitted[2]);

        long block = numSteps / numOfWorkers;
        long start = workerId * block;
        long stop = start + block;
        if (workerId == numOfWorkers -1)
            stop = numSteps;

        double localSum = 0.0;
        for (long i = start; i < stop; i++)
        {
            double x = ((double) i + 0.5) * step;
            localSum += 4.0 / (1.0 + x * x);
        }

        System.out.println(localSum);
        return Double.toString(localSum);
    }
}

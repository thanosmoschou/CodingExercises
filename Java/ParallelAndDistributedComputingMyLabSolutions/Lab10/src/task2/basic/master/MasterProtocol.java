package task2.basic.master;

public class MasterProtocol
{
    private Shared shared;
    private long numSteps;
    private double step;
    private int workerId;

    public MasterProtocol(long numSteps, int workerId, double step, Shared shared)
    {
        this.numSteps = numSteps;
        this.workerId = workerId;
        this.step = step;
        this.shared = shared;
    }

    public String prepareRequest()
    {
        return numSteps + " " + workerId + " " + step;
    }

    public void handleResult(String res)
    {
        double localSum = Double.parseDouble(res);
        shared.addLocalSum(localSum);
    }
}

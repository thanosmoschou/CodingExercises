package task3.task3_1.server;

public class ServerProtocolCalculator
{
    public String getRequestAndReturnReply(String input)
    {
        long numSteps = Long.parseLong(input);
        double step = 1.0 / (double) numSteps;
        double sum = 0.0;
        double pi = 0.0;

        for (int i = 0; i < numSteps; i++)
        {
            double x = ((double) i + 0.5) * step;
            sum += 4.0 / (1.0 + x * x);
        }

        pi = sum * step;
        return Double.toString(pi);
    }


}

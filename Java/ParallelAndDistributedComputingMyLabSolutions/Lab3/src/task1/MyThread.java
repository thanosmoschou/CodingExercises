package task1;

public class MyThread extends Thread
{
    private int myId;
    private int start;
    private int stop;
    private double[] a;
    private double[] b;
    private double[] c;

    public MyThread(int i, int totalThreads, int arraySize, double[] aArr, double[] bArr, double[] cArr)
    {
        //statiki katanomi
        int blockSize = arraySize / totalThreads;
        this.myId = i;
        this.a = aArr;
        this.b = bArr;
        this.c = cArr;
        this.start = this.myId * blockSize;
        this.stop = this.start + blockSize;
        if (this.myId == totalThreads - 1)
            this.stop = arraySize;
    }

    @Override
    public void run()
    {
        //Keep in mind that if you want to calculate the computation time, you need to avoid printing things here...
        //Only computations here...
        for (int i = start; i < stop; i++)
            c[i] = a[i] + b[i];
    }

    public void printComputationRange()
    {
        System.out.println("Thread: " + this.myId + " computation range: " + this.start + "..." + this.stop);
    }
}

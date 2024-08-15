package task2;

public class SatThread extends Thread
{
    private int id;
    private int start;
    private int stop;
    private int circuitInputSize;

    public SatThread(int i, int circInpSize, int iterations, int threads)
    {
        id = i;
        circuitInputSize = circInpSize;
        int block = iterations / threads;
        start = id * block;
        stop = start + block;
        if (id == threads - 1)
            stop = iterations;
    }

    @Override
    public void run()
    {
        //System.out.println("Start: " + start + " Stop: " + stop); //only for debugging...do not contain printing when you calculate computation time...
        for (int i = start; i < stop; i++)
            check_circuit(i);
    }

    private void check_circuit(int z)
    {
        //System.out.println("Z = " + z);

        boolean[] v = new boolean[circuitInputSize];
        for (int k = circuitInputSize - 1; k >= 0; k--)
            v[k] = (z & (1 << k)) != 0;

        // Check the ouptut of the circuit for input v
        boolean value =
                (  v[0]  ||  v[1]  )
                        && ( !v[1]  || !v[3]  )
                        && (  v[2]  ||  v[3]  )
                        && ( !v[3]  || !v[4]  )
                        && (  v[4]  || !v[5]  )
                        && (  v[5]  || !v[6]  )
                        && (  v[5]  ||  v[6]  )
                        && (  v[6]  || !v[15] )
                        && (  v[7]  || !v[8]  )
                        && ( !v[7]  || !v[13] )
                        && (  v[8]  ||  v[9]  )
                        && (  v[8]  || !v[9]  )
                        && ( !v[9]  || !v[10] )
                        && (  v[9]  ||  v[11] )
                        && (  v[10] ||  v[11] )
                        && (  v[12] ||  v[13] )
                        && (  v[13] || !v[14] )
                        && (  v[14] ||  v[15] )
                        && (  v[14] ||  v[16] )
                        && (  v[17] ||  v[1]  )
                        && (  v[18] || !v[0]  )
                        && (  v[19] ||  v[1]  )
                        && (  v[19] || !v[18] )
                        && ( !v[19] || !v[9]  )
                        && (  v[0]  ||  v[17] )
                        && ( !v[1]  ||  v[20] )
                        && ( !v[21] ||  v[20] )
                        && ( !v[22] ||  v[20] )
                        && ( !v[21] || !v[20] )
                        && (  v[22] || !v[20] );

        // If output == 1 print v and z
        if (value)
            printResult(v, z);
    }

    // Printing utility
    private void printResult(boolean[] v, int z)
    {
        String result = null;
        result = String.valueOf(z);

        for (int i = 0; i < circuitInputSize; i++)
            if (v[i])
                result += " 1";
            else
                result += " 0";

        System.out.println(result);
    }
}

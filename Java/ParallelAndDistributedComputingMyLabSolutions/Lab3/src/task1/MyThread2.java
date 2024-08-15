package task1;

public class MyThread2 extends Thread
{
    private int myId;
    private int start;
    private int stop;
    private int totalColumnsPerRow;
    private double[][] a;
    private double[][] b;
    private double[][] c;

    public MyThread2(int i, int totalThreads, int totalRows, int columns, double[][] aArr, double[][] bArr, double[][] cArr)
    {
        //statiki katanomi
        int blockSize = totalRows / totalThreads;
        this.myId = i;
        this.totalColumnsPerRow = columns;
        this.a = aArr;
        this.b = bArr;
        this.c = cArr;
        this.start = this.myId * blockSize;
        this.stop = this.start + blockSize;
        if (this.myId == totalThreads - 1)
            this.stop = totalRows;
    }

    @Override
    public void run()
    {
        //Keep in mind that if you want to calculate the computation time, you need to avoid printing things here...
        //Only computations here...
        //Otan parallilizo 2d pinaka tote kano katanomi ston eksoteriko vroxo diladi
        //kano katanomi grammon sta nimata...edo kathe nima exei analavei kapoies grammes na prosthesei
        //kai tis prosthetei oles...gia auto vlepeis start stop ston eksoteriko vroxo kai mesa paei apo 0
        //mexri size...an eixa mono apla dianismata tote anatheto euros stoixeion sta nimata...eno edo anatheto
        //euros grammon...

        /*
        Gia eukolia exo tetragonikous pinakes...
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                c[i][j] = a[i][j] + b[i][j];

         To arxiko htan etsi kai ego eprepe na to paralliliso...ara parallilizo mono ton eksoteriko vroxo...
         Opote thimisou ta vimata...pairno to esoteriko opos einai kai to vazo sta nimata, omos to perikleio
         se mia for me start kai stop...ara edo ti leo? Arxika ena nima analamvane oles tis grammes (eksoterikos vroxos)
         gia na kanei prosthesi...eno edo den thelo mono ena nima...thelo ta nimata na analavoun euros grammon...
         Ara kano katanomi stis grammes kai kathe nima tha analavei apo thn grammi tade mexri tin grammi tade (start...stop)
         Opote edo prepei na exo perasei kai to mikos ton grammon (arraySize) oste o esoterikos vroxos na treksei kanonika gia oli
         tin grammi kathe fora...
         */
        for (int i = start; i < stop; i++)
            for (int j = 0; j < this.totalColumnsPerRow; j++)
                c[i][j] = a[i][j] + b[i][j];
    }

    public void printComputationRange()
    {
        System.out.println("Thread: " + this.myId + " computation range from row: " + this.start + " to row " + this.stop);
    }
}

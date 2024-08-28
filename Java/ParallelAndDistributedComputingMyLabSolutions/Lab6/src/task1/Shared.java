package task1;

public class Shared
{
    private int matchCtr;
    private Object lockObject;

    public Shared(int matchLength)
    {
        this.lockObject = new Object();
        matchCtr = 0;

        //o pinakas match deixnei se poion xaraktira tou keimenou mou ksekinaei to pattern...gia auto vlepeis exei mikos n-m
        //px an exo keimeno 100 xaraktiron kai to pattern einai 10 xaraktires, tote tha pao na sigkrino mexri tin thesi 90 (n-m)
        //oste saronontas olo to pattern, an vro match auto na ginei isa isa mexri tin thesi 100 dhl thn teleutaia thesi...
        //an pigaina mexri telos px mexri tin 100 kai ksekinousa na sigkrino xaraktires me to pattern mou, tha evgaina out of bounds...
        //oppte an px vrethei ena match ston xaraktira 10 (kai paei mexri ton 20 afou to pattern einai 10) tote tha pame stin thesi 10
        //tou match kai tha valoume tin timi 1 oste na ksero se poio simeio tou keimenou ksekinaei to pattern...

        //for (int i = 0; i < matchLength; i++)
        //    match[i] = 0;
    }


    public void addLocalMatchCtr(int localMatchCtr)
    {
        synchronized (lockObject)
        {
            this.matchCtr += localMatchCtr;
        }
    }

    /*
    public void addLocalMatchArr(int[] localMatchArr)
    {
        synchronized (lockObject)
        {
            for (int i = 0; i < matchLength; i++)
            {
                match[i] += localMatchArr[i];
            }
        }
    }

    public void printMatches()
    {
        for (int i = 0; i < matchLength; i++)
            if (match[i] == 1)
                System.out.print(i+" ");
    }
    */

    public int getMatchCtr()
    {
        return matchCtr;
    }
}

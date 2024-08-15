package task1;

public class Shared
{
    private char[] match;
    private int matchCtr;
    private Object lockObject;
    private int matchLength;

    public Shared(int matchLength)
    {
        match = new char[matchLength + 1];
        this.matchLength = matchLength;
        this.lockObject = new Object();
        matchCtr = 0;

        for (int i = 0; i < matchLength; i++)
            match[i] = '0';
    }

    /*
    public void addLocalMatchCtr(int localMatchCtr)
    {
        synchronized (lockObject)
        {
            this.matchCtr += localMatchCtr;
        }
    }

    //kathe nima grafei se ksexoristes theseis ara kalo einai na pernao kai to range oste na min svinontai
    //proigoumenes times...lathos ilopoiisi min tin dineis simasia...
    public void addLocalMatchArr(char[] localMatchArr, int from, int to)
    {
        for (int i = from; i < to; i++)
        {
            match[i] = localMatchArr[i];
        }
    }
    */

    //oute auto vouleuei kala...
    public void addLocalMatchArrAndIncreaseMatchCtr(int index)
    {
        synchronized (lockObject)
        {
            matchCtr++;
            match[index] = '1';
        }
    }

    /*public void increaseMatchCtr()
    {
        synchronized (lockObject)
        {
            matchCtr++;
        }
    }*/

    public void printMatches()
    {
        for (int i = 0; i < matchLength; i++)
            if (match[i] == '1')
                System.out.print(i+" ");
    }

    public int getMatchCtr()
    {
        return matchCtr;
    }
}

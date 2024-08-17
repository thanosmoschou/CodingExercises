package task3;

public class MyThread extends Thread
{
    private long from;
    private long to;
    private int limit;
    private Shared shared;
    private double localSum;
    private double step;

    public MyThread(long from, long to, int limit, Shared sh, double step)
    {
        this.from = from;
        this.to = to;
        this.limit = limit;
        this.shared = sh;
        this.step = step;
        this.localSum = 0.0;
    }

    @Override
    public void run()
    {
        long workLoad = this.to - this.from;

        if (workLoad <= limit) //go until limit (<= and not <)
        {
            for (long i = from; i < to; i++)
            {
                double x = ((double)i+0.5)*step;
                localSum += 4.0/(1.0+x*x);
            }

            //otan to kathe nima ftasei na ipologisei topika ton forto tou, tote kane kai tin anagogi sou...
            shared.addLocalSum(localSum);

            //min mperdeuteis kai valeis sto else anagogi gt tha prostheseis extra values...isos se alles periptoseis
            //na thelei alla genika prosexe pou vazeis...

            /*
            An den exeis shared object alla ksekinises apo ena nima kai espases thn douleia se perissotera, tote prepei
            sto proto nima na prostethoun oi merikes times otan ola teleiosoun...ara otan kathe nima afou spasei tin douleia se perissotera nimata kai
            to kathe extra nima teleiosei (ekei sto else pou ta spas
            kai ta kaneis join) tote to parent nima prepei na prosthesei tis times tous stin kiria topiki metavliti tou...etsi kaneis anagogi
            ton merikon timon stin timi tou protou nimatos kai ekei meta i main kalei tin get gia to proto nima...

            An exeis shared object tote kane auto pou kano edo...
             */
        }
        else
        {
            long mid = this.from + workLoad / 2;

            MyThread left = new MyThread(from, mid, limit, shared, step);
            left.start();

            MyThread right = new MyThread(mid, to, limit, shared, step);
            right.start();

            /*
             * Ksekinao ta nimata, ta dino douleia kai ta afino stin moira tous...auta apo mona tous tha valoun tis topikes times tous ekei pou prepei (otan
             * to fortio ginei toso mikro kai to kathe nima den spasei tin douleia alla to ipologisei, tote tha kanei anagogi tis topikis tou metavlitis
             * sthn shared...)... den xreiazetai na sillekso kamia timi apo ta left kai right sthn periptosi mou...des pano pou leo pote prepei na sillekseis tis times apo ta 
             * nimata...
             */

            try {
                left.join();
                right.join();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
    }
}

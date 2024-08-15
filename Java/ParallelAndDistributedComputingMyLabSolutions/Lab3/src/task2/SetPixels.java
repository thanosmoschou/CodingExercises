/*
Author: Thanos Moschou
Description: Parallel And Distributed Computing Lab Solutions...
 */

package task2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Sequential time: 900 ms
//Parallel time: 500 ms

public class SetPixels
{
    public static void main(String[] args)
    {
        String fileNameR = "src/task2/original.jpg";
        String fileNameW = "src/task2/newPixels.jpg";

        BufferedImage img = null;
        int width = 0, height = 0;

        try
        {
            img = ImageIO.read(new File(fileNameR));
            width = img.getWidth();
            height = img.getHeight();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Coefficinets of R G B to GrayScale
        int redShift = 100;
        int greenShift = 100;
        int blueShift = 100;

        //Start timing
        long start = System.currentTimeMillis();

        int totalThreads = Runtime.getRuntime().availableProcessors();
        PixelThread[] threads = new PixelThread[totalThreads];

        for (int i = 0; i < totalThreads; i++)
        {
            threads[i] = new PixelThread(i, height, width, totalThreads, img, redShift, greenShift, blueShift);
            threads[i].start();
        }

        for (int i = 0; i < totalThreads; i++)
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e) {}
        }

        //Stop timing
        long elapsedTimeMillis = System.currentTimeMillis()-start;

        //Saving the modified image to Output file
        try
        {
            File file = new File(fileNameW);
            if (img != null)
                ImageIO.write(img, "jpg", file);
        }
        catch (IOException e) {}

        System.out.println("Done...");
        System.out.println("time in ms = "+ elapsedTimeMillis);

    }
}

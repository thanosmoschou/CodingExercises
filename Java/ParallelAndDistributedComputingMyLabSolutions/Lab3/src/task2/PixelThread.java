package task2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelThread extends Thread
{
    private int id;
    private int start;
    private int stop;
    private BufferedImage img;
    private int width;
    private double redShift, greenShift, blueShift;

    public PixelThread(int i, int heigth, int aWidth, int totalThreads, BufferedImage buffImg, double r, double g, double b)
    {
        id = i;
        width = aWidth;
        img = buffImg;
        redShift = r;
        greenShift = g;
        blueShift = b;
        int block = heigth / totalThreads;
        start = id * block;
        stop = start + block;
        if (id == totalThreads - 1)
            stop = heigth;
    }

    @Override
    public void run()
    {
        for (int y = start; y < stop; y++)
        {
            for (int x = 0; x < width; x++)
            {
                //Retrieving contents of a pixel
                int pixel = img.getRGB(x,y);
                //Creating a Color object from pixel value
                Color color = new Color(pixel, true);
                //Retrieving the R G B values, 8 bits per r,g,b
                //Calculating GrayScale
                int red = (int) (color.getRed() + redShift) % 256;
                int green = (int) (color.getGreen() + greenShift) % 256;
                int blue = (int) (color.getBlue() + blueShift) % 256;
                //Creating new Color object
                color = new Color(red, green, blue);
                //Setting new Color object to the image
                img.setRGB(x, y, color.getRGB());
            }
        }
    }
}

/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/


package ex2ch1Java;

import java.util.Scanner;

public class Triangle
{
    private int side1;
    private int side2;
    private int emvado;

    public Triangle()
    {
        side1 = 1;
        side2 = 1;
        emvado = 0;
    }

    public void readSides()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the dimension of the first side: ");
        side1 = keyboard.nextInt();

        System.out.println("Please enter the dimension of the second side: ");
        side2 = keyboard.nextInt();
    }

    public void findEmvado()
    {
        emvado = (side1 * side2) / 2;
    }

    public void setSide1(int newSide)
    {
        side1 = newSide;
    }

    public void setSide2(int newSide)
    {
        side2 = newSide;
    }

    public int getSide1()
    {
        return side1;
    }

    public int getSide2()
    {
        return side2;
    }

    public int getEmvado()
    {
        return emvado;
    }
    
}

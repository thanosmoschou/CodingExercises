/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex2ch1Java;

public class Main
{
    public static void main(String[] args)
    {
        Triangle newTriangle = new Triangle();

        newTriangle.readSides();
        newTriangle.findEmvado();
        System.out.println("1st side: " + newTriangle.getSide1());
        System.out.println("2nd side: " + newTriangle.getSide2());
        System.out.println("Emvado: " + newTriangle.getEmvado());
    }
}

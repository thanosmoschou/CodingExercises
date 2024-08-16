package task3.task3_2;

import java.util.Scanner;

public class ClientProtocolCalculator
{
    private Scanner keyboard = new Scanner(System.in);

    private void printPrompt()
    {
        System.out.println("************************************");
        System.out.println("Enter a number of steps for PI calculation...");
        System.out.println("To exit enter -1");
    }

    public String prepareRequest()
    {
        String msg;

        printPrompt();
        System.out.print("> ");
        msg = keyboard.nextLine();

        return msg;
    }

    public void processReply(String reply)
    {
        System.out.println("Reply from server: " + reply + "\n");
        System.out.println("Difference from Java's PI in math library: " + Math.abs(Double.parseDouble(reply) - Math.PI));
    }
}

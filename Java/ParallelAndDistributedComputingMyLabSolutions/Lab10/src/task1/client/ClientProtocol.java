package task1.client;

import java.util.Scanner;

public class ClientProtocol
{
    private Scanner keyboard;

    public ClientProtocol()
    {
        keyboard = new Scanner(System.in);
    }

    public String prepareOutput()
    {
        System.out.print("Enter something: ");
        String msg = keyboard.nextLine();

        return msg;
    }

    public void readInput(String rep)
    {
        System.out.println(rep);
    }
}

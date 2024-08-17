package task1.client;

import java.util.Scanner;

public class ClientProtocolCalculator
{
    private Scanner keyboard = new Scanner(System.in);

    private void printPrompt()
    {
        System.out.println("************************************");
        System.out.println("Input format: op num1 num2");
        System.out.println("Example: + 4 3");
        System.out.println("Respose format: R result");
        System.out.println("Example: R 7");
        System.out.println("Error Response: E errCode");
        System.out.println("E divByZero");
        System.out.println("To exit just type: !");
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
    }
}

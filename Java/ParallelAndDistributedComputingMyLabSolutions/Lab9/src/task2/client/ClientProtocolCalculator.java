package task2.client;

import task2.Reply;
import task2.Request;

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

    public Request prepareRequest()
    {
        String msg;
        String[] splitMsg;
        Request request = new Request();

        printPrompt();
        System.out.print("> ");

        msg = keyboard.nextLine();

        if (msg.equals("!"))
        {
            request.setOpCode('!');
            return request;
        }

        splitMsg = msg.split(" ");

        //I have num1, num2 as strings because maybe user enters something different than numbers and now I transfer objects instead of string...
        request.setOpCode(splitMsg[0].charAt(0));
        request.setNum1(splitMsg[1]);
        request.setNum2(splitMsg[2]);

        return request;
    }

    public void processReply(Reply reply)
    {
        System.out.println("Reply from server: " + reply.getReplyAsAString() + "\n");
    }
}

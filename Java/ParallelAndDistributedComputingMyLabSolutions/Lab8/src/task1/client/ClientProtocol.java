package task1.client;

import java.util.Scanner;

public class ClientProtocol
{
    private Scanner keyboard = new Scanner(System.in);

    private void printPrompt()
    {
        System.out.println("************************************");
        System.out.println("AVAILABLE MODES:");
        System.out.println("1. CONVERT UPPERCASE CHARACTERS TO LOWERCASE. FOR THIS MODE JUST ENTER SOME TEXT.");
        System.out.println("2. CONVERT LOWERCASE CHARACTERS TO UPPERCASE. FOR THIS MODE JUST ENTER SOME TEXT.");
        System.out.println("3. CEASAR'S CYPHER ENCRYPTION. FOR THIS MODE FIRST ENTER SOME TEXT AND THEN ENTER THE ENCRYPTION KEY (OFFSET)");
        System.out.println("4. CEASAR'S CYPHER DECRYPTION. FOR THIS MODE FIRST ENTER SOME ENCRYPTED TEXT AND THEN ENTER ΤΗΕ DECRYPTION KEY (OFFSET).");
        System.out.println("ENTER YOUR MESSAGE WITH THE FOLLOWING FORMAT: MODE, YOUR TEXT, AND YOUR ENCRYPTION/DECRYPTION KEY (IF ANY).");
        System.out.println("TO EXIT THE APP JUST SIMPLY ENTER THE WORD EXIT...");
        System.out.println("INPUT EXAMPLE: 3, HeLLo, 24");
        System.out.println("ANOTHER INPUT EXAMPLE: 2, HELLO");
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

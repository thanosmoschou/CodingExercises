package task1.server;

public class ServerProtocolCalculator
{
    public String getRequestAndReturnReply(String input)
    {
        String[] splitInput = input.split(" ");
        char op = splitInput[0].charAt(0);
        int num1, num2;

        try {
            num1 = Integer.parseInt(splitInput[1]);
            num2 = Integer.parseInt(splitInput[2]);
        } catch (NumberFormatException e) {
            return "E notNumbersError";
        }

        switch (op)
        {
            case '+':
                return "R " + (num1 + num2);
            case '-':
                return "R " + (num1 - num2);
            case '*':
                return "R " + (num1 * num2);
            case '/':
                if (num2 != 0)
                    return "R " + (num1 / num2);
                else
                    return "E divByZero";
            default:
                return "E unknownOperatorError";

        }
    }


}

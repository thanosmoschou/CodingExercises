package task2.server;

import task2.Reply;
import task2.Request;

public class ServerProtocolCalculator
{
    public Reply getRequestAndReturnReply(Request input)
    {
        char op = input.getOpCode();
        int num1, num2;
        Reply rep = new Reply();

        try {
            num1 = Integer.parseInt(input.getNum1());
            num2 = Integer.parseInt(input.getNum2());
        } catch (NumberFormatException e) {
            rep.setStatus('E');
            rep.setErrorMsg("notNumbers");
            return rep;
        }

        switch (op)
        {
            case '+':
                rep.setStatus('R');
                rep.setResult(num1 + num2);
                return rep;
            case '-':
                rep.setStatus('R');
                rep.setResult(num1 - num2);
                return rep;
            case '*':
                rep.setStatus('R');
                rep.setResult(num1 * num2);
                return rep;
            case '/':
                if (num2 != 0)
                {
                    rep.setStatus('R');
                    rep.setResult(num1 / num2);
                }
                else
                {
                    rep.setStatus('E');
                    rep.setErrorMsg("divisionByZero");
                }
                return rep;
            default:
                rep.setStatus('E');
                rep.setErrorMsg("unknownError");
                return rep;
        }

    }
}

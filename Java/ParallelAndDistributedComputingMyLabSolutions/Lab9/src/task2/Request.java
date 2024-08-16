package task2;

import java.io.Serializable;

public class Request implements Serializable
{
    private char opCode;
    private String num1;
    private String num2;

    public Request()
    {
        opCode = ' ';
        num1 = "-1";
        num2 = "-1";
    }

    public Request(char anOpCode, String n1, String n2)
    {
        this.opCode = anOpCode;
        this.num1 = n1;
        this.num2 = n2;
    }

    public char getOpCode()
    {
        return opCode;
    }

    public void setOpCode(char opCode)
    {
        this.opCode = opCode;
    }

    public String getNum1()
    {
        return num1;
    }

    public void setNum1(String num1)
    {
        this.num1 = num1;
    }

    public String getNum2()
    {
        return num2;
    }

    public void setNum2(String num2)
    {
        this.num2 = num2;
    }

    public String getRequestAsAString()
    {
        return opCode + " " + num1 + " " + num2;
    }


}

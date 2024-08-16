package task2;

import java.io.Serializable;

public class Reply implements Serializable
{
    private char status;
    private int result;
    private String errorMsg;

    public Reply()
    {
        status = ' ';
        result = -1;
        errorMsg = "";
    }

    public Reply(char st, int result)
    {
        status = st;
        this.result = result;
        errorMsg = "";
    }

    public Reply(char st, String error)
    {
        status = st;
        this.result = -1;
        this.errorMsg = error;
    }

    public void setStatus(char st)
    {
        status = st;
    }

    public void setResult(int res)
    {
        result = res;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getReplyAsAString()
    {
        if (status == 'R')
            return status + " " + result;
        else //status = 'E'
            return status + " " + errorMsg;
    }

}

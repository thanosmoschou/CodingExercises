package com.example.thema_2;

public class Calculator {
    private int num1;
    private int num2;

    public Calculator(String input) {
        String[] operands = input.split("\\*");
        this.num1 = Integer.parseInt(operands[0]);
        this.num2 = Integer.parseInt(operands[1]);
    }

    public int multi()
    {
        return num1 * num2;
    }
}

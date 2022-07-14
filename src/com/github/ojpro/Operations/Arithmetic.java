package com.github.ojpro.Operations;

import static com.github.ojpro.Interfaces.Basic.setDisplay;

public class Arithmetic implements Main {

    public static double result = 0;
    private static boolean calculating = true;
    private static String operator = "=";
    public static String[] operations = {"-", "+", "÷", "×", "%", "!", "√", "^", "=", "mod", "sin", "cos", "tan", "e"};

    public static String getOperator() {
        return operator;
    }

    public static void setOperator(String operator) {
        Arithmetic.operator = operator;
    }

    public static boolean isCalculating() {
        return calculating;
    }

    public static void setCalculating(boolean calculating) {
        Arithmetic.calculating = calculating;
    }

    public static void calculate(double number) {

        switch (getOperator()) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "÷":
                result /= number;
                break;
            case "×":
                result *= number;
                break;
            case "%":
                result = (result / 100) * number;
                break;
            case "√":
                result = Math.sqrt(number);
                break;
            case "^":
                result = Math.pow(result, number);
                break;
            case "e":
                result = Math.exp(number);
                break;
            case "=":
                result = number;
                break;
            case "!":
                result = factorial(number);
                break;
            case "mod":
                result = result % number;
                break;
            case "sin":
                result = Math.sin(number);
                break;
            case "cos":
                result = Math.cos(number);
                break;
            case "tan":
                result = Math.tan(Math.toRadians(number));
                break;
        }
        setDisplay(String.format("%.2f", result));
    }

    public static double factorial(double num) {
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }

}

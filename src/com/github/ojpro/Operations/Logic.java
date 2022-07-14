package com.github.ojpro.Operations;

import com.github.ojpro.Interfaces.Programming;

public class Logic {
    public static int getBinary() {
        String str = Programming.binaryField.getText();
        return Integer.parseInt(str, 2);
    }

    public static int getOctal() {
        String str = Programming.octalField.getText();
        return Integer.parseInt(str, 8);
    }

    public static int getDecimal() {
        String str = Programming.decimalField.getText();
        return Integer.parseInt(str);
    }

    public static String getHexadecimal() {
        String str = Programming.hexadecimalField.getText();
        return "" + Integer.parseInt(str, 16);
    }

    public static void binaryChanged() {
        Programming.octalField.setText(Integer.toOctalString(getBinary()));
        Programming.decimalField.setText(Integer.toString(getBinary()));
        Programming.hexadecimalField.setText(Integer.toHexString(getBinary()));
    }

    public static void octalChanged() {
        Programming.binaryField.setText(Integer.toBinaryString(getOctal()));
        Programming.decimalField.setText(Integer.toString(getOctal()));
        Programming.hexadecimalField.setText(Integer.toHexString(getOctal()));
    }

    public static void decimalChanged() {
        Programming.binaryField.setText(Integer.toBinaryString(getDecimal()));
        Programming.octalField.setText(Integer.toOctalString(getDecimal()));
        Programming.hexadecimalField.setText(Integer.toHexString(getDecimal()));
    }

    public static void hexadecimalChanged() {
        Programming.binaryField.setText(Integer.toBinaryString(Integer.parseInt(getHexadecimal())));
        Programming.octalField.setText(Integer.toOctalString(Integer.parseInt(getHexadecimal())));
        Programming.decimalField.setText(String.valueOf(Integer.parseInt(getHexadecimal())));
    }

}

package com.github.ojpro;

import com.github.ojpro.Interfaces.Basic;
import com.github.ojpro.Interfaces.Programming;
import com.github.ojpro.Interfaces.Scientific;

public class JCalculator {
    public static Programming dev;
    public static Scientific smart;

    public static void main(String[] args) {
        // Create Two Calc Objects
        smart = new Scientific("SMart", 400, 400);
        dev = new Programming("Dev", 320, 320);
        // Auto show Scientific Calculator
        smart.setVisibility(true);
    }
}

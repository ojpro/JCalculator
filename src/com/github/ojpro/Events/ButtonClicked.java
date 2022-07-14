package com.github.ojpro.Events;

import com.github.ojpro.Interfaces.Basic;
import com.github.ojpro.Interfaces.Main;
import com.github.ojpro.Interfaces.Scientific;
import com.github.ojpro.Operations.Arithmetic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ButtonClicked implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        boolean isContainDot = Main.getDisplay().contains(".");
        if (cmd.contains(".") && !isContainDot) {
            Main.addToDisplay(cmd);
        }

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            if (Arithmetic.isCalculating()) {
                Main.setDisplay(cmd);
            } else {
                Main.addToDisplay(cmd);
            }
            Arithmetic.setCalculating(false);
        } else {
            if (Arithmetic.isCalculating()) {
                if (cmd.equals("-")) {
                    Main.setDisplay(cmd);
                    Arithmetic.setCalculating(false);
                } else {
                    Arithmetic.setOperator(cmd);
                }
            }
            if (Arrays.asList(Arithmetic.operations).contains(cmd)) {
                double number = Double.parseDouble(Main.getDisplay());
                Arithmetic.calculate(number);
                Arithmetic.setOperator(cmd);
                Arithmetic.setCalculating(true);
            }
            if (cmd.equals("AC")) {
                Main.clearDisplay();
            }
            if (cmd.equals(" ")) {
                Main.generateRandomColor();
            }
            if (cmd.equals("C")) {
                if (Main.getDisplay().length() > 1) Main.clear();
            }

        }
    }
}

package com.github.ojpro.Interfaces;

import com.github.ojpro.Events.ButtonClicked;
import com.github.ojpro.Operations.Arithmetic;

import javax.swing.*;
import java.awt.*;

public class Scientific extends Main {

    public Scientific(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);

        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.setBorder(BorderFactory.createEmptyBorder());
        container.add(wrapper, BorderLayout.CENTER);
        generateDisplay();

        generateButtons();
    }

    public void generateDisplay() {
        JPanel screen = new JPanel(new GridLayout(1, 1));
        Font displayFont = new Font("SansSerif", Font.BOLD, 58);

        screen.setMaximumSize(new Dimension(super.getWidth(), 120));

        display = new JTextField("0");
        display.setFont(displayFont);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        display.setBorder(BorderFactory.createEmptyBorder());
        display.setBackground(Color.black);
        display.setForeground(Color.white);
        screen.add(display);

        wrapper.add(screen);
    }

    public void generateButtons() {
        Font displayFont = new Font("SansSerif", Font.BOLD, 14);
        String[] buttonValues = {"AC", "C", " ", "!", "e", "^", "tan", "cos", "sin", "÷", "mod", "9", "7", "8", "×", "%", "4", "5", "6", "-", "√", "1", "2", "3", "+", " ", "0", "•", "=", " "};
        buttonsPanel = new JPanel(new GridLayout(6, 5));

        for (String buttonValue : buttonValues) {
            JButton btn = new JButton(buttonValue);
            btn.setBorder(BorderFactory.createEmptyBorder());
            btn.setForeground(Color.white);
            btn.setFont(displayFont);
            btn.addActionListener(new ButtonClicked());
            buttonsPanel.add(btn);
        }
        generateRandomColor();
        wrapper.add(buttonsPanel);
    }

    public static String getDisplay() {
        return display.getText();
    }

    public static void addToDisplay(String text) {
        setDisplay(getDisplay() + text);
    }

    public static void setDisplay(String text) {
        display.setText(text);
    }


    public static void generateRandomColor() {
        int randomInt = (int) Math.floor(Math.random() * randomColors.length);
        String color = randomColors[randomInt];
        int countComponents = buttonsPanel.getComponentCount();
        for (int i = 0; i < countComponents; i++) {
            JButton btn = (JButton) buttonsPanel.getComponent(i);
            btn.setBackground(Color.decode(color));
        }
        buttonsPanel.setBackground(Color.decode(color));
    }
}

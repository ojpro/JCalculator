package com.github.ojpro.Interfaces;

import com.github.ojpro.Events.MenuItemClicked;
import com.github.ojpro.Operations.Arithmetic;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static JTextField display;
    protected Container container;
    protected JPanel wrapper;
    protected static final String[] randomColors = {"#ffa502", "#2f3542", "#ff4757", "#2ed573", "#5352ed", "#3742fa"};
    protected static JPanel buttonsPanel;

    public Main() {
        // CLose Program on exit
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        // Display at the top
        setAlwaysOnTop(true);
        // Auto Focus on the window
        setAutoRequestFocus(true);
        // Center the window
        setLocationRelativeTo(null);

        init();

        setVisibility(false);
        wrapper = new JPanel();
    }

    public void init() {
        generateMenuBar();
        container = getContentPane();
    }

    public void setVisibility(boolean visibility) {
        this.setVisible(visibility);
    }

    public boolean toggleVisibility() {
        this.setVisible(!this.isVisible());
        return this.isVisible();
    }

    public void generateMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("View");

        JMenuItem scientific = new JMenuItem("Scientific");
        JMenuItem programming = new JMenuItem("Programming");

        scientific.addActionListener(new MenuItemClicked());
        programming.addActionListener(new MenuItemClicked());

        menu.add(scientific);
        menu.add(programming);

        menuBar.add(menu);

        this.setJMenuBar(menuBar);
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

    public static void clear() {
        String text = getDisplay();
        String c = text.substring(0, text.length() - 1);
        Arithmetic.result -= Double.parseDouble(c);
        setDisplay(c);
    }

    public static void clearDisplay() {
        setDisplay("0");
        Arithmetic.setOperator("=");
        Arithmetic.result = 0;
        Arithmetic.setCalculating(true);
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

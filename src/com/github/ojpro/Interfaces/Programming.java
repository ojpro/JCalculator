package com.github.ojpro.Interfaces;

import com.github.ojpro.Events.Typing;

import javax.swing.*;
import java.awt.*;

public class Programming extends Main {
    public static JTextField binaryField, octalField, decimalField, hexadecimalField;

    public Programming(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        wrapper.setLayout(null);
        wrapper.setBorder(BorderFactory.createEmptyBorder());
        container.add(wrapper, BorderLayout.CENTER);

        initialize();
    }

    public void initialize() {

        String[] labels = {"Binary : ", "Octal : ", "Decimal : ", "Hexadecimal : "};
        int[] startPosition = {20,80,140,200};
        for (int i = 0 ;i<labels.length;i++){
            JLabel jLabel = new JLabel(labels[i]);
            jLabel.setBounds(10, startPosition[i] , 90, 20);
            wrapper.add(jLabel);
        }

        binaryField = new JTextField();
        octalField = new JTextField();
        decimalField = new JTextField();
        hexadecimalField = new JTextField();

        binaryField.setBounds(10, 40, 300, 35);
        octalField.setBounds(10, 100, 300, 35);
        decimalField.setBounds(10, 160, 300, 35);
        hexadecimalField.setBounds(10, 220, 300, 35);

        binaryField.addKeyListener(new Typing());
        octalField.addKeyListener(new Typing());
        decimalField.addKeyListener(new Typing());
        hexadecimalField.addKeyListener(new Typing());

        wrapper.add(binaryField);
        wrapper.add(octalField);
        wrapper.add(decimalField);
        wrapper.add(hexadecimalField);

        wrapper.setBackground(Color.decode("#ecf0f1"));
    }
}

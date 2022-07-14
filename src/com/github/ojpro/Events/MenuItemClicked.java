package com.github.ojpro.Events;


import com.github.ojpro.Interfaces.Main;
import com.github.ojpro.JCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemClicked implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = e.getActionCommand();
        if (selectedItem.equals("Scientific")) {
            JCalculator.dev.setVisibility(false);
            JCalculator.smart.setVisibility(true);
        } else if (selectedItem.equals("Programming")) {
            JCalculator.smart.setVisibility(false);
            JCalculator.dev.setVisibility(true);
        }
    }
}

package com.github.ojpro.Events;

import com.github.ojpro.Interfaces.Programming;
import com.github.ojpro.Operations.Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Typing implements KeyListener {


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        char c = keyEvent.getKeyChar();
        String regex = "0123456789ABCDEF";
        if (keyEvent.getSource() == Programming.binaryField) {
            if (!regex.substring(0, 2).contains(String.valueOf(c))) {
                keyEvent.consume();
            }
        } else if (keyEvent.getSource() == Programming.octalField) {
            if (!regex.substring(0, 8).contains(String.valueOf(c))) {
                keyEvent.consume();
            }
        } else if (keyEvent.getSource() == Programming.decimalField) {
            if (!regex.substring(0, 10).contains(String.valueOf(c))) {
                keyEvent.consume();
            }
        } else if (keyEvent.getSource() == Programming.hexadecimalField) {
            if (!regex.contains(String.valueOf(c).toUpperCase())) {
                keyEvent.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getSource() == Programming.binaryField) {
            Logic.binaryChanged();
        } else if (keyEvent.getSource() == Programming.octalField) {
            Logic.octalChanged();
        } else if (keyEvent.getSource() == Programming.decimalField) {
            Logic.decimalChanged();
        } else if (keyEvent.getSource() == Programming.hexadecimalField) {
            Logic.hexadecimalChanged();
        }
    }


}

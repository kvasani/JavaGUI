package com.kailash.tutorial.swing.ch27.gui;

import javax.swing.*;

/**
 * Created by kailash on 3/30/20.
 * <p>
 * demonstrates form data saving into Swing table
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }

}

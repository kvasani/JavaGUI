package com.kailash.tutorial.swing.ch28.gui;

import javax.swing.*;

/**
 * Created by kailash on 3/30/20.
 * <p>
 * demonstrates saving data to and loading data from file into Table
 * usage of popup menu in Table to allow deletion of row
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

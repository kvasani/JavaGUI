package com.kailash.tutorial.swing.ch22;

import javax.swing.*;

/**
 * Created by kailash on 3/30/20.
 * This one adds confirmation dialog box prior to quitting application
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

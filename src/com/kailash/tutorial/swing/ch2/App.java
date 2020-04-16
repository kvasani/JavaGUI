package com.kailash.tutorial.swing.ch2;

import javax.swing.*;

/**
 * Created by kailash on 3/30/20.
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Hello World");
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}

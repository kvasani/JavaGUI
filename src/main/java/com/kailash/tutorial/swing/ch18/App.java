package com.kailash.tutorial.swing.ch18;

import javax.swing.*;

/**
 * Created by kailash on 3/30/20.
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

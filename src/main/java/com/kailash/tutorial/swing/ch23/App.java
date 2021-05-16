package com.kailash.tutorial.swing.ch23;

import javax.swing.*;

/**
 * Created by kailash on 3/30/20.
 * <p>
 * this one adds file open dialog box to export menu option
 * demonstrates setting up file chooser with custom file extension
 * * custom panels in file chooser dialog for file contents ??
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

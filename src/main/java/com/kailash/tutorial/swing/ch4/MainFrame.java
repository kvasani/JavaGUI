package com.kailash.tutorial.swing.ch4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kailash on 3/30/20.
 */
public class MainFrame extends JFrame {

    private final JTextArea textArea;
    private final JButton btn;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        btn = new JButton("Click Me");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hello World\n");
            }
        });
        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

package com.kailash.tutorial.swing.ch7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

/**
 * Created by kailash on 3/30/20.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private JButton btn;
    private Toolbar toolbar;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        btn = new JButton("Click Me");
        textPanel = new TextPanel();
        toolbar = new Toolbar();

        toolbar.setTextPanel(textPanel);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textPanel.appendText("Hello World \n");
            }
        });

        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

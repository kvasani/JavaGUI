package com.kailash.tutorial.swing.ch10;

import javax.swing.*;
import javax.swing.border.Border;
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

    private FormPanel formPanel;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        btn = new JButton("Click Me");
        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                textPanel.appendText("Hello World \n");
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

package com.kailash.tutorial.swing.ch3;
import javax.swing.*;
import java.awt.*;

/**
 * Created by kailash on 3/30/20.
 */
public class MainFrame extends JFrame {

    private JTextArea textArea;
    private JButton btn;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        btn = new JButton("Click Me");

        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

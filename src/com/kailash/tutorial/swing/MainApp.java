package com.kailash.tutorial.swing;

import com.kailash.tutorial.swing.ch2.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kailash on 3/30/20.
 */
public class MainApp extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp a = new MainApp();
        });
    }

    public MainApp() {
        setTitle("Tutorial Application");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        add(p, BorderLayout.CENTER);

        initPanel(p);
    }

    private void initPanel(JPanel panel) {
        Dimension dim = getPreferredSize();
        dim.width = 50;

        panel.setPreferredSize(dim);
        panel.setBackground(Color.BLUE);

        JButton ch1Button = new JButton("Invoke Chapter 2 Application");
        panel.add(ch1Button);
        ch1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.kailash.tutorial.swing.ch2.App a = new App();
                String[] args = new String[0];
                a.main(args);
            }
        });
    }

}

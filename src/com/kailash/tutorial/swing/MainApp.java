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
        //panel.setBackground(Color.BLUE);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;

        /// first row ///
        gc.weightx = 0.1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_START;

        JButton ch2Button = new JButton("Invoke Chapter 2 Application");
        panel.add(ch2Button, gc);

        ch2Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch2.App a = new com.kailash.tutorial.swing.ch2.App();
            String[] args = new String[0];
            a.main(args);
        });

        ++gc.gridy;

        JButton ch3Button = new JButton("Invoke Chapter 3 Application");
        panel.add(ch3Button, gc);
        ch3Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch3.App a = new com.kailash.tutorial.swing.ch3.App();
            String[] args = new String[0];
            a.main(args);
        });

        ++gc.gridy;

        JButton ch4Button = new JButton("Invoke Chapter 4 Application");
        panel.add(ch4Button, gc);
        ch4Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch4.App a = new com.kailash.tutorial.swing.ch4.App();
            String[] args = new String[0];
            a.main(args);
        });

        ++gc.gridy;

        JButton ch5Button = new JButton("Invoke Chapter 5 Application");
        panel.add(ch5Button, gc);
        ch5Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch5.App a = new com.kailash.tutorial.swing.ch5.App();
            String[] args = new String[0];
            a.main(args);
        });

        ++gc.gridy;

        JButton ch6Button = new JButton("Invoke Chapter 6 Application");
        panel.add(ch6Button, gc);
        ch6Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch6.App a = new com.kailash.tutorial.swing.ch6.App();
            String[] args = new String[0];
            a.main(args);
        });
    }

}

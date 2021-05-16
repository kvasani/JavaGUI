package com.kailash.tutorial.swing;

import com.kailash.tutorial.swing.ch37.gui.App;

import javax.swing.*;
import java.awt.*;


/**
 * Created by kailash on 3/30/20.
 */
public class MainApp extends JFrame {
    public MainApp() {
        setTitle("Tutorial Application");
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());

        JPanel p = new JPanel();
        add(p, BorderLayout.CENTER);
        initPanel(p);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp a = new MainApp();
        });
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
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;

        JButton ch2Button = new JButton("Invoke Chapter 2 Application");
        panel.add(ch2Button, gc);

        ch2Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch2.App a;
            a = new com.kailash.tutorial.swing.ch2.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch2.App.main(args);
        });

        ++gc.gridy;

        JButton ch3Button = new JButton("Invoke Chapter 3 Application");
        panel.add(ch3Button, gc);
        ch3Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch3.App a = new com.kailash.tutorial.swing.ch3.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch3.App.main(args);
        });

        ++gc.gridy;

        JButton ch4Button = new JButton("Invoke Chapter 4 Application");
        panel.add(ch4Button, gc);
        ch4Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch4.App a = new com.kailash.tutorial.swing.ch4.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch4.App.main(args);
        });

        ++gc.gridy;

        JButton ch5Button = new JButton("Invoke Chapter 5 Application");
        panel.add(ch5Button, gc);
        ch5Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch5.App a = new com.kailash.tutorial.swing.ch5.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch5.App.main(args);
        });

        ++gc.gridy;

        JButton ch6Button = new JButton("Invoke Chapter 6 Application");
        panel.add(ch6Button, gc);
        ch6Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch6.App a = new com.kailash.tutorial.swing.ch6.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch6.App.main(args);
        });

        ++gc.gridy;

        JButton ch7Button = new JButton("Invoke Chapter 7 Application");
        panel.add(ch7Button, gc);
        ch7Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch7.App a = new com.kailash.tutorial.swing.ch7.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch7.App.main(args);
        });

        ++gc.gridy;

        JButton ch8Button = new JButton("Invoke Chapter 8 Application");
        panel.add(ch8Button, gc);
        ch8Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch8.App a = new com.kailash.tutorial.swing.ch8.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch8.App.main(args);
        });

        ++gc.gridy;

        JButton ch9Button = new JButton("Invoke Chapter 9 Application");
        panel.add(ch9Button, gc);
        ch9Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch9.App a = new com.kailash.tutorial.swing.ch9.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch9.App.main(args);
        });

        // start adding next set of buttons to next column
        ++gc.gridx;
        gc.gridy = 0;


        JButton ch10Button = new JButton("Invoke Chapter 10 Application");
        panel.add(ch10Button, gc);
        ch10Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch10.App a = new com.kailash.tutorial.swing.ch10.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch10.App.main(args);
        });

        ++gc.gridy;

        JButton ch13Button = new JButton("Invoke Chapter 13 Application");
        panel.add(ch13Button, gc);
        ch13Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch13.App a = new com.kailash.tutorial.swing.ch13.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch13.App.main(args);
        });

        ++gc.gridy;

        JButton ch14Button = new JButton("Invoke Chapter 14 Application");
        panel.add(ch14Button, gc);
        ch14Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch14.App a = new com.kailash.tutorial.swing.ch14.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch14.App.main(args);
        });

        ++gc.gridy;

        JButton ch16Button = new JButton("Invoke Chapter 16 Application");
        panel.add(ch16Button, gc);
        ch16Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch16.App a = new com.kailash.tutorial.swing.ch16.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch16.App.main(args);
        });

        ++gc.gridy;

        JButton ch17Button = new JButton("Invoke Chapter 17 Application");
        panel.add(ch17Button, gc);
        ch17Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch17.App a = new com.kailash.tutorial.swing.ch17.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch17.App.main(args);
        });

        ++gc.gridy;

        JButton ch18Button = new JButton("Invoke Chapter 18 Application");
        panel.add(ch18Button, gc);
        ch18Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch18.App a = new com.kailash.tutorial.swing.ch18.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch18.App.main(args);
        });

        ++gc.gridy;

        JButton ch19Button = new JButton("Invoke Chapter 19 Application");
        panel.add(ch19Button, gc);
        ch19Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch19.App a = new com.kailash.tutorial.swing.ch19.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch19.App.main(args);
        });

        ++gc.gridy;

        JButton ch22Button = new JButton("Invoke Chapter 22 Application");
        panel.add(ch22Button, gc);
        ch22Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch22.App a = new com.kailash.tutorial.swing.ch22.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch22.App.main(args);
        });

        // start adding next set of buttons to next column
        ++gc.gridx;
        gc.gridy = 0;

        JButton ch23Button = new JButton("Invoke Chapter 23 Application");
        panel.add(ch23Button, gc);
        ch23Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch23.App a = new com.kailash.tutorial.swing.ch23.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch23.App.main(args);
        });

        ++gc.gridy;

        JButton ch25Button = new JButton("Invoke Chapter 25 Application");
        panel.add(ch25Button, gc);
        ch25Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch25.gui.App a = new com.kailash.tutorial.swing.ch25.gui.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch25.gui.App.main(args);
        });

        ++gc.gridy;

        JButton ch27Button = new JButton("Invoke Chapter 27 Application");
        panel.add(ch27Button, gc);
        ch27Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch27.gui.App a = new com.kailash.tutorial.swing.ch27.gui.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch27.gui.App.main(args);
        });

        ++gc.gridy;

        JButton ch28Button = new JButton("Invoke Chapter 28 Application");
        panel.add(ch28Button, gc);
        ch28Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch28.gui.App a = new com.kailash.tutorial.swing.ch28.gui.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch28.gui.App.main(args);
        });

        ++gc.gridy;

        JButton ch30Button = new JButton("Invoke Chapter 30 Application");
        panel.add(ch30Button, gc);
        ch30Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch30.gui.App a = new com.kailash.tutorial.swing.ch30.gui.App();
            String[] args = new String[0];
            com.kailash.tutorial.swing.ch30.gui.App.main(args);
        });

        ++gc.gridy;

        JButton ch37Button = new JButton("Invoke Chapter 37 Application");
        panel.add(ch37Button, gc);
        ch37Button.addActionListener(e -> {
            com.kailash.tutorial.swing.ch37.gui.App a = new com.kailash.tutorial.swing.ch37.gui.App();
            String[] args = new String[0];
            App.main(args);
        });
    }

}

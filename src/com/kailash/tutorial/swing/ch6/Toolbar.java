package com.kailash.tutorial.swing.ch6;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kailash on 3/30/20.
 */
public class Toolbar extends JPanel {

    private JButton helloButton;
    private JButton goodByeButton;

    public Toolbar() {
        helloButton = new JButton("Hello");
        goodByeButton = new JButton("Goodbye");


        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);
    }
}

package com.kailash.tutorial.swing.ch8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kailash on 3/30/20.
 */
public class Toolbar extends JPanel implements ActionListener {

    private JButton helloButton;
    private JButton goodByeButton;

    private StringListener textListener;

    public Toolbar() {
        helloButton = new JButton("Hello");
        goodByeButton = new JButton("Goodbye");


        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);
    }

    public void setStringListener(StringListener listener) {

        this.textListener=listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == helloButton){
            if(textListener != null) {
                textListener.textEmitted("Hello");
            }
        } else if (clicked == goodByeButton) {
            if(textListener != null){
                textListener.textEmitted("Goodbye");
            }
        }
    }
}

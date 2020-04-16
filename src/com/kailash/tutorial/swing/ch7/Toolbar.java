package com.kailash.tutorial.swing.ch7;

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

    private TextPanel textPanel;

    public Toolbar() {
        helloButton = new JButton("Hello");
        goodByeButton = new JButton("Goodbye");


        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodByeButton);
    }

    public void setTextPanel(TextPanel textPanel) {

        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == helloButton){
            textPanel.appendText("Hello\n");
        } else if (clicked == goodByeButton) {
            textPanel.appendText("GoodBye\n");
        }
    }
}

package com.kailash.tutorial.swing.ch7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kailash on 3/30/20.
 */
public class TextPanel extends JPanel {

    private JTextArea textArea;

    public TextPanel() {
        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void appendText(String s) {
        textArea.append(s);
    }
}

package com.kailash.tutorial.swing.ch14;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kailash on 3/30/20.
 */
public class MainFrame extends JFrame {

    private final TextPanel textPanel;
    private final Toolbar toolbar;

    private final FormPanel formPanel;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCategory = e.getAgeCategory();

                textPanel.appendText(name + ":" + occupation + ":" + ageCategory);
                textPanel.appendText("\n");
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

package com.kailash.tutorial.swing.ch10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by kailash on 3/30/20.
 */
public class FormPanel extends JPanel {

    private JLabel nameLable, occupationLabel;
    private JTextField nameField, occupationField;
    private JButton okBtn;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;

        setPreferredSize(dim);

        nameLable = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");

        nameField = new JTextField(10);
        occupationField = new JTextField(10);

        okBtn = new JButton("OK");

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;

        /// first row ///
        gc.weightx = 1;
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLable, gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add (nameField, gc);

        /// second row ///
        gc.gridx=0;
        gc.gridy=1;
        gc.weightx = 1;
        gc.weighty=0.1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        /// third row ///
        gc.gridx=1;
        gc.gridy=2;
        gc.weightx = 1;
        gc.weighty=2.0;
        add(okBtn, gc);

    }
}

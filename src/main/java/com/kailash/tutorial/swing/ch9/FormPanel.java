package com.kailash.tutorial.swing.ch9;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by kailash on 3/30/20.
 */
public class FormPanel extends JPanel {

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;

        setPreferredSize(dim);

        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }
}

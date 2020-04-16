package com.kailash.tutorial.swing.ch16;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kailash on 3/30/20.
 */
public class FormPanel extends JPanel {

    private JLabel nameLable, occupationLabel, ageCategoryLabel, empLabel;
    private JTextField nameField, occupationField;
    private JButton okBtn;
    private JList ageList;
    private JComboBox empCombo;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 300;

        setPreferredSize(dim);

        nameLable = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        ageCategoryLabel = new JLabel("Age Category:");
        empLabel = new JLabel("Employment Type:");


        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();

        // setup list box
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1,"18 to 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));

        ageList.setModel(ageModel);

        // setup combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);

        ageList.setPreferredSize(new Dimension(100, 65));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        empCombo.setSelectedIndex(0);
        empCombo.setEditable(true);

        okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name  = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCat = (String) empCombo.getSelectedItem();

                // raise event with container
                FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCat);

                if(listener != null) {
                    listener.formEventOccured(ev);
                }
            }
        });

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    public void layoutComponents() {
        Insets zeroInset = new Insets(0,0,0,0);

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
        gc.insets = zeroInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add (nameField, gc);

        /// next row ///
        gc.gridy++;

        gc.gridx=0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridx=1;
        gc.insets = zeroInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        /// next row ///
        gc.gridy++;

        gc.gridx=0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(ageCategoryLabel, gc);

        gc.gridx=1;
        gc.weighty=0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(ageList,gc);


        /// next row ///
        gc.gridy++;

        gc.gridx=0;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(empLabel, gc);

        gc.gridx=1;
        gc.weightx = 1;
        gc.weighty=0.2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(empCombo, gc);

        /// next row ///
        gc.gridx=1;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = zeroInset;
        add(okBtn, gc);

    }

    private FormListener listener;
    public void setFormListener(FormListener listener) {
        this.listener = listener;
    }
}

class AgeCategory {
    private int id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String text;

    public AgeCategory (int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
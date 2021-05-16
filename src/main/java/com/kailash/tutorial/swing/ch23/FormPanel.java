package com.kailash.tutorial.swing.ch23;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by kailash on 3/30/20.
 */
public class FormPanel extends JPanel {

    private final JLabel nameLabel;
    private final JLabel occupationLabel;
    private final JLabel ageCategoryLabel;
    private final JLabel empLabel;
    private final JLabel citizenLabel;
    private final JLabel taxLabel;
    private final JLabel genderLabel;
    private final JTextField nameField;
    private final JTextField occupationField;
    private final JButton okBtn;
    private final JList ageList;
    private final JComboBox empCombo;
    private final JCheckBox citizenCheck;
    private final JTextField taxField;

    private final JRadioButton maleRadio;
    private final JRadioButton femaleRadio;
    private final ButtonGroup genderGroup;
    private FormListener listener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 300;

        setPreferredSize(dim);

        nameLabel = new JLabel("Name:");
        occupationLabel = new JLabel("Occupation:");
        ageCategoryLabel = new JLabel("Age Category:");
        empLabel = new JLabel("Employment Type:");
        citizenLabel = new JLabel("US Citizen:");
        taxLabel = new JLabel("Tax ID:");
        genderLabel = new JLabel("Gender:");

        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();
        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);

        maleRadio = new JRadioButton("male");
        maleRadio.setActionCommand("male");
        femaleRadio = new JRadioButton("female");
        femaleRadio.setActionCommand("female");
        femaleRadio.setSelected(true);

        genderGroup = new ButtonGroup();

        okBtn = new JButton("OK");

        // setup mnemonic on button
        okBtn.setMnemonic(KeyEvent.VK_O);
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);

        occupationLabel.setDisplayedMnemonic(KeyEvent.VK_U);
        occupationLabel.setLabelFor(occupationField);

        ageCategoryLabel.setDisplayedMnemonic(KeyEvent.VK_A);
        ageCategoryLabel.setLabelFor(occupationField);

        empLabel.setDisplayedMnemonic(KeyEvent.VK_E);
        empLabel.setLabelFor(empCombo);

        citizenLabel.setDisplayedMnemonic(KeyEvent.VK_I);
        citizenLabel.setLabelFor(citizenCheck);

        taxLabel.setDisplayedMnemonic(KeyEvent.VK_T);
        taxLabel.setLabelFor(taxField);

        genderLabel.setDisplayedMnemonic(KeyEvent.VK_G);
        genderLabel.setLabelFor(maleRadio);

        // setup gender radio
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        taxLabel.setEnabled(false);
        taxField.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = citizenCheck.isSelected();
                taxLabel.setEnabled(isTicked);
                taxField.setEnabled(isTicked);
            }
        });

        // setup list box
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
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


        okBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                String empCat = (String) empCombo.getSelectedItem();
                boolean usCitizen = citizenCheck.isSelected();
                String taxId = taxField.getText();

                String gender = genderGroup.getSelection().getActionCommand();

                // raise event with container
                FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCat, usCitizen, taxId, gender);

                if (listener != null) {
                    listener.formEventOccurred(ev);
                }
            }
        });

        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    public void layoutComponents() {
        Insets zeroInset = new Insets(0, 0, 0, 0);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;

        /// first row ///
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.insets = zeroInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        /// next row ///
        gc.gridy++;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.insets = zeroInset;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        /// next row ///
        gc.gridy++;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(ageCategoryLabel, gc);

        gc.gridx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(ageList, gc);


        /// next row ///
        gc.gridy++;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(empLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(empCombo, gc);

        /// next row ///
        gc.gridy++;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(citizenLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(citizenCheck, gc);

        /// next row ///
        gc.gridy++;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(taxLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(taxField, gc);

/// next row ///
        gc.gridy++;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(genderLabel, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.01;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(maleRadio, gc);

        /// next row ///
        gc.gridy++;
        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 0.01;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = zeroInset;
        add(femaleRadio, gc);

        /// next row ///
        gc.gridx = 1;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = zeroInset;
        add(okBtn, gc);

    }

    public void setFormListener(FormListener listener) {
        this.listener = listener;
    }
}

class AgeCategory {
    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

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

    public String toString() {
        return this.text;
    }
}
package com.kailash.tutorial.swing.ch22;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by kailash on 3/30/20.
 */
public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();

        setJMenuBar(createMenuBar());

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCategory = e.getAgeCategory();
                String empCat = e.getEmploymentCategory();
                boolean usCitizen = e.isUsCitizen();
                String taxId = e.getTaxID();
                String gender = e.getGender();

                textPanel.appendText(name + ":" + occupation + ":" + ageCategory + ":" + empCat + ":" + usCitizen + "~" + taxId + "~" + gender);
                textPanel.appendText("\n");
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        this.setSize(500, 500);
        this.setMinimumSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // create top menu items
        JMenu fileMenu = new JMenu("File");


        // file menu
        JMenuItem exportData = new JMenuItem("Export Data...");
        JMenuItem importData = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        //window menu
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");

//        JMenuItem showFormItem = new JMenuItem("Person Form");
        final JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        // add some action listeners
        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuitem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(menuitem.isSelected());
            }
        });

        // add mnemonic to menu items
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        importData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                java.awt.FileDialog fd = new java.awt.FileDialog(MainFrame.this);
                fd.setMode(FileDialog.LOAD);
                fd.setVisible(true);
                System.out.println("directory="+fd.getDirectory());
                System.out.println("file="+fd.getFile());

                int retVal = fileChooser.showOpenDialog(MainFrame.this);
                System.out.println("retVal="+retVal);
                System.out.println("file="+fileChooser.getSelectedFile());

                if (retVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        // temp exit action - to be revised
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                String txt = (String) JOptionPane.showInputDialog(MainFrame.this,
//                        "Enter your user name",
//                        "Enter User Name",
//                        JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);
//                System.out.println(txt);

                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Really Quit ??", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        return menuBar;
    }
}

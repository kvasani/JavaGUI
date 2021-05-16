package com.kailash.tutorial.swing.ch27.gui;

import com.kailash.tutorial.swing.ch27.model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {

    private final JTable table;
    private final PersonTableModel tableModel;

    public TablePanel() {
        tableModel = new PersonTableModel();

        table = new JTable();
        table.setModel(tableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}

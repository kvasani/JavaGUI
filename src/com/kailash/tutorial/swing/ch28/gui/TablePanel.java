package com.kailash.tutorial.swing.ch28.gui;

import com.kailash.tutorial.swing.ch28.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TablePanel  extends JPanel {

    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popup;

    PersonTableListener personTableListener;

    public TablePanel () {
        tableModel = new PersonTableModel();

        table = new JTable();
        table.setModel(tableModel);

        popup = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete row");
        popup.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row,row);

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table,e.getX(), e.getY());
                }
            }
        });

        removeItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if(personTableListener != null) {
                    personTableListener.rowDeleted(row);
                    tableModel.fireTableRowsDeleted(row,row);
                }
            }
        });
        setLayout(new BorderLayout());
        add (new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
    public void setPersonTableListener(PersonTableListener personTableListener) {
        this.personTableListener = personTableListener;
    }
}

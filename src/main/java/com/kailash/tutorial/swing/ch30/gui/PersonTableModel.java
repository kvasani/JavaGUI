package com.kailash.tutorial.swing.ch30.gui;

import com.kailash.tutorial.swing.ch30.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> db;

    private final String[] colNames = new String[]{
            "ID", "Name", "Occupation", "Age Category", "Employment Category",
            "US Citizen", "Tax ID"
    };

    public PersonTableModel() {

    }

    public void setData(List<Person> db) {
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = db.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCategory();
            case 4:
                return person.getEmpCat();
            case 5:
                return person.isUsCitizen();
            case 6:
                return person.getTaxID();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
}

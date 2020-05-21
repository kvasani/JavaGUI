package com.kailash.tutorial.swing.ch28.controller;

import com.kailash.tutorial.swing.ch28.gui.FormEvent;
import com.kailash.tutorial.swing.ch28.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    Database db = new Database();
    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCat = e.getAgeCategory();
        String empCat = e.getEmploymentCategory();
        boolean usCitizen = e.isUsCitizen();
        String taxId = e.getTaxID();
        String gender = e.getGender();

        AgeCategory ageCategory;
        switch (ageCat) {
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
            default:
                ageCategory = AgeCategory.child;
                System.err.println("default age category="+ageCat);
        }

        EmploymentCategory employmentCategory;
        switch(empCat) {
            case "employed":
                employmentCategory = EmploymentCategory.employed;
                break;
            case "self-employed":
                employmentCategory = EmploymentCategory.selfEmployed;
                break;
            case "unemployed":
                employmentCategory = EmploymentCategory.unemployed;
                break;
            case "other":
            default:
                employmentCategory = EmploymentCategory.other;
                System.err.println("default employment category="+empCat);
        }

        Gender genderCat;
        switch (gender) {
            case "male":
                genderCat = Gender.male;
                break;
            default:
                genderCat = Gender.female;
        }
        Person person = new Person( name, occupation, ageCategory, employmentCategory, taxId, usCitizen, genderCat);

        db.addPerson(person);
    }

    public void saveToFile (File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile (File file) throws IOException {
        db.loadFromFile(file);
    }

    public void removePerson(int index) {
        db.removePerson(index);
    }
}

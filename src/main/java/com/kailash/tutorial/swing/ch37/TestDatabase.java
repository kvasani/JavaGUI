package com.kailash.tutorial.swing.ch37;

import com.kailash.tutorial.swing.ch37.model.*;

public class TestDatabase {
    public static void main(String[] args) {
        System.out.println("Running database test");

        Database db = new Database();
        try {
            db.connect();
            Person p = new Person("Joe", "builder", AgeCategory.adult, EmploymentCategory.employed, "123456789", true, Gender.male);
            db.addPerson(p);
            p = new Person("Sue", "artist", AgeCategory.adult, EmploymentCategory.selfEmployed, null, false, Gender.female);
            db.addPerson(p);

            db.save();
            db.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

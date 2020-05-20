package com.kailash.tutorial.swing.ch27.model;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private ArrayList<Person> people;

    public Database(){
        people = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}

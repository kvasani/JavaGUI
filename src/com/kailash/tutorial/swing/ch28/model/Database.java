package com.kailash.tutorial.swing.ch28.model;

import java.io.*;
import java.util.*;

public class Database {

    private List<Person> people;

    public Database(){
        people = new LinkedList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream((fos));

        Person[] persons = people.toArray(new Person[people.size()]);

        os.writeObject(persons);
        os.close();
        os = null;
        fos = null;
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Person[] persons = (Person[]) ois.readObject();
            people.clear();
            people.addAll(Arrays.asList(persons));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }

    public void removePerson(int index) {
        people.remove(index);
    }
}

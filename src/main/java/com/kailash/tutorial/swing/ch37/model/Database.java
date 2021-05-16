package com.kailash.tutorial.swing.ch37.model;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private final List<Person> people;
    private Connection con = null;

    public Database() {
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

    public void connect() throws Exception {
        String dbURL = "jdbc:mysql://localhost:3306/test";

        if (this.con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.con = DriverManager.getConnection(dbURL, "root", "");
                System.out.println("connected");
            } catch (ClassNotFoundException e) {
                throw new Exception("Driver not found");
            }
        }
    }

    public void disconnect() {
        if (this.con != null) {
            try {
                this.con.close();
                System.out.println("disconnected");
                this.con = null;
            } catch (SQLException e) {
                System.out.println("Can't close connection");
            }
        }
    }

    public void save() throws SQLException {
        String checkSQL = "select count(*) as count from people where id=?";
        String insertSql = "insert into people (id, name, age, employment_status, tax_id, us_citizen, gender, occupation) values" +
                "( ?,?,?,?,?,?,?,?)";

        PreparedStatement checkStmt = null;
        PreparedStatement insertStmt = null;
        try {
            checkStmt = con.prepareStatement(checkSQL);
            for (Person p : people) {
                int id = p.getId();

                String name = p.getName();
                AgeCategory ageCategory = p.getAgeCategory();
                EmploymentCategory employmentCategory = p.getEmpCat();
                String taxID = p.getTaxID();
                boolean usCitizen = p.isUsCitizen();
                Gender gender = p.getGender();
                String occupation = p.getOccupation();

                // checking whether person account is already existing or not
                checkStmt.setInt(1, id);

                ResultSet checkResult = checkStmt.executeQuery();
                checkResult.next();
                int count = checkResult.getInt(1);
                System.out.println("count for person with ID:" + id + " is " + count);
                if (count == 0) {
                    System.out.println("inserting person with ID:" + id);
                    insertStmt = con.prepareStatement(insertSql);
                    //insert into people (id, name, age, employment_status, tax_id, us_citizen, gender, occupation)
                    int col = 1;
                    insertStmt.setInt(col++, id);
                    insertStmt.setString(col++, name);
                    insertStmt.setString(col++, ageCategory.name());
                    insertStmt.setString(col++, employmentCategory.name());
                    insertStmt.setString(col++, taxID);
                    insertStmt.setBoolean(col++, usCitizen);
                    insertStmt.setString(col++, gender.name());
                    insertStmt.setString(col++, occupation);

                    insertStmt.executeUpdate();
                } else {
                    System.out.println("updating person with ID:" + id);
                }
            }
        } finally {
            if (checkStmt != null)
                checkStmt.close();
        }
    }
}

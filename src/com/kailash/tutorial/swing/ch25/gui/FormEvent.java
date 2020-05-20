package com.kailash.tutorial.swing.ch25.gui;

import java.util.EventObject;

/**
 * Created by kailash on 3/30/20.
 */
public class FormEvent extends EventObject {
    private int ageCategory;
    private String name;
    private String occupation;
    private String empCat;
    private String taxID;
    private boolean usCitizen;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,
                     String name,
                     String occupation,
                     int ageCategory,
                     String empCat,
                     boolean usCitizen,
                     String taxID,
                     String gender) {
        super (source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCat = empCat;
        this.usCitizen = usCitizen;
        this.taxID = taxID;
        this.gender = gender;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getOccupation() {
        return occupation;
    }


    public String getName() { return name; }


    public String getEmploymentCategory() {return this.empCat;}

    public boolean isUsCitizen() { return this.usCitizen;}

    public String getTaxID() { return this.taxID; }

    public String getGender() { return this.gender; };

}

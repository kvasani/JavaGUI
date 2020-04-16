package com.kailash.tutorial.swing.ch17;

import java.awt.event.ActionListener;
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

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,
                     String name,
                     String occupation,
                     int ageCategory,
                     String empCat,
                     boolean usCitizen,
                     String taxID) {
        super (source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCat = empCat;
        this.usCitizen = usCitizen;
        this.taxID = taxID;
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

}

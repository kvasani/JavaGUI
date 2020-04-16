package com.kailash.tutorial.swing.ch16;

import java.awt.event.ActionListener;
import java.util.EventObject;

/**
 * Created by kailash on 3/30/20.
 */
public class FormEvent extends EventObject {

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    private int ageCategory;
    private String name;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String occupation;
    private String empCat;

    public String getEmploymentCategory() {return this.empCat;}
    public void setEmploymentCategory(String empCat) {this.empCat = empCat;}

    public FormEvent(Object source, String name, String occupation, int ageCategory, String empCat) {
        super (source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCat = empCat;
    }
    public FormEvent(Object source) {
        super(source);
    }
}

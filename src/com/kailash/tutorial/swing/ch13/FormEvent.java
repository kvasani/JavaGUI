package com.kailash.tutorial.swing.ch13;

import java.util.EventObject;

/**
 * Created by kailash on 3/30/20.
 */
public class FormEvent extends EventObject {

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

    public FormEvent(Object source, String name, String occupation) {
        super (source);
        this.name = name;
        this.occupation = occupation;
    }
    public FormEvent(Object source) {
        super(source);
    }
}

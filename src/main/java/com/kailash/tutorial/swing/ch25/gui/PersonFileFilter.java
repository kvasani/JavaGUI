package com.kailash.tutorial.swing.ch25.gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {

        if (file.isDirectory())
            return true;
        String name = file.getName();
        String extension = Utils.getFileExtenstion(name);
        if (extension == null)
            return false;
        return extension.equals("per");
    }

    @Override
    public String getDescription() {
        return "Person Database Files (*.per)";
    }
}

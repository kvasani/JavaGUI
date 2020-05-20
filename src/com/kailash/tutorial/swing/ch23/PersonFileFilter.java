package com.kailash.tutorial.swing.ch23;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {

        // accept directories, so that
        if (file.isDirectory())
            return true;

        String name = file.getName();
        String extension = Utils.getFileExtenstion(name);
        if(extension == null)
            return false;
        if (extension.equals("per"))
            return true;

        return false;
    }

    @Override
    public String getDescription() {
        return "Person Database Files (*.per)";
    }
}

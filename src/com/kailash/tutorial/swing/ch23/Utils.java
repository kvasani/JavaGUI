package com.kailash.tutorial.swing.ch23;

public class Utils {

    public static String getFileExtenstion(String fileName) {
        int pointIndex = fileName.lastIndexOf(".");
        if (pointIndex ==-1 ) {
            return null;
        } else if (pointIndex == fileName.length()) {
            return null;
        } else
            return (fileName.substring(pointIndex+1, fileName.length()));
    }
}

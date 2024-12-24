package org.practice.dsa.design_pattern.template_method_pattern;

public class DatabaseDataProcessor extends CSVDataProcessor {
    @Override
    void readData() {
        System.out.println("Reading data from Database...");
    }

    @Override
    void saveData() {
        System.out.println("Saving Data to Database...");
    }
}

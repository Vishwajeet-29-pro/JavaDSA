package com.practice.dsa.design_pattern.template_method_pattern;

public class CSVDataProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("Reading the data from CSV file...");
    }

    @Override
    void saveData() {
        System.out.println("Saving data to CSV file...");
    }
}

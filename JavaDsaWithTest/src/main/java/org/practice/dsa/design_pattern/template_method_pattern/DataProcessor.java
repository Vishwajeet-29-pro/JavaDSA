package org.practice.dsa.design_pattern.template_method_pattern;

abstract class DataProcessor {
    // Template method
    public final void processData() {
        readData();
        processDataDetails();
        saveData();
    }

    abstract void readData();
    abstract void saveData();

    // Hook method
    void processDataDetails() {
        System.out.println("Processing data...");
    }
}

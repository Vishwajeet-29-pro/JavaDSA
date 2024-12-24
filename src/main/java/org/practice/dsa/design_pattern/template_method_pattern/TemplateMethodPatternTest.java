package org.practice.dsa.design_pattern.template_method_pattern;

public class TemplateMethodPatternTest {
    public static void main(String[] args) {
        DataProcessor csvDataProcessor = new CSVDataProcessor();
        csvDataProcessor.processData();

        System.out.println();

        DataProcessor databaseDataProcessor = new DatabaseDataProcessor();
        databaseDataProcessor.processData();
    }
}

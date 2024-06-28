package com.practice.dsa.exception_handling.file_handling;

public class FileProcessingTest {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        try {
            String inputFilePath = "C:\\Users\\SMART\\IdeaProjects\\JavaDSA\\src\\com\\practice\\dsa\\exception_handling\\file_handling\\input.txt";
            String data = fileProcessor.readFile(inputFilePath);
            System.out.println("File read Successfully.");

            String processData = fileProcessor.processData(data);
            System.out.println("Data processed Successfully.");

            String outputPath = "C:\\Users\\SMART\\IdeaProjects\\JavaDSA\\src\\com\\practice\\dsa\\exception_handling\\file_handling\\output.txt";
            fileProcessor.writeFile(outputPath,processData);
            System.out.println("Data Written to File Successfully.");
        } catch (FileProcessingException e){
            System.out.println("Exception occurred: "+e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("File processing completed.");
        }
    }
}

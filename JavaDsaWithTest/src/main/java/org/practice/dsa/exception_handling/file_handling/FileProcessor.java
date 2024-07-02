package org.practice.dsa.exception_handling.file_handling;

import java.io.*;
import java.util.Scanner;

public class FileProcessor {
    public String readFile(String filePath) throws FileProcessingException {
        StringBuilder content = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new FileProcessingException("File Not found: "+filePath, e);
        }
        return content.toString();
    }

    public String processData(String data) throws FileProcessingException {
        try {
            if (data.isEmpty()) {
                throw new IllegalArgumentException("Data cannot be empty.");
            }
            return data.toUpperCase();
        } catch (IllegalArgumentException e){
            throw new FileProcessingException("Error in processing file.", e);
        }
    }

    public void writeFile(String filePath, String data) throws FileProcessingException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new FileProcessingException("Error in File write.",e);
        }
    }
}

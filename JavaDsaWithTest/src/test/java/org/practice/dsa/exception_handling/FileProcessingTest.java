package org.practice.dsa.exception_handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.practice.dsa.exception_handling.file_handling.FileProcessingException;
import org.practice.dsa.exception_handling.file_handling.FileProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessingTest {

    @TempDir
    Path tempDir;

    @Test
    public void testReadFile_NotFound_ThrowException() {
        FileProcessor fileProcessor = new FileProcessor();
        String nonExistingFilePath = "input.txt";

        FileProcessingException thrown = assertThrows(FileProcessingException.class, () -> {
            fileProcessor.readFile(nonExistingFilePath);
        });

        assertTrue(thrown.getMessage().contains("File Not found: "+nonExistingFilePath));
    }

    @Test
    public void testReadFile_SuccessfulRead() throws IOException, FileProcessingException {
        FileProcessor fileProcessor = new FileProcessor();
        Path tempFile = tempDir.resolve("testFile.txt");

        try(FileWriter fileWriter = new FileWriter(tempFile.toFile())) {
            fileWriter.write("Hello, world\n");
            fileWriter.write("This is test file.\n");
        }
        String content = fileProcessor.readFile(tempFile.toString());
        assertEquals("Hello, world/nThis is test file./n", content);
    }

    @Test
    public void testProcessFile_FileEmpty_ThrowIllegalArgument() throws FileProcessingException, IOException {
        FileProcessor fileProcessor = new FileProcessor();
        Path tempFile = tempDir.resolve("emptyFile.txt");

        try(FileWriter writer = new FileWriter(tempFile.toFile())){
            // Write nothing to file keeping it empty
        }
        String content = fileProcessor.readFile(tempFile.toString());

        FileProcessingException thrown = assertThrows(FileProcessingException.class,() ->{
            fileProcessor.processData(content);
        });
        assertTrue(thrown.getMessage().contains("Error in processing file."));
        assertInstanceOf(IllegalArgumentException.class, thrown.getCause());
        assertTrue(thrown.getCause().getMessage().contains("Data cannot be empty."));
    }

    @Test
    public void testProcessFile_Successful() throws IOException, FileProcessingException {
        FileProcessor fileProcessor = new FileProcessor();
        Path tempFile = tempDir.resolve("testFile.txt");

        try(FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("this is test file");
        }
        String content = fileProcessor.readFile(tempFile.toString());

        assertEquals("THIS IS TEST FILE/N",fileProcessor.processData(content));
    }

    @Test
    public void testWriteFile_ErrorInWriting() throws IOException, FileProcessingException {
        FileProcessor fileProcessor = new FileProcessor();
        Path tempFile = tempDir.resolve("outputFile.txt");
        String data = "some data to write in file";
        try {
            Files.writeString(tempFile, data);
            tempFile.toFile().setReadOnly();

            FileProcessingException thrown = assertThrows(FileProcessingException.class, () -> {
                fileProcessor.writeFile(tempFile.toString(),data);
            });

            assertEquals("Error in File write.",thrown.getMessage());
        } finally {
            tempFile.toFile().setWritable(true);
        }
    }

    // This test failing due to new line in file.
    @Test
    public void testWriteFile_Success() throws FileProcessingException {
        FileProcessor fileProcessor = new FileProcessor();
        Path tempFile = tempDir.resolve("outputFile.txt");
        String data = "some data to write in file.\n";

        fileProcessor.writeFile(tempFile.toString(),data);

        String fileData = fileProcessor.readFile(tempFile.toString());
        assertEquals("some data to write in file.\n", fileData);
    }
}

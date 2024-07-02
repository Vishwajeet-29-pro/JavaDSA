package org.practice.dsa.exception_handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.practice.dsa.exception_handling.file_handling.FileProcessingException;
import org.practice.dsa.exception_handling.file_handling.FileProcessor;

import java.io.FileWriter;
import java.io.IOException;
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
}

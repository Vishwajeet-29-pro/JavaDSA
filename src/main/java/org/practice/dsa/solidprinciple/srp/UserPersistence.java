package org.practice.dsa.solidprinciple.srp;

import java.io.FileWriter;
import java.io.IOException;

public class UserPersistence {
    public void saveToFile(UserData userData, String fileName) throws IOException {
        try(FileWriter writer = new FileWriter(fileName)) {
            writer.write("Name: "+userData.getName() +" Age: "+userData.getAge());
        }
    }
}

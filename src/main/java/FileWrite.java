package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWrite {
    String filepath;

    public FileWrite(String filePath) {
        this.filepath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filepath = filePath;
    }

    public void createFile(List<Person> names) throws IOException {
        FileWriter writer = new FileWriter(filepath, false);
        for (Person name : names) {
            System.out.println(name);
            writer.write(name + System.lineSeparator());
        }
        System.out.println("Finished: created names-sorted.txt");
        writer.close();
    }
}

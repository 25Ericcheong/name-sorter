package main.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Used to create file based on provided file path
 */
public class FileWrite {
    String filepath;

    /**
     * Filepath is by default already provided in program but can be changed if needed
     * @param filePath location used to specific creation of file
     */
    public FileWrite(String filePath) {
        this.filepath = filePath;
    }

    /**
     * To change file path for file creation if needed
     * @param filePath that will replace old filepath specified during creation of class
     */
    public void setFilePath(String filePath) {
        this.filepath = filePath;
    }

    /**
     * Creates a file with list of names given as arguments with each name having a separate line in file
     * @param names of person acquired from the file read previously
     * @throws IOException if an error is to occur during the creation of the file
     */
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

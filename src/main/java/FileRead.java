package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Used to read a specific file with given file path
 */
public class FileRead {
    String filepath;

    /**
     * Creation of class will require a file path
     * @param filePath used to read specific file - this is relative to project root
     */
    public FileRead(String filePath) {
        this.filepath = filePath;
    }

    /**
     * Used to change file path of class if needed
     * @param filePath that will replace old filepath used previously
     */
    public void setFilePath(String filePath) {
        this.filepath = filePath;
    }

    /**
     * Acquire all names (on all separate non-empty lines) from given file path
     * @return a list of person object used to represent each name
     * @throws IOException if an error occurs while trying to read specified file
     * @throws FileNotFoundException if filepath given is not valid
     */
    public List<Person> getAllNames() throws IOException, FileNotFoundException {
        List<Person> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(this.filepath));

        String name, lastName, givenNames;
        ArrayList<String> splitName;
        while ((name = reader.readLine()) != null) {
            splitName = new ArrayList<>(Arrays.asList(name.split(", ")));
            lastName = splitName.get(0);
            givenNames = splitName.get(1);

            names.add(new Person(givenNames, lastName));
        }

        return new ArrayList<>(names);
    }
}

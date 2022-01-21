package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRead {
    String filepath;

    public FileRead(String filePath) {
        this.filepath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filepath = filePath;
    }

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

package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class used to specifically call other specialized classes and sort names in between both reading and writing
 * processes
 */
public class NameSorter {
    public static void main(String[] args) throws IOException {
        String filepath = args[0];
        String WRITE_FILE_PATH = "main/resources/names-sorted.txt";
        FileRead fileRead = new FileRead (filepath);
        FileWrite fileWrite = new FileWrite(WRITE_FILE_PATH);

        List<Person> names = new ArrayList<>();

        try {
            names = fileRead.getAllNames();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("File does not exist");
        }

        Collections.sort(names);

        try {
            fileWrite.createFile(names);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error occurred while creating file");
        }
    }
}

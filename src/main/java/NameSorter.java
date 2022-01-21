package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameSorter {
    public static void main(String[] args) throws IOException {
        String filepath = args[0];
        List<Person> names = new ArrayList<>();

        try {
            names = readFile(filepath);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("File does not exist");
        }
        Collections.sort(names);

        try {
            writeFile(names);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error occurred while writing file");
        }
    }

    private static List<Person> readFile(String filepath) throws IOException {
        List<Person> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filepath));

        String name, lastName, givenNames;
        ArrayList<String> splitName;
        while ((name = reader.readLine()) != null) {
            splitName = new ArrayList<>(Arrays.asList(name.split(", ")));
            lastName = splitName.get(0);
            givenNames = splitName.get(1);

            names.add(new Person(givenNames, lastName));
        }

        reader.close();
        return names;
    }

    private static void writeFile(List<Person> names) throws IOException {
        FileWriter writer = new FileWriter("main/resources/names-sorted.txt", false);
        for (Person name : names) {
            System.out.println(name);
            writer.write(name + System.lineSeparator());
        }
        System.out.println("Finished: created names-sorted.txt");
        writer.close();
    }
}

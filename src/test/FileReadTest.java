package test;

import main.java.FileRead;
import main.java.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileReadTest {

    @Test(expected = FileNotFoundException.class)
    public void shouldNotReadFile() throws IOException {
        FileRead fileRead = new FileRead("fakepath.txt");
        fileRead.getAllNames();
    }

    @Test
    public void shouldReadFile() throws IOException, FileNotFoundException {
        FileRead fileRead = new FileRead("fakepath.txt");
        fileRead.setFilePath("src/test/resources/unsorted-name.txt");

        List<Person> people = fileRead.getAllNames();
        List<String> names = Arrays.asList(
                "BAKER, THEODORE",
                "SMITH, ANDREW",
                "KENT, MADISON",
                "SMITH, FREDRICK");

        for (int index = 0; index < people.size(); index++) {
            Assert.assertEquals("Order of names should not change " +
                    "when reading from unsorted name file", names.get(index), people.get(index).toString());
        }
    }
}

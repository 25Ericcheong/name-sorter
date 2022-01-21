package test;

import main.java.FileRead;
import main.java.FileWrite;
import main.java.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriteTest {
    File createdFile;

    @Test
    public void shouldCreateFile() throws IOException {
        FileRead fileRead = new FileRead("src/test/resources/unsorted-name.txt");
        List<Person> people = fileRead.getAllNames();

        FileWrite fileWrite = new FileWrite("src/test/resources/test-sorted-name.txt");
        fileWrite.setFilePath("src/test/resources/sorted-name.txt");
        fileWrite.createFile(people);

        createdFile = new File("src/test/resources/sorted-name.txt");
        Assert.assertTrue("File should be created", createdFile.exists());
    }

    @After
    public void clean(){
        if (createdFile.exists()) {
            createdFile.delete();
        }
    }
}

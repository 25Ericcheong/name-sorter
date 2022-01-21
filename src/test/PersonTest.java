package test;

import main.java.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PersonTest {
    Person person, otherPerson, samePerson, diffPerson, similarPerson;
    final String LAST_NAME = "CHOW";
    final String FIRST_NAME = "BOB";
    final String FORMATTED_NAME = "CHOW, BOB";
    final Object dummyData = "";
    final int SMALLER = -1;
    final int LARGER = 1;
    final int EQUAL = 0;

    @Before
    public void init() {
        similarPerson = new Person("BOB ", "CHOW");
        diffPerson = new Person("BOB", "BOB");
        person = new Person("BOB", "CHOW");
        otherPerson = new Person("ERIC", "DIFFERENT");
        samePerson = new Person("BOB", "CHOW");
    }

    @Test
    public void shouldGetPersonsNames() {
        Assert.assertEquals("Last name retrieved is not correct", LAST_NAME, person.getLastName());
        Assert.assertEquals("First name retrieved is not correct", FIRST_NAME, person.getGivenNames());
        Assert.assertEquals("Full name is not formatted correctly", FORMATTED_NAME, person.toString());
    }

    @Test
    public void shouldEqualToPerson() {
        Assert.assertNotEquals("Person object should not be equal to any other object but " +
                        "person", person, dummyData);
        Assert.assertEquals("Person object should be equal to another person object with the" +
                        " same initial and last name", samePerson, person);
        Assert.assertNotEquals("Person object should not be equal to another person object " +
                        "with different initial and/or last name", otherPerson, person);
        Assert.assertEquals("Hash code should be the same for person with same name", samePerson.hashCode(),
                person.hashCode());
    }

    @Test
    public void testCompareTo() {
        Assert.assertEquals("Person should be smaller than other person " +
                "lexicographically", SMALLER, person.compareTo(otherPerson));
        Assert.assertEquals("Person should be equal to person with same name", EQUAL, person.compareTo(samePerson));
        Assert.assertEquals("Person should be larger than other person " +
                "lexicographically", LARGER, person.compareTo(diffPerson));
        Assert.assertEquals("Person should be equal to similar person " +
                "lexicographically", EQUAL, person.compareTo(similarPerson));
    }
}

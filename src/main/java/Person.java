package main.java;

import java.util.Objects;

/**
 * Class is used to represent a name
 */
public class Person implements Comparable<Person> {

    private final String lastName;
    private final String givenNames;

    /**
     * Constructs a 'person' with the provided name read from the file
     * @param givenNames can have multiple strings with spaces in between
     * @param lastName similar to first name with the same assumption but is prioritised when sorting
     */
    public Person(String givenNames, String lastName) {
        this.lastName = lastName;
        this.givenNames = givenNames;
    }

    /**
     * Acquires the first given names of this person
     * @return first name of person
     */
    public String getGivenNames() {
        return givenNames;
    }

    /**
     * Acquires last name of given person
     * @return last name of person
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + ", " + givenNames;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }

        Person other = (Person) o;
        return lastName.equals(other.getLastName()) &&
                givenNames.equals(other.getGivenNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(givenNames, lastName);
    }

    @Override
    public int compareTo(Person other) {

        int lastNameCompare = formatName(lastName).compareTo(formatName(other.getLastName()));
        if (lastNameCompare != 0) {
            return lastNameCompare;
        } else {
            return formatName(givenNames).compareTo(formatName(other.getGivenNames()));
        }
    }

    /**
     * Helper function used to format names - relates to writing to file later on
     * @param name of given person
     * @return formatted version of person
     */
    private String formatName(String name) {
        return name.replaceAll(" ", "");
    }
}

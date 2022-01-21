package main.java;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final String lastName;
    private final String givenNames;

    public Person(String givenNames, String lastName) {
        this.lastName = lastName;
        this.givenNames = givenNames;
    }

    public String getGivenNames() {
        return givenNames;
    }

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

    private String formatName(String name) {
        return name.replaceAll(" ", "");
    }
}

package net.demo.interview;

import java.util.Arrays;
import java.util.Comparator;

public class ExternalComparatorExample {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("John", "Doe"),
                new Person("Alice", "Smith"),
                new Person("Bob", "Johnson"),
                new Person("Alice", "Brown")
        };

        // getter methods are available in Person class
        // sort by the last name and then by the first name
        // expected output:[Alice Brown, John Doe, Bob Johnson, Alice Smith]

        // Create a custom comparator to sort by last name and then by first name
        Comparator<Person> comparator = Comparator
                .comparing(Person::getLastName)
                .thenComparing(Person::getFirstName);

        // Sort the array using the custom comparator
        Arrays.sort(persons, comparator);

        // Print the sorted array
        System.out.println(Arrays.toString(persons));

        // solution#2
        // Sort the array using a custom comparator with streams
        Person[] sortedPersons = Arrays.stream(persons)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .toArray(Person[]::new);
        System.out.println(Arrays.toString(sortedPersons));
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}


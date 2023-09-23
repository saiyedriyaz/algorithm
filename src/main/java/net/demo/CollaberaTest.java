package net.demo;

import lombok.Getter;
import lombok.ToString;
import lombok.val;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CollaberaTest {
    @ToString
    @Getter
    static class Employee {
        String firstName;
        String lastName;
        Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{new Employee("Rohit", "Sharma"),
                new Employee("Virat", "Kohli"), new Employee("Anushka", "Sharma")};

        //Comparator<Employee> c1 = (e1, e2)

        Comparator<Employee> comparator = Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName);

        val sorted = Arrays.stream(employees).sorted(comparator).collect(Collectors.toList());
        val filtered =  Arrays.stream(employees).filter(p -> p.firstName.equals("Ankur")).collect(Collectors.toSet());
        System.out.println("sorted="+sorted);
        //System.out.println("filtered="+filtered);

        //List.of(fruits).stream().findFirst()
        val s1 = new String();

    }

    class Resource {

    }
}

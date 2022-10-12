package net.demo.streams;

// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3

import java.util.Comparator;
import java.util.stream.Collectors;

class Salary {
    double baseSalary;
    double bonus;
    String currency;

    public Salary(double baseSalary, double bonus, String currency) {
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "\n\tSalary{baseSalary=" + baseSalary+", bonus=" + bonus +", currency='" + currency + '\'' +'}';
    }
}

class Employee {
    String name;
    String department;
    Salary salary;

    public Employee(String name, String department, Salary salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name;}
    public Salary getSalary() {return salary;}
    public String getDepartment() { return  department;}

    @Override
    public String toString() {
        return "\nEmployee{"+name + "-"+ department+"-"+salary +'}';
    }
}

class MyCode {
    public static void main (String[] args) {
        java.util.List<Employee> data = java.util.Arrays.asList(
                getTestData("Sachin", "IT", 300d, 150d, "INR")
                , getTestData("Jonny", "HR", 150d, 75d, "GBP")
                , getTestData("James", "IT", 250d, 100d, "GBP")
                , getTestData("James", "ADMIN", 100d, 80d, "GBP")
                , getTestData("Anil", "OPS", 200d, 0d, "INR")
                , getTestData("David", "IT", 250d, 125d, "AUD")
        );

        // SORT BY NAME AND DEPARTMENT
        data = data.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getDepartment))
                .collect(Collectors.toList());
        System.out.println(data);

        // GROUP BY DEPARTMENT

        // GROUP BY CURRENCY

        // AVERAGE SALARY IN EACH DEPARTMENT


    }

    static Employee getTestData(String name, String department, double salary, double bonus, String currency) {
        return new Employee(name, department, new Salary(salary, bonus, currency));
    }

}

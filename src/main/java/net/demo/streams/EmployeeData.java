package net.demo.streams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeData {
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
            return "Salary{baseSalary=" + baseSalary+", bonus=" + bonus +", currency='" + currency + '\'' +'}';
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

        @Override
        public String toString() {
            return "Employee{name='" + name + '\'' +", department='" + department + '\'' +", salary=" + salary +'}';
        }
    }

    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();
        List<Employee> data = Arrays.asList(
                employeeData.getTestData("Riyaz", "WBAA", 300d, 250d, "PLN")
                , employeeData.getTestData("Suvadeep", "ALGO", 150d, 75d, "EUR")
                , employeeData.getTestData("Birol", "WBAA", 200d, 100d, "EUR")
                , employeeData.getTestData("Birol", "AWBAA", 200d, 100d, "EUR")
                , employeeData.getTestData("Ramesh", "ALGO", 250d, 100d, "EUR")
                , employeeData.getTestData("Utsav", "WBAA", 250d, 100d, "EUR")
        );

        System.out.println("before sort:"+data);
        Collections.sort(data, Comparator.comparingDouble(o -> o.salary.baseSalary));
        System.out.println("after sort:"+data);
        //data.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getDepartment));
        System.out.println("later sort:"+data);
        // group by department. department -> sub of Base Salary
        //Map<String, List<Employee>> groupByDept =  data.stream().collect(Collect)

        Map<String, DoubleSummaryStatistics> dptWiseStats = data.stream().collect(Collectors.groupingBy(
                employee -> employee.department, Collectors.summarizingDouble(e -> e.salary.baseSalary)));

        Map<Boolean, List<Employee>> partitionedMap = data.stream().collect(Collectors.partitioningBy(e -> e.salary.baseSalary > 100d));

        // data.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e -> e.salary.baseSalary))); alternative below
        Optional<Employee> maxOrMinCriteria = data.stream().max(Comparator.comparingDouble(e -> e.salary.baseSalary));

        Map<String, List<Salary>> currencyWiseSalaries = data.stream().map(e -> e.salary).collect(Collectors.groupingBy(salary -> salary.currency));
        System.out.println(currencyWiseSalaries);

        Map<String, List<Employee>> currencyWiseEmployees = data.stream().collect(Collectors.groupingBy(e -> e.salary.currency));
        System.out.println(currencyWiseEmployees);

        Map<String, Map<String, List<Employee>>> currencyWiseDeptWiseMap = data.stream().collect(Collectors.groupingBy(e -> e.salary.currency, Collectors.groupingBy(e -> e.department)));
        System.out.println(currencyWiseDeptWiseMap);

        //data.stream().collect(groupingBy(Employee::hashCode));
    }

    Employee getTestData(String name, String department, double salary, double bonus, String currency) {
        return new Employee(name, department, new Salary(salary, bonus, currency));
    }
}

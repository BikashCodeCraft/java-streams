package com.bikash.question9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Run {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Manu",43, 23000),
                new Employee("Tanu",27, 25000),
                new Employee("Anu",21, 28000),
                new Employee("Minu",29, 29000),
                new Employee("Tinu",30, 21000),
                new Employee("Monu",35, 22000),
                new Employee("Sonu",41, 23000),
                new Employee("Pintu",31, 28000),
                new Employee("Sintu",33, 29000)
        );
//        grpByAgeRange(employees);
//        partitionBySal(employees, 25000);
        avgSalAfterPartition(employees, 25000);
    }


    // group employees by age range (e.g., below 30, 30-40, above 40)
    public static void grpByAgeRange(List<Employee> employees){
        Map<String, List<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getAge() < 30 ? "Below 30 " : (employee.getAge() < 40 ? "30-40" : "Above 40")));

        System.out.println(result);
    }

    // partition employees into two groups based on whether their salary is greater than a certain threshold say 30000
    public static void partitionBySal(List<Employee> employees, int salary){
        Map<Boolean, List<Employee>> result = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() < salary));
        System.out.println(result);
    }
    // For each partition or group, calculate the average salary using “Collectors.averagingDouble()
    public static void avgSalAfterPartition(List<Employee> employees, int salary){
        Map<Boolean, Double> result = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > salary, Collectors.averagingInt(Employee::getSalary)));

        System.out.println(result);

    }
}

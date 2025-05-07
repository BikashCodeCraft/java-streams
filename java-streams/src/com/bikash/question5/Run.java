package com.bikash.question5;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Run {

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department("IT", List.of(
                        new Employee("Aman", 40000),
                        new Employee("Abhishek", 65000),
                        new Employee("Manoj", 145000),
                        new Employee("Jill", 120000)
                )),
                new Department("HR", List.of(
                        new Employee("Rishabh", 25000),
                        new Employee("Jhon", 20000),
                        new Employee("Bill", 70000)
                )),
                new Department("Operation", List.of(
                        new Employee("Rahul", 85000),
                        new Employee("Rohit", 40000)
                ))
        );


//        getAllEmployees(departments);
//        getTotalSalary(departments);
//        groupBySalRange(departments);
//        getSortedEmpListBySalRange(departments);
    }

    //flatten the employee list from all departments.
    public static void getAllEmployees(List<Department> departments) {
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
    }

    // Compute the total salary of all employees
    public static void getTotalSalary(List<Department> departments) {
        Integer totalSalary = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
        System.out.println("Total Salary : "+totalSalary);

        totalSalary = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);
    }

    //Group the employees by salary range (e.g., below 50k, 50k-100k, above 100k)

    public static void groupBySalRange(List<Department> departments){
        Map<String, List<Employee>> result = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> {
                    return employee.getSalary()<50000 ? "Below 50K": (employee.getSalary()<100000 ? "50K-100K" :"Above 100k");
                }));

        System.out.println(result);

        // Grouping employees by salary range and department
        Map<String, List<String>> groupedBySalary = departments.stream()
                .flatMap(department -> department.getEmployees().stream()
                        .map(employee -> Map.entry(
                                employee.getSalary() <= 50000 ? "Below 50K" :
                                        (employee.getSalary() < 100000 ? "50K - 100K" : "Above 100K"),
                                employee + " department : " + department.getName()
                        )))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        System.out.println(groupedBySalary);
    }

//    Sort the employees within each salary range by their name in alphabetical order.
    public static void getSortedEmpListBySalRange(List<Department> departments){
        Map<String, List<Employee>> result = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee ->
                    employee.getSalary() < 50000 ? "Below 50K" : (employee.getSalary() < 100000 ? "50K-100K" : "Above 100k"),
                        Collectors.collectingAndThen(Collectors.toList(), empList -> empList.stream().sorted(Comparator.comparing(Employee::getName)).toList())
                ));
        System.out.println(result);
    }

}

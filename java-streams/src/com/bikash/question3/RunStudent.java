package com.bikash.question3;

import com.bikash.question2.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RunStudent {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Ashish", List.of(new Subject("Maths"), new Subject("English"), new Subject("Science"), new Subject("Hindi"))),
                new Student("Manohar", List.of(new Subject("Physics"))),
                new Student("Mohan", List.of(new Subject("Maths"), new Subject("English"), new Subject("Science"), new Subject("Kannada"), new Subject("SUPW"))),
                new Student("Saket", List.of(new Subject("Arts"), new Subject("Political"), new Subject("History"))),
                new Student("Sonu", List.of(new Subject("Maths"), new Subject("English"), new Subject("Science"))),
                new Student("Alok", List.of(new Subject("Maths"), new Subject("English"))));

//        getListOfUniqueSubjects(students);
        getEnrolledSubjectForEachStudent(students);
    }

    //    Use “Stream.flatMap()” to flatten the list of subjects from all students.
    public static void getListOfUniqueSubjects(List<Student> students) {
        Set<Subject> result = students.stream()
                .flatMap(student -> student.getSubjects().stream())
                .collect(Collectors.toSet()); // To get unique implement eqals and to string in subject class.
        System.out.println(result);
    }

    //Create a map of students to the number of subjects they are enrolled in.
    public static void getEnrolledSubjectForEachStudent(List<Student> students){
        Map<String, Integer> result = students.stream()
                .collect(Collectors.toMap(Student::getName, student -> student.getSubjects().size()));
        System.out.println(result);
    }

}

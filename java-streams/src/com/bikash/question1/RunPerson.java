package com.bikash.question1;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RunPerson {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Hari", 23),
                new Person("Jill", 25),
                new Person("Jack", 33),
                new Person("Manoj", 20),
                new Person("Anil", 35)
        );
        getPersonOverAge30(persons);

    }

    public static void getPersonOverAge30(List<Person> persons) {
        Set<String> result = persons.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName).map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(result);
    }
}

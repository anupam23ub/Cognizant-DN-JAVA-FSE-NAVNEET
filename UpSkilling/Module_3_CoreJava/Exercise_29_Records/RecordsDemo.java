package Cognizant_DN.UpSkilling.Module_3_CoreJava.Exercise_29_Records;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordsDemo {

    public static void main(String[] args) {

        Person person1 = new Person("Rahul", 21);
        Person person2 = new Person("Priya", 17);
        Person person3 = new Person("Amit", 25);
        Person person4 = new Person("Neha", 19);

        System.out.println("Individual Records:");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println();

        List<Person> people = Arrays.asList(
                person1,
                person2,
                person3,
                person4
        );

        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("People aged 18 or above:");

        adults.forEach(System.out::println);
    }
}
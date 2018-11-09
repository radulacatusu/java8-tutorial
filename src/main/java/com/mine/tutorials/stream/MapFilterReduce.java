package com.mine.tutorials.stream;

import com.mine.tutorials.lambda.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @stefanl
 */
public class MapFilterReduce {
    public static void main(String... args) {
        List<Person> list = Arrays.asList(new Person("A", "AA", 50), new Person("B", "BB", 15));
        Stream<Person> stream = list.stream();
        Predicate<Person> predicate = person -> person.getAge() > 20;
        Stream<Person> filterd = stream.filter(predicate);
        filterd.forEach(System.out::println);

        Stream<String> stream1 = Stream.of("One", "Two", "Three", "Four", "Five");
        Predicate<String> p1 = Predicate.isEqual("Two");
        Predicate<String> p2 = Predicate.isEqual("Three");

        List<String> list1 = new ArrayList<>();
        stream1.peek(System.out::println)
        .filter(p1.or(p2)).forEach(list1::add);

        System.out.println("Done");
        System.out.println("size = " + list1.size());

        //Stream<String> names = stream.map(person -> person.getFirstName());

    }
}

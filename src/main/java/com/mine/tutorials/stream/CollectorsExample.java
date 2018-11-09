package com.mine.tutorials.stream;

import com.mine.tutorials.lambda.Person;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @stefanl
 */
public class CollectorsExample {
    public static void main(String... args) {
        List<Person> list = new ArrayList<>();

        ClassLoader classLoader = CollectorsExample.class.getClassLoader();

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(classLoader.getResource("persons.txt").getFile())));
                Stream<String> stream = br.lines();
        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), s[1].trim(), Integer.valueOf(s[2]));
                list.add(p);
                return p;
            }).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }

        Optional<Person> minAge = list.stream().filter(person -> person.getAge() >= 20).min(Comparator.comparing(Person::getAge));
        System.out.println(minAge);

        Optional<Person> maxAge = list.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(maxAge);

        Map<Integer, TreeSet<String>> map = list.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getFirstName, Collectors.toCollection(TreeSet::new))));
        System.out.println(map);
    }
}

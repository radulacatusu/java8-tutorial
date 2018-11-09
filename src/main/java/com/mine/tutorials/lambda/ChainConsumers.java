package com.mine.tutorials.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @stefanl
 */
public class ChainConsumers {

    public static void main(String... args) {

        List<String> list = Arrays.asList("One", "Two", "Three", "four", "five");
        List<String> result = new ArrayList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;
        Consumer<String> c3 = c1.andThen(c2);


        list.forEach(c3);
        list.stream().forEach(c1);
        System.out.println("size of result = " + result.size());

        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("Two");
        list.stream().filter(p1.or(p2)).forEach(c1);

    }
}

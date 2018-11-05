package com.mine.tutorials.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @stefanl
 */
public class ComparatorLambda {

    public static void main(String... args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Comparator<String> comparator1 = (o1, o2) -> Integer.compare(o1.length(), o2.length());

        List<String> list = Arrays.asList("***", "**", "*", "****");
        Collections.sort(list, comparator);

        list.forEach(System.out::println);

        Consumer<String> c = System.out::println;
        Comparator<Integer> ci = Integer::compare;

        Predicate<String> p1 = (s) -> s.length() < 20;
        Predicate<String> p2 = (s) -> s.length() > 10;
        Predicate<String> p3 = p1.and(p2);

        Predicate<String> id = Predicate.isEqual(list);
    }
}

package com.mine.tutorials.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @stefanl
 */
public class ReductionExample {
    public static void main(String... args) {
        List<Integer> list1 = Arrays.asList();
        Optional<Integer> red = list1.stream().reduce(Integer::max);
        Optional<Integer> max = list1.stream().max(Comparator.naturalOrder());
        System.out.println("red = " + red);
    }
}

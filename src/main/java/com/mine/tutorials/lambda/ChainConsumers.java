package com.mine.tutorials.lambda;

import java.util.*;
import java.util.function.Consumer;

/**
 * @stefanl
 */
public class ChainConsumers {

    public static void main(String... args) {

        List<String> list = Arrays.asList("One", "Two", "Three", "four", "five");
        List<String> result = new ArrayList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;


        list.forEach(c1.andThen(c2));
        System.out.println("size of result = " + result.size());

    }
}

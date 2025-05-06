package com.interview.streamcoding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApproach {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 3, 100, 2, 19, 21, -123, -100, 0);

        // Approach 1: Filter and collect numbers starting with 1 (absolute value)
        List<Integer> result = numbers.stream()
                .filter(num -> String.valueOf(Math.abs(num)).startsWith("1"))
                .collect(Collectors.toList());
        System.out.println("Numbers starting with 1: " + result);

        // Approach 2: Directly print numbers starting with 1 using method reference
        numbers.stream()
                .filter(num -> String.valueOf(Math.abs(num)).startsWith("1"))
                .forEach(System.out::println);
    }
}
package com.interview.streamcoding;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates filtering numbers starting with digit '1' using Java Stream API.
 * It handles both positive and negative numbers by using absolute value.
 */
public class StreamApproachMethodCalling {

    /**
     * Filters and returns numbers starting with digit '1' (considering absolute value)
     * @param numbers List of integers to process
     * @return List of integers that start with '1' (absolute value)
     */
    public static List<Integer> findNumbersStartingWithOne(List<Integer> numbers) {
        return numbers.stream()
                // Convert to absolute value to handle negative numbers
                .filter(num -> String.valueOf(Math.abs(num)).startsWith("1"))
                // Collect results into a List
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Input list of numbers (both positive and negative)
        List<Integer> numbers = List.of(15, 3, 100, 2, 19, 21, -123, -100, 0);
        
        // Get filtered numbers starting with '1'
        List<Integer> result = findNumbersStartingWithOne(numbers);
        
        // Print the result
        System.out.println("Numbers starting with 1: " + result);
        // Output: Numbers starting with 1: [15, 100, 19, -123, -100]
    }
}
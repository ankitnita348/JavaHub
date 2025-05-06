package com.interview.streamcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LegacyApproachFindNumbersStartingWithOne {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 3, 100, 2, 19, 21, -123, -100, 0);

        // Approach 1: Legacy approach (direct implementation in main class)
        // This approach processes the list directly in the class body (not recommended)
        // Creates a list to store results
        List<Integer> findNumbers = new ArrayList<>();

        // Iterates through each number in the list
        for (Integer num : numbers) {
            // Converts number to string and checks if it starts with "1"
            if (String.valueOf(num).startsWith("1")) {
                findNumbers.add(num); // Adds to result list if condition matches
            }
        }
        System.out.println("Numbers starting with 1: " + findNumbers);

        // Approach 2: Method-based approach (recommended)
        // This approach encapsulates the logic in a separate method
        List<Integer> result = findNumbersStartingWithOne(numbers);
        System.out.println("Numbers starting with 1 (method approach): " + result);
    }

    /**
     * Helper method to find numbers starting with digit '1'
     * @param numbers List of integers to process
     * @return List of integers that start with digit '1'
     */
    private static List<Integer> findNumbersStartingWithOne(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        // Iterates through each number in the input list
        for (Integer num : numbers) {
            // Converts number to string and checks if it starts with "1"
            // Handles negative numbers by checking the second character
            if (String.valueOf(num).startsWith("1") || 
                (num < 0 && String.valueOf(num).charAt(1) == '1')) {
                result.add(num); // Adds to result list if condition matches
            }
        }

        return result;
    }
}
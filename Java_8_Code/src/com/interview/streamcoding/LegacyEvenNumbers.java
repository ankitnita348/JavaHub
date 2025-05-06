package com.interview.streamcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the legacy (pre-Java 8) approach to filtering even numbers from a list.
 * 
 * <p>This implementation shows how collection operations were typically done before
 * Java 8 introduced the Stream API. It serves as a baseline for comparing with
 * modern functional-style programming approaches.
 * 
 * <p>Key characteristics:
 * <ul>
 *   <li>Uses imperative programming style with explicit iteration</li>
 *   <li>Requires manual collection creation and population</li>
 *   <li>Modifies state (the evenNumbers list) during iteration</li>
 *   <li>More verbose but potentially more familiar to developers</li>
 * </ul>
 */
public class LegacyEvenNumbers {

    public static void main(String[] args) {
        // =====================================================================
        // STEP 1: Initialize the source data
        // =====================================================================
        /* 
         * Create a mutable list using Arrays.asList().
         * Note: The returned list is fixed-size for the backing array,
         * but we can modify elements through the list reference.
         */
        List<Integer> numbers = Arrays.asList(10, 15, 8, 49, 25, 98, 32);

        // =====================================================================
        // STEP 2: Prepare the result container
        // =====================================================================
        /*
         * Create an empty ArrayList to store our results.
         * We choose ArrayList because:
         * 1. We don't know how many elements will be even
         * 2. We need dynamic resizing as we add elements
         */
        List<Integer> evenNumbers = new ArrayList<>();

        // =====================================================================
        // STEP 3: Filtering process (imperative style)
        // =====================================================================
        /*
         * Use enhanced for-loop to iterate through all numbers.
         * This is the pre-Java 8 way of processing collections.
         * 
         * The loop consists of:
         * 1. Iteration control (implicit iterator)
         * 2. Element checking (if condition)
         * 3. Result collection (adding to evenNumbers)
         */
        for (Integer num : numbers) {
            /*
             * Check if number is even using modulo operator.
             * The modulo operation returns the remainder of division by 2.
             * Even numbers will have 0 remainder.
             */
            if (num % 2 == 0) {
                // Add the even number to our result collection
                evenNumbers.add(num);
            }
        }

        // =====================================================================
        // STEP 4: Output the results
        // =====================================================================
        /*
         * Print the filtered results to console.
         * The output will show only the even numbers from the original list.
         */
        System.out.println("Even numbers (Legacy Approach): " + evenNumbers);
    }
}
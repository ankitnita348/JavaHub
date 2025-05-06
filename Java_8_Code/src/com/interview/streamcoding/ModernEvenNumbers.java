package com.interview.streamcoding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates progressive improvements in filtering even numbers
 * using Java Stream API, showcasing best practices across different Java versions.
 * 
 * <p>Key concepts covered:
 * <ul>
 *   <li>Basic Stream operations (filter, collect)</li>
 *   <li>Method references vs lambda expressions</li>
 *   <li>Immutable collections (List.of())</li>
 *   <li>Java 16+ Stream.toList() shortcut</li>
 *   <li>Separation of concerns with helper methods</li>
 * </ul>
 */
public class ModernEvenNumbers {

    public static void main(String[] args) {
        
        // =====================================================================
        // APPROACH 1: Basic Java 8 approach
        // =====================================================================
        /* 
         * Original Java 8 way using Arrays.asList() (creates mutable list) and
         * Collectors.toList() (creates mutable ArrayList).
         * 
         * Pros: Works in all Java 8+ environments
         * Cons: Creates mutable list when often immutability is preferred
         */
        List<Integer> numbers1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        List<Integer> evenNumbers1 = numbers1.stream()
                .filter(num -> num % 2 == 0)  // Lambda for even check
                .collect(Collectors.toList()); // Terminal operation
        System.out.println("[Java 8] Even numbers (mutable list): " + evenNumbers1);
        
        // =====================================================================
        // APPROACH 2: Method reference for direct consumption
        // =====================================================================
        /*
         * When we only need to consume results (no collection needed),
         * we can use method reference for cleaner syntax.
         * 
         * System.out::println is equivalent to x -> System.out.println(x)
         */
        System.out.println("\n[Java 8] Printing directly using method reference:");
        numbers1.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);  // Method reference
        
        // =====================================================================
        // APPROACH 3: Immutable list with List.of() (Java 9+)
        // =====================================================================
        /*
         * Using List.of() creates an immutable list which is generally safer
         * for shared data. This is preferred when mutability isn't required.
         * 
         * Note: List.of() doesn't allow null elements and throws
         * UnsupportedOperationException on modification attempts.
         */
        System.out.println("\n[Java 9+] Immutable list with List.of():");
        List<Integer> numbers2 = List.of(10, 15, 8, 49, 25, 98, 32); // Immutable
        numbers2.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
        
        // =====================================================================
        // APPROACH 4: Java 16+ toList() for immutable results
        // =====================================================================
        /*
         * Java 16 introduced Stream.toList() as a better alternative to
         * Collectors.toList() when you want an immutable result.
         * 
         * Benefits:
         * - More concise syntax
         * - Clearly communicates immutable intent
         * - Doesn't guarantee implementation type (better abstraction)
         */
        System.out.println("\n[Java 16+] Using Stream.toList() for immutable results:");
        List<Integer> evenNumbers2 = Arrays.asList(1, 4, 5, 8, 10, 13, 16).stream()
                .filter(n -> n % 2 == 0)
                .toList();  // Immutable list (Java 16+)
        System.out.println("Even numbers (immutable): " + evenNumbers2);
        
        // =====================================================================
        // APPROACH 5: Modern best practice with helper method
        // =====================================================================
        /*
         * Shows complete modern best practices:
         * 1. List.of() for immutable source
         * 2. Method reference for predicate
         * 3. toList() for immutable result
         * 4. Helper method improves readability and testability
         */
        System.out.println("\n[Modern Best Practice] Full example:");
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers3 = numbers3.stream()
                .filter(ModernEvenNumbers::isEven)  // Method reference
                .toList();  // Immutable list (Java 16+)
        System.out.println("Modern Even Numbers: " + evenNumbers3);
    }

    /**
     * Pure function that determines if a number is even.
     * 
     * <p>Separated for:
     * <ul>
     *   <li>Better readability in stream pipelines</li>
     *   <li>Easier unit testing</li>
     *   <li>Potential reuse</li>
     *   <li>Clearer expression of business logic</li>
     * </ul>
     * 
     * @param num The number to evaluate
     * @return true if the number is even (divisible by 2), false otherwise
     */
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
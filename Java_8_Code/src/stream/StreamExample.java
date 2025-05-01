package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        
        // ===================================================================
        // LEGACY APPROACH (Before Java 8)
        // ===================================================================
        /*
         * Before Java 8, we would manually iterate through collections using loops
         * This approach is more verbose and requires more boilerplate code
         */
        List<String> legacyList = new ArrayList<>();
        legacyList.add("Amit");
        legacyList.add("Rahul");
        legacyList.add("Sneha");
        legacyList.add("Priya");
        legacyList.add("Atharva");
        
        // Filtering names starting with 'A' the old way
        List<String> filteredNamesLegacy = new ArrayList<>();
        for (String name : legacyList) {
            if (name.startsWith("A")) {
                filteredNamesLegacy.add(name);
            }
        }
        System.out.println("Legacy Approach: " + filteredNamesLegacy);
        
        // ===================================================================
        // MODERN APPROACHES (Java 8+)
        // ===================================================================
        
        // -------------------------------------------------------------------
        // Approach 1: Using ArrayList and Stream (Java 8+)
        // -------------------------------------------------------------------
        /*
         * Using ArrayList with streams - mutable collection
         * Good when you need to modify the list later
         * ArrayList is resizable and allows nulls
         */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Amit");
        arrayList.add("Rahul");
        arrayList.add("Sneha");
        arrayList.add("Priya");
        arrayList.add("Atharva");
        
        List<String> elementsFromArrayList = arrayList.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());
        System.out.println("ArrayList Stream Result: " + elementsFromArrayList);
        
        // -------------------------------------------------------------------
        // Approach 2: Using Arrays.asList() (Java 1.2+)
        // -------------------------------------------------------------------
        /*
         * Arrays.asList() creates a fixed-size list backed by the original array
         * Semi-mutable - can change elements but can't add/remove
         * Allows null values
         * Good for quick list creation when size won't change
         */
        List<String> asList = Arrays.asList("Amit", "Rahul", "Sneha", "Priya", "Atharva");
        List<String> elementsFromAsList = asList.stream()
            .filter(name -> name.startsWith("P"))
            .collect(Collectors.toList());
        System.out.println("Arrays.asList() Stream Result: " + elementsFromAsList);
        
        // -------------------------------------------------------------------
        // Approach 3: Using forEach directly (Java 8+)
        // -------------------------------------------------------------------
        /*
         * Directly consuming the stream with forEach
         * Good when you don't need to collect results
         * More memory efficient for large datasets
         */
        List<String> forEachList = Arrays.asList("Amit", "Rahul", "Sneha", "Priya", "Atharva");
        System.out.print("forEach Result: ");
        forEachList.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(System.out::println);
        
        // -------------------------------------------------------------------
        // Approach 4: Using List.of() (Java 9+)
        // -------------------------------------------------------------------
        /*
         * List.of() creates an immutable list (most modern approach)
         * Doesn't allow null values
         * Most memory efficient for fixed collections
         * Best for read-only scenarios
         */
        List<String> listOf = List.of("Amit", "Rahul", "Sneha", "Priya", "Atharva");
        System.out.print("List.of() Result: ");
        listOf.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(System.out::println);
        
        // ===================================================================
        // BEST PRACTICES SUMMARY
        // ===================================================================
        /*
         * BEST APPROACHES:
         * 
         * 1. For mutable collections (need to add/remove later):
         *    List<String> list = new ArrayList<>();
         *    list.add("Amit");
         *    // ... other operations
         * 
         * 2. For fixed-size collections where elements might change:
         *    List<String> list = Arrays.asList("Amit", "Rahul");
         * 
         * 3. For completely immutable collections (Java 9+):
         *    List<String> list = List.of("Amit", "Rahul"); // BEST for constants
         * 
         * 4. For stream operations:
         *    - Use collect() when you need results
         *    - Use forEach() when processing without storing
         *    - Use method references (System.out::println) for cleaner code
         * 
         * VERSION GUIDE:
         * - Java 1.2: Arrays.asList() introduced
         * - Java 8: Streams API introduced (major change)
         * - Java 9: List.of() introduced (immutable collections)
         */
    }
}
package stream;

import java.util.List;

public class Java16StreamExample {
	public static void main(String[] args) {
		// Immutable list with List.of() - best for fixed data
		List<String> names = List.of("Amit", "Rahul", "Sneha", "Priya", "Atharva");

		// Single optimal stream pipeline:
		// 1. Filter names starting with "A"
		// 2. Convert directly to immutable list (Java 16+ toList())
		List<String> result = names.stream().filter(name -> name.startsWith("A")).toList();

		// Clean output with text blocks (Java 15+)
		System.out.printf("""
				Filtered names starting with 'A':
				%s
				Total matches: %d
				""", result, result.size());
	}
}

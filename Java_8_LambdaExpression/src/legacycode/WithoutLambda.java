package legacycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WithoutLambda {

	public static void main(String[] args) {
		// Legacy style (pre-Java 8) - Manual iteration
		List<String> list = Arrays.asList("Apple", "Banana", "Avocado", "Mango", "Apricot");
		List<String> elements = new ArrayList<>();

		for (String name : list) {
			if (name.contains("A")) {
				elements.add(name);
			}
		}
		System.out.println("Legacy Output: " + elements);

	}
}
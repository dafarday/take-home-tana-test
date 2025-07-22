import java.util.*;

public class Question4_FirstUniqueProduct {
    // Returns the first product that occurs only once, or null if none
    public static String firstUniqueProduct(String[] products) {
        Map<String, Integer> count = new LinkedHashMap<>(); // LinkedHashMap to preserve order
        for (String p : products) {
            count.put(p, count.getOrDefault(p, 0) + 1); // Count occurrences
        }
        for (String p : products) {
            if (count.get(p) == 1) return p; // Return first unique
        }
        return null;
    }

    public static void main(String[] args) {
        // Example
        String[] arr1 = {"Apple", "Computer", "Apple", "Bag"};
        System.out.println(firstUniqueProduct(arr1)); // Should print: Computer
        // All repeated
        String[] arr2 = {"A", "B", "A", "B"};
        System.out.println(firstUniqueProduct(arr2)); // Should print: null
        // Unique in middle
        String[] arr3 = {"A", "B", "C", "A", "B"};
        System.out.println(firstUniqueProduct(arr3)); // Should print: C
    }
} 
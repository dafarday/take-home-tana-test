import java.util.*;

public class Question2_UniqueSums {
    // Returns the number of unique ways to sum elements to match the result
    public static int uniqueSums(int result, int[] array) {
        Set<String> uniqueCombos = new HashSet<>(); // To store unique combinations as strings
        findSums(array, 0, result, new ArrayList<>(), uniqueCombos);
        return uniqueCombos.size();
    }

    // Helper method: recursively finds all unique combinations that sum to target
    private static void findSums(int[] array, int start, int target, List<Integer> current, Set<String> uniqueCombos) {
        if (target == 0) {
            // Sort and add the combination as a string to ensure uniqueness
            List<Integer> sorted = new ArrayList<>(current);
            Collections.sort(sorted);
            uniqueCombos.add(sorted.toString());
            return;
        }
        for (int i = start; i < array.length; i++) {
            if (array[i] > target) continue; // Skip if the number is too large
            current.add(array[i]);
            findSums(array, i + 1, target - array[i], current, uniqueCombos);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        System.out.println(uniqueSums(10, arr1)); // Should print: 3

        int[] arr2 = {1,2,4,7,5};
        System.out.println(uniqueSums(17, arr2)); // Should print: 1

        int[] arr3 = {2,2,2,2};
        System.out.println(uniqueSums(4, arr3)); // Should print: 1
    }
}
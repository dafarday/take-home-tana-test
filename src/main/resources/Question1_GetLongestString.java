import java.util.*;

public class Question1_GetLongestString {
    // Returns the longest string that has no consecutive identical characters and only valid characters
    public static String getLongestString(List<Character> characters, String[] strings) {
        Set<Character> validChars = new HashSet<>(characters); // Set for fast lookup
        String longest = null;
        for (String s : strings) {
            if (!containsOnlyValidChars(s, validChars)) continue; // Skip if contains invalid char
            if (hasConsecutiveRepeats(s)) continue; // Skip if has consecutive repeats
            if (longest == null || s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    // Checks if string contains only valid characters
    private static boolean containsOnlyValidChars(String s, Set<Character> validChars) {
        for (char c : s.toCharArray()) {
            if (!validChars.contains(c)) return false;
        }
        return true;
    }

    // Checks for consecutive identical characters
    private static boolean hasConsecutiveRepeats(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example scenario
        List<Character> chars = Arrays.asList('A', 'B', 'C', 'D');
        String[] arr = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};
        System.out.println(getLongestString(chars, arr)); // Should print: ABCDABDCA
        // Edge case: all invalid
        String[] arr2 = {"AA", "BB", "CC"};
        System.out.println(getLongestString(chars, arr2)); // Should print: null
        // Edge case: all valid, single char
        String[] arr3 = {"A", "B", "C", "D"};
        System.out.println(getLongestString(chars, arr3)); // Should print: A (or B/C/D)
    }
} 
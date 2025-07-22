import java.util.*;

public class Question5_ClosestMinimumDistance {
    // Returns the distance between the two closest minimums
    public static int closestMinDistance(int[] a) {
        int min = Arrays.stream(a).min().getAsInt(); // Find minimum value
        int prev = -1, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min) {
                if (prev != -1) minDist = Math.min(minDist, i - prev); // Update min distance
                prev = i;
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        // Example
        int[] arr1 = {1,2,3,1,4,5,2};
        System.out.println(closestMinDistance(arr1)); // Should print: 3
        // Multiple minimums
        int[] arr2 = {2,1,3,4,1,5,1};
        System.out.println(closestMinDistance(arr2)); // Should print: 2
        // All same
        int[] arr3 = {5,5,5,5};
        System.out.println(closestMinDistance(arr3)); // Should print: 1
    }
}
import java.util.*;

public class Question3_MakeArrayZero {
    // Returns 1 if possible to make all elements zero except the first, else 0
    public static int canMakeZero(int[] a) {
        // Work backwards: reduce each a[i] by a[i-1] until possible
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < 0) return 0; // Negative not allowed
            a[i] = a[i] % a[i-1]; // Reduce a[i] by a[i-1] as many times as possible
        }
        // Check if all except the first are zero
        for (int i = 1; i < a.length; i++) {
            if (a[i] != 0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        // Example
        int[] arr1 = {1,2,3};
        System.out.println(canMakeZero(Arrays.copyOf(arr1, arr1.length))); // Should print: 1
        // All powers of 2
        int[] arr2 = {2,4,8};
        System.out.println(canMakeZero(Arrays.copyOf(arr2, arr2.length))); // Should print: 1
        // Already reducible
        int[] arr3 = {1,2,2};
        System.out.println(canMakeZero(Arrays.copyOf(arr3, arr3.length))); // Should print: 1
        // Not possible
        int[] arr4 = {1,2,5};
        System.out.println(canMakeZero(Arrays.copyOf(arr4, arr4.length))); // Should print: 0
    }
} 
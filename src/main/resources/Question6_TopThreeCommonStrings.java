import java.util.*;

public class  Question6_TopThreeCommonStrings {
    // Returns the three most common strings, sorted alphabetically
    public static List<String> topThreeCommon(String sentence) {
        // Split the sentence into words and count frequencies
        String[] words = sentence.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Convert map to list of entries and sort
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());

        // Sort: first by descending frequency, then alphabetically
        entries.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue()); // frequency desc
            if (cmp == 0) {
                return a.getKey().compareTo(b.getKey()); // alphabetically asc
            }
            return cmp;
        });

        // Collect the top 3 entries
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, entries.size()); i++) {
            result.add(entries.get(i).getKey());
        }

        // Sort the result alphabetically as final step
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        String s1 = "hi there care to discuss algorithm basis or how to solve algorithm or";
        System.out.println(topThreeCommon(s1)); // Output: [algorithm, or, to]
    }
}

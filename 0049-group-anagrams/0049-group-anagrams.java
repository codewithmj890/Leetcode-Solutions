import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test 1: The standard example
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1: " + solver.groupAnagrams(test1));
        // Expected: [[eat, tea, ate], [bat], [tan, nat]] (Order of groups doesn't matter)
        
        // Test 2: Empty strings
        String[] test2 = {""};
        System.out.println("Test 2: " + solver.groupAnagrams(test2));
        // Expected: [[""]]
        
        // Test 3: Single characters
        String[] test3 = {"a"};
        System.out.println("Test 3: " + solver.groupAnagrams(test3));
        // Expected: [["a"]]
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
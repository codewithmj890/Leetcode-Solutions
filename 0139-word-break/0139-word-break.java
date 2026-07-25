import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test Case 1: "leetcode"
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        
        // Test Case 2: "applepenapple"
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        
        // Test Case 3: "catsandog" (Should be false, no way to segment perfectly unless you add og in dictionairy)
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        
        System.out.println("Final Result: " + solver.wordBreak(s1, dict1) + "\n"); // Expected: true
        System.out.println("Final Result: " + solver.wordBreak(s2, dict2) + "\n"); // Expected: true
        System.out.println("Final Result: " + solver.wordBreak(s3, dict3) + "\n"); // Expected: false
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further j's once true
                }
            }
        }

        System.out.println("String " + s);
        System.out.println("DP Array " + Arrays.toString(dp));
        return dp[n];
    }
}
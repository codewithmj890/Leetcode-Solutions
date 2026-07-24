class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test cases
        String test1 = "abc"; // Answer: 3 ("a", "b", "c")
        String test2 = "aaa"; // Answer: 6 ("a", "a", "a", "aa", "aa", "aaa")
        
        System.out.println("Palindromes in 'abc': " + solver.countSubstrings(test1));
        System.out.println("Palindromes in 'aaa': " + solver.countSubstrings(test2));
    }
}

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        
        return count;
    }
}
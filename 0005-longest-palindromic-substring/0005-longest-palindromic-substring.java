class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        String test1 = "babad"; 
        String test2 = "cbbd";  
        String test3 = "a";     
        
        System.out.println("Test 1: " + solver.longestPalindrome(test1));
        System.out.println("Test 2: " + solver.longestPalindrome(test2));
        System.out.println("Test 3: " + solver.longestPalindrome(test3));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0; 
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       
            int len2 = expandFromCenter(s, i, i + 1);   
            int len = Math.max(len1, len2);
            
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
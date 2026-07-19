import java.util.Arrays;

class Main{
    public static void main(String[] args){
        Solution solver = new Solution();
        String test1 = "abcabcbb"; 
        String test2 = "bbbbb";    
        String test3 = "pwwkew";   
        
        System.out.println("Test 1 length: " + solver.lengthOfLongestSubstring(test1));
        System.out.println("Test 2 length: " + solver.lengthOfLongestSubstring(test2));
        System.out.println("Test 3 length: " + solver.lengthOfLongestSubstring(test3));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; 
        java.util.Arrays.fill(lastSeen, -1);
        
        int maxLen = 0;
        int start = 0; 
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            
            
            if (lastSeen[c] >= start) {
                start = lastSeen[c] + 1;
            }
            
            lastSeen[c] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}
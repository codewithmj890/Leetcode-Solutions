import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test 1: The standard example
        int[] test1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Result 1: " + solver.lengthOfLIS(test1)); // Expected: 4
        
        // Test 2: An array of all identical numbers
        int[] test2 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Result 2: " + solver.lengthOfLIS(test2)); // Expected: 1
        
        // Test 3: A strictly decreasing array
        int[] test3 = {5, 4, 3, 2, 1};
        System.out.println("Result 3: " + solver.lengthOfLIS(test3)); // Expected: 1
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length]; 
        int size = 0; 

        for (int num : nums) {
            int lo = 0, hi = size;
            
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            
            tails[lo] = num; 
            if (lo == size) size++;
        }

        return size;
    }
}
class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        // Test 1: Standard case. Expected: 6 (from 2 * 3)
        int[] test1 = {2, 3, -2, 4};
        
        // Test 2: The double negative case. Expected: 24
        int[] test2 = {-2, 3, -4};
        
        // Test 3: The zero reset case. Expected: 2
        int[] test3 = {0, 2};
        
        System.out.println("Test 1 Result: " + solver.maxProduct(test1));
        System.out.println("Test 2 Result: " + solver.maxProduct(test2));
        System.out.println("Test 3 Result: " + solver.maxProduct(test3));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // if current number is negative, swap max and min
            if (curr < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(curr, maxEndingHere * curr);
            minEndingHere = Math.min(curr, minEndingHere * curr);

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}
class Main {
    public static void main(String[] args){
        Solution solver = new Solution();
        
        // Test 1: The standard rotation
        int[] test1 = {4, 5, 6, 7, 0, 1, 2};
        
        // Test 2: Only rotated a little bit
        int[] test2 = {3, 4, 5, 1, 2};
        
        // Test 3: Not rotated at all! (Edge case)
        int[] test3 = {11, 13, 15, 17};
        
        System.out.println("Test 1 Result: " + solver.findMin(test1));
        System.out.println("Test 2 Result: " + solver.findMin(test2));
        System.out.println("Test 3 Result: " + solver.findMin(test3));
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is in the right half, excluding mid
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }
        
        return nums[left];
    }
}
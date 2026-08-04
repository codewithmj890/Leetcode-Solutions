class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();
        
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        
        // Test 1: Target exists in the right (rotated) half
        System.out.println("Find 0 (Expected 4): " + solver.search(nums, 0));
        
        // Test 2: Target exists in the left (unrotated) half
        System.out.println("Find 5 (Expected 1): " + solver.search(nums, 5));
        
        // Test 3: Target does not exist
        System.out.println("Find 3 (Expected -1): " + solver.search(nums, 3));
        
        // Test 4: Edge case of array size 1
        int[] single = {1};
        System.out.println("Find 1 in [1] (Expected 0): " + solver.search(single, 1));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}